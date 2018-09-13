package org.csu.travelbyex.service.impl;

import org.csu.travelbyex.domain.*;
import org.csu.travelbyex.persistence.ArticleMapper;
import org.csu.travelbyex.persistence.CommentMapper;
import org.csu.travelbyex.persistence.ReplyMapper;
import org.csu.travelbyex.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    CommentMapper commentMapper;

    //插入文章
    @Override
    public Integer insertArticle(Article article){
        articleMapper.insert(article);
        return article.getArticleId();
    }

    //查询
    @Override
    public List getArticlesByAuthorId(String authorId){
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andAuthorIdEqualTo(authorId);
        return articleMapper.selectByExampleWithBLOBs(articleExample);
    }

    @Override
    public List getArticlesByLP(String largePlace){
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andLpEqualTo(largePlace);
        return articleMapper.selectByExampleWithBLOBs(articleExample);
    }

    @Override
    public List getArticlesBySP(String smallPlace){
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andSpEqualTo(smallPlace);
        return articleMapper.selectByExampleWithBLOBs(articleExample);
    }

    @Override
    public List getArticlesBySpotName(String spotName){
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andSpEqualTo(spotName);
        return articleMapper.selectByExampleWithBLOBs(articleExample);
    }

    @Override
    public List getArticlesByTag(String tag){

        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andTag1EqualTo(tag);
        List articles = articleMapper.selectByExampleWithBLOBs(articleExample);

        criteria.andTag1IsNotNull();
        criteria.andTag2EqualTo(tag);
        articles.addAll( articleMapper.selectByExampleWithBLOBs(articleExample) );

        criteria.andTag2IsNotNull();
        criteria.andTag3EqualTo(tag);
        articles.addAll( articleMapper.selectByExampleWithBLOBs(articleExample) );

        return articles;
    }

    @Override
    public List getArticlesByTags(List tags){
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andTag1In(tags);
        List articles = articleMapper.selectByExampleWithBLOBs(articleExample);

        criteria.andTag1IsNotNull();
        criteria.andTag2In(tags);
        articles.addAll( articleMapper.selectByExampleWithBLOBs(articleExample) );

        criteria.andTag2IsNotNull();
        criteria.andTag3In(tags);
        articles.addAll( articleMapper.selectByExampleWithBLOBs(articleExample) );

        return articles;
    }

    public Article getArticleById(Integer articleId){
        return articleMapper.selectByPrimaryKey(articleId);
    }

    //修改
    public void updateArticle(Article article){
        articleMapper.updateByPrimaryKey(article);
    }

    //删除
    @Override
    public void deleteArticleById(Integer articleId){
        articleMapper.deleteByPrimaryKey(articleId);
    }

    //评论
    @Override
    public void inserComment(Comment comment){
        commentMapper.insert(comment);
    }

    @Override
    public List getCommentsByArticleId(Integer articleId){

        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        return commentMapper.selectByExampleWithBLOBs(commentExample);

    }

    //回复
    @Override
    public void insertReply(Reply reply){
        replyMapper.insert(reply);
    }

    @Override
    public List getRepliesByCommentId(Integer commentId){

        ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andCommentIdEqualTo(commentId);
        return replyMapper.selectByExampleWithBLOBs(replyExample);

    }

}
