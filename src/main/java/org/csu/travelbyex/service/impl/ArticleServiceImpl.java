package org.csu.travelbyex.service.impl;

import org.csu.travelbyex.domain.*;
import org.csu.travelbyex.persistence.ArticleMapper;
import org.csu.travelbyex.persistence.CommentMapper;
import org.csu.travelbyex.persistence.ReplyMapper;
import org.csu.travelbyex.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    CommentMapper commentMapper;

    // 插入文章
    @Override
    public Integer insertArticle(Article article) {
        articleMapper.insert(article);
        return article.getArticleId();
    }

    // 查询
    @Override
    public List getArticlesByAuthorId(String authorId) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andAuthorIdLike(authorId);
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
        Collections.sort(articles);
        return articles;
    }

    @Override
    public List getArticlesByLP(String largePlace) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andLpLike(largePlace);
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
        Collections.sort(articles);
        return articles;
    }

    @Override
    public List getArticlesBySP(String smallPlace) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andSpLike(smallPlace);
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
        Collections.sort(articles);
        return articles;
    }

    @Override
    public List getArticlesBySpotName(String spotName) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andSpotNameLike(spotName);
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
        Collections.sort(articles);
        return articles;
    }

    @Override
    public List getArticlesByTag(String tag) {

        List<Article> articles = new ArrayList<>();

        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andTag1Like(tag);
        articles.addAll(articleMapper.selectByExampleWithBLOBs(articleExample));

        articleExample.clear();
        criteria = articleExample.createCriteria();
        criteria.andTag2Like(tag);
        articles.addAll(articleMapper.selectByExampleWithBLOBs(articleExample));

        articleExample.clear();
        criteria = articleExample.createCriteria();
        criteria.andTag3Like(tag);
        articles.addAll(articleMapper.selectByExampleWithBLOBs(articleExample));

        // 去重，防止一篇文章三个标签相同被搜索多遍
        Set<Article> articles1 = new HashSet<>();
        articles1.addAll(articles);
        articles.clear();
        articles.addAll(articles1);

        Collections.sort(articles);
        return articles;
    }

    @Override
    public List getArticlesByTags(List tags) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andTag1In(tags);
        List articles = articleMapper.selectByExampleWithBLOBs(articleExample);

        articleExample.clear();
        criteria = articleExample.createCriteria();
        criteria.andTag2In(tags);
        articles.addAll(articleMapper.selectByExampleWithBLOBs(articleExample));

        articleExample.clear();
        criteria = articleExample.createCriteria();
        criteria.andTag3In(tags);
        articles.addAll(articleMapper.selectByExampleWithBLOBs(articleExample));

        // 去重，防止一篇文章三个标签相同被搜索多遍
        Set<Article> articles1 = new HashSet<>();
        articles.addAll(articles);
        articles.clear();
        articles.addAll(articles1);

        Collections.sort(articles);
        return articles;
    }

    @Override
    public Article getArticleById(Integer articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public List getArticlesByTime(Date date1, Date date2) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(date1);
        criteria.andTimeLessThanOrEqualTo(date2);
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
        Collections.sort(articles);
        return articles;
    }

    @Override
    public List getArticlesOrderedByLikes() {

        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause("likes desc");
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
        return articles;
    }

    //修改
    @Override
    public void updateArticle(Article article) {
        articleMapper.updateByPrimaryKey(article);
    }

    // 删除
    @Override
    public void deleteArticleById(Integer articleId) {
        articleMapper.deleteByPrimaryKey(articleId);
    }


    // 评论
    @Override
    public void insertComment(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public List getCommentsByArticleId(Integer articleId) {

        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        List<Comment> comments = commentMapper.selectByExampleWithBLOBs(commentExample);
        Collections.sort(comments);
        return comments;

    }

    // 回复
    @Override
    public void insertReply(Reply reply) {
        replyMapper.insert(reply);
    }

    @Override
    public List getRepliesByCommentId(Integer commentId) {

        ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andCommentIdEqualTo(commentId);
        List<Reply> replies = replyMapper.selectByExampleWithBLOBs(replyExample);
        Collections.sort(replies);
        return replies;
    }

}
