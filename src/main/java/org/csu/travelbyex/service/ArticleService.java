package org.csu.travelbyex.service;

import org.csu.travelbyex.domain.Article;
import org.csu.travelbyex.domain.Comment;
import org.csu.travelbyex.domain.Reply;

import java.util.List;

public interface ArticleService {

    //插入文章
    public Integer insertArticle(Article article);

    //查询
    public List getArticlesByAuthorId(String authorId);

    public List getArticlesByLP(String largePlace);

    public List getArticlesBySP(String smallPlace);

    public List getArticlesBySpotName(String spotName);

    public List getArticlesByTag(String tag);

    public List getArticlesByTags(List tags);

    public Article getArticleById(Integer articleId);

    //修改
    public void updateArticle(Article article);

    //删除
    public void deleteArticleById(Integer articleId);

    //评论
    public void inserComment(Comment comment);

    public List getCommentsByArticleId(Integer articleId);

    //回复
    public void insertReply(Reply reply);

    public List getRepliesByCommentId(Integer commentId);

}
