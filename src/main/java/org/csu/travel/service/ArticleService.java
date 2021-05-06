package org.csu.travel.service;

import org.csu.travel.domain.Article;
import org.csu.travel.domain.Comment;
import org.csu.travel.domain.Reply;

import java.util.Date;
import java.util.List;

public interface ArticleService {

    // 插入文章
    Integer insertArticle(Article article);

    // 查询
    List getArticlesByAuthorId(String authorId);

    List getArticlesByLP(String largePlace);

    List getArticlesBySP(String smallPlace);

    List getArticlesBySpotName(String spotName);

    List getArticlesByTag(String tag);

    List getArticlesByTags(List tags);

    Article getArticleById(Integer articleId);

    List getArticlesByTime(Date date1, Date date2);

    List getArticlesOrderedByLikes();

    // 修改
    void updateArticle(Article article);

    // 删除
    void deleteArticleById(Integer articleId);

    // 评论
    void insertComment(Comment comment);

    List getCommentsByArticleId(Integer articleId);

    // 回复
    void insertReply(Reply reply);

    List getRepliesByCommentId(Integer commentId);

}
