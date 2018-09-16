package org.csu.travelbyex.controller;


import io.swagger.annotations.ApiOperation;
import org.csu.travelbyex.core.AccountUp;
import org.csu.travelbyex.core.Result;
import org.csu.travelbyex.core.ResultGenerator;
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
            ensureSpotExists(article);
            ensureTagExists(article);
            articleService.insertArticle(article);
            return ResultGenerator.success("发布成功！");
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
        Article article = articleService.getArticleById(articleId);
        if (article == null) return ResultGenerator.fail("文章不存在");
        List<Comment> comments = articleService.getCommentsByArticleId(articleId);
        List<Reply> replies = articleService.getRepliesByCommentId(articleId);
        Map message = new LinkedHashMap();
        message.put("article", article);
        message.put("comments", comments);
        message.put("replies", replies);
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


    @ApiOperation(value = "查询某一用户的所有文章")
    @GetMapping("/articlesByAuthor")
    public Result getArticlesByAuthorId(@RequestParam(value = "authorId") String authorId)
    {
        List<Article> articles = articleService.getArticlesByAuthorId(authorId);
        List<AccountUp> accountUps = new ArrayList<>();
        for (Article article :
                articles) {
            Account account = accountService.getAccountByUserId(article.getAuthorId());
            AccountInfo accountInfo = accountService.getAccountInfoByUserId(article.getAuthorId());
            AccountUp accountUp = new AccountUp();
            AccountUtil.upAccountUp(accountUp, account, accountInfo);

            accountUps.add(accountUp);
        }
        Map map = new LinkedHashMap();
        map.put("articles", articles);
        map.put("accountUps", accountUps);
        if (articles.size() == 0)
            return ResultGenerator.fail("暂未发布");
        return ResultGenerator.success(map);

    }


    @ApiOperation(value = "评论文章")
    @PostMapping("/comments")
    public Result insertComment(@RequestBody Comment comment)
    {
        try
        {
            articleService.insertComment(comment);
            return ResultGenerator.success("评论成功！");
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
            articleService.insertReply(reply);
            return ResultGenerator.success("回复成功！");
        }catch (Exception e)
        {
            return ResultGenerator.fail("回复失败！");
        }


    }


    @ApiOperation(value = "根据地点、标签查询文章")
    @GetMapping("/search/articles")
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

            if (articles.size() == 0)
                return ResultGenerator.fail("无此类文章！");

            return ResultGenerator.success(articles);
        }
    }

    // 如果数据库中没有用户输入的景点，就将景点插入数据库
    private void ensureSpotExists(Article article)
    {
        String spotName = article.getSpotName();
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
        if (tag == null) tagService.insertTag(new Tag(article.getTag1()));
        tag = tagService.selectTagByTagName(article.getTag2());
        if (tag == null) tagService.insertTag(new Tag(article.getTag2()));
        tag = tagService.selectTagByTagName(article.getTag3());
        if (tag == null) tagService.insertTag(new Tag(article.getTag3()));
    }

}
