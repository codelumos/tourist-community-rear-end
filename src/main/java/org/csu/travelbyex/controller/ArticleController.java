package org.csu.travelbyex.controller;


import io.swagger.annotations.ApiOperation;
import org.csu.travelbyex.core.*;
import org.csu.travelbyex.domain.*;
import org.csu.travelbyex.service.AccountService;
import org.csu.travelbyex.service.ArticleService;
import org.csu.travelbyex.service.SpotService;
import org.csu.travelbyex.service.TagService;
import org.csu.travelbyex.util.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    SpotService spotService;
    @Autowired
    TagService tagService;
    @Autowired
    AccountService accountService;


    @ApiOperation(value = "发布一篇文章", notes = "/")
    @PostMapping("/articles")
    public Result insertArticle(@RequestBody Article article)
    {
        try
        {
            if (article.getTime() == null)
                article.setTime(new Date());
            ensureSpotExists(article);
            ensureTagExists(article);
            if (article.getCoverPath() == null || article.getCoverPath().equals(""))
                article.setCoverPath("http://img1.lotour.net/Inspiration/2018/0802/20180802160830772838853_1920.jpg");

            int articleId = articleService.insertArticle(article);
            return ResultGenerator.success(articleId);
        }catch (Exception e)
        {
            return ResultGenerator.fail("发布失败！");
        }
    }


    @ApiOperation(value = "修改文章")
    @PutMapping("/articles")
    public Result updateArticle(@RequestBody Article article)
    {
        try{
            if (article.getTime() == null)
                article.setTime(new Date());
            ensureSpotExists(article);
            ensureTagExists(article);
            articleService.updateArticle(article);
            return ResultGenerator.success("更新成功");
        }catch (Exception e)
        {
            return ResultGenerator.fail("更新失败");
        }
    }


    @ApiOperation(value = "根据articleId查询文章")
    @GetMapping("/articles")
    public Result getArticleByArticleId(@RequestParam(value = "articleId") Integer articleId)
    {
        // 文章信息
        Article article = articleService.getArticleById(articleId);

        // 文章作者信息
        AccountUp accountUp = getAccountUp(article.getAuthorId());

        // 文章评论信息
        List<Comment> comments = articleService.getCommentsByArticleId(articleId);
        List<CommentUp> commentUps = new ArrayList<>();
        commentsToCommentUps(comments, commentUps);

        // 文章回复信息
        List<Reply> replies = new ArrayList<>();
        for (Comment comment :
                comments) {
            replies.addAll(articleService.getRepliesByCommentId(comment.getCommentId()));
        }
        List<ReplyUp> replyUps = new ArrayList<>();
        repliesToReplyUps(replies, replyUps);


        Map message = new LinkedHashMap();
        message.put("article", article);
        message.put("accountUp", accountUp);
        message.put("commentUps", commentUps);
        message.put("replyUps", replyUps);

        // 浏览量加一
        article.setReaders(article.getReaders() + 1);
        articleService.updateArticle(article);

        return ResultGenerator.success(message);
    }


    // 还需测试有评论和回复的情况
    @ApiOperation(value = "根据articleId删除文章")
    @DeleteMapping("/articles")
    public Result deleteArticleByArticleId(@RequestParam(value = "articleId") Integer articleId)
    {
        try{
            articleService.deleteArticleById(articleId);
            return ResultGenerator.success("删除成功");
        }catch (Exception e)
        {
            return ResultGenerator.fail("删除失败");
        }
    }


    @ApiOperation(value = "评论文章")
    @PostMapping("/comments")
    public Result insertComment(@RequestBody Comment comment)
    {
        try
        {
            if (comment.getTime() == null)
                comment.setTime(new Date());
            articleService.insertComment(comment);
            CommentUp commentUp = new CommentUp();
            upComment(comment, commentUp);
            return ResultGenerator.success(commentUp);
        }catch (Exception e)
        {
            return ResultGenerator.fail("评论失败！");
        }

    }


    @ApiOperation(value = "回复评论")
    @PostMapping("/replies")
    public Result insertReply(@RequestBody Reply reply)
    {
        try
        {
            if (reply.getReplyTime() == null)
                reply.setReplyTime(new Date());
            articleService.insertReply(reply);
            ReplyUp replyUp = new ReplyUp();
            upReplyUp(reply, replyUp);
            return ResultGenerator.success(replyUp);
        }catch (Exception e)
        {
            return ResultGenerator.fail("回复失败！");
        }


    }


    @ApiOperation(value = "查询某一用户的所有文章")
    @GetMapping("/articlesByAuthor")
    public Result getArticlesByAuthorId(@RequestParam(value = "authorId") String authorId)
    {
        List<Article> articles = articleService.getArticlesByAuthorId(authorId);
        Map map = getArticlesAndAccountUps(articles);
        return ResultGenerator.success(map);
    }


    @ApiOperation(value = "根据keyword查询文章")
    @GetMapping("/articlesByKeyword")
    public Result getArticlesByKeyword(@RequestParam(value = "keyword") String keyword)
    {
        Set<Article> articles = new HashSet<>();
        try
        {
            int ArticleId = Integer.parseInt(keyword);
            Article article = articleService.getArticleById(ArticleId);
            if (article != null) articles.add(article);
        }catch (Exception e) {}
        finally {

            keyword = "%" + keyword + "%";

            List<Article> articles1 = articleService.getArticlesByAuthorId(keyword);
            if (articles1 != null) articles.addAll(articles1);
            articles1 = articleService.getArticlesByLP(keyword);
            if (articles1 != null) articles.addAll(articles1);
            articles1 = articleService.getArticlesBySP(keyword);
            if (articles1 != null) articles.addAll(articles1);
            articles1 = articleService.getArticlesBySpotName(keyword);
            if (articles1 != null) articles.addAll(articles1);
            articles1 = articleService.getArticlesByTag(keyword);
            if (articles1 != null) articles.addAll(articles1);

            // 排序
            List<Article> articles2 = new ArrayList<>();
            articles2.addAll(articles);
            Collections.sort(articles2);


            Map map = getArticlesAndAccountUps(articles2);
            return ResultGenerator.success(map);
        }
    }


    @ApiOperation(value = "根据时间查询文章")
    @GetMapping("/articlesByTime")
    public Result getArticlesByTime(@RequestParam(value = "time") Integer time)
    {
        Date date1 = null,date2 = null;

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.MONTH, time - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        date1 = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        date2 = calendar.getTime();

        List<Article> articles = articleService.getArticlesByTime(date1, date2);
        Map map = getArticlesAndAccountUps(articles);

        return ResultGenerator.success(map);

    }



    @ApiOperation(value = "根据标签查询文章")
    @GetMapping("articlesByTag")
    public Result getArticlesByTag(@RequestParam(value = "tag") String tag)
    {
        tag = "%" + tag + "%";
        List<Article> articles = articleService.getArticlesByTag(tag);
        Map map = getArticlesAndAccountUps(articles);
        return ResultGenerator.success(map);
    }


    @ApiOperation(value = "根据地点查询文章")
    @GetMapping("/articlesByPlace")
    public Result getArticlesByPlace(@RequestParam(value = "place") String place)
    {
        place = "%" + place + "%";
        Set<Article> articles = new HashSet<>();
        List<Article> articles1 = articleService.getArticlesByLP(place);
        articles.addAll(articles1);
        articles1 = articleService.getArticlesBySP(place);
        articles.addAll(articles1);
        articles1 = articleService.getArticlesBySpotName(place);
        articles.addAll(articles1);

        articles1.clear();
        articles1.addAll(articles);
        Collections.sort(articles1);

        Map map = getArticlesAndAccountUps(articles1);
        return ResultGenerator.success(map);
    }


    @ApiOperation(value = "按照点赞量查询前4的文章")
    @GetMapping("/articlesOrderedByLikes")
    public Result getArticlesOrderedByLikes()
    {
        List<Article> articles = articleService.getArticlesOrderedByLikes();
        return ResultGenerator.success(articles.subList(0, 4));
    }


    // 如果数据库中没有用户输入的景点，就将景点插入数据库
    private void ensureSpotExists(Article article)
    {
        String spotName = article.getSpotName();
        if (spotName == null)
            return;
        ScenicSpot scenicSpot = spotService.getScenicSpotByName(spotName);
        if (scenicSpot == null)
        {
            scenicSpot = new ScenicSpot();
            scenicSpot.setPlaceId(1);
            scenicSpot.setSpotName(spotName);
            spotService.insertSpot(scenicSpot);
        }
    }

    // 如果数据库中没有用户输入的标签，就将标签插入数据库
    private void ensureTagExists(Article article)
    {
        Tag tag = tagService.selectTagByTagName(article.getTag1());
        if (tag == null && article.getTag1() != null) tagService.insertTag(new Tag(article.getTag1()));
        tag = tagService.selectTagByTagName(article.getTag2());
        if (tag == null && article.getTag2() != null) tagService.insertTag(new Tag(article.getTag2()));
        tag = tagService.selectTagByTagName(article.getTag3());
        if (tag == null && article.getTag3() != null) tagService.insertTag(new Tag(article.getTag3()));
    }


    // 评论
    private void upComment(Comment comment, CommentUp commentUp)
    {
        commentUp.setArticleId(comment.getArticleId());
        commentUp.setAuthorId(comment.getAuthorId());
        commentUp.setCommentId(comment.getCommentId());
        commentUp.setContentEx(comment.getContentEx());
        commentUp.setTime(comment.getTime());
        AccountInfo accountInfo = accountService.getAccountInfoByUserId(comment.getAuthorId());
        commentUp.setImagePath(accountInfo.getImagePath());
        commentUp.setUserName(accountInfo.getUserName());
    }
    private void commentsToCommentUps(List<Comment> comments, List<CommentUp> commentUps)
    {
        for (Comment comment :
                comments) {
            CommentUp commentUp = new CommentUp();
            upComment(comment, commentUp);
            commentUps.add(commentUp);
        }
    }


    // 回复
    private void upReplyUp(Reply reply, ReplyUp replyUp)
    {
        replyUp.setAuthorId(reply.getAuthorId());
        replyUp.setCommentId(reply.getCommentId());
        replyUp.setContentEx(reply.getContentEx());
        replyUp.setReplyId(reply.getReplyId());
        replyUp.setToUserId(reply.getToUserId());
        replyUp.setReplyTime(reply.getReplyTime());
        AccountInfo accountInfo = accountService.getAccountInfoByUserId(reply.getAuthorId());
        replyUp.setImagePath(accountInfo.getImagePath());
        replyUp.setUserName(accountInfo.getUserName());
    }
    private void repliesToReplyUps(List<Reply> replies, List<ReplyUp> replyUps)
    {
        for (Reply reply :
                replies) {
            ReplyUp replyUp = new ReplyUp();
            upReplyUp(reply, replyUp);
            replyUps.add(replyUp);
        }
    }


    // 得到作者信息
    private AccountUp getAccountUp(String accountId)
    {
        Account account = accountService.getAccountByUserId(accountId);
        AccountInfo accountInfo = accountService.getAccountInfoByUserId(accountId);
        AccountUp accountUp = new AccountUp();
        AccountUtil.upAccountUp(accountUp, account, accountInfo);
        return accountUp;
    }

    // 返回文章及其对应的作者列表
    private Map getArticlesAndAccountUps(Collection<Article> articles)
    {
//        if (articles.size() == 0) return new HashMap();
        Map map = new LinkedHashMap();
        List<AccountUp> accountUps = new ArrayList<>();
        for (Article article:
                articles) {
            accountUps.add(getAccountUp(article.getAuthorId()));
        }
        map.put("articles", articles);
        map.put("accountUps", accountUps);
        return map;
    }


}
