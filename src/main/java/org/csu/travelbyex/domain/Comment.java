package org.csu.travelbyex.domain;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer articleId;

    private String authorId;

    private Date time;

    private String contentEx;

    public Comment(Integer commentId, Integer articleId, String authorId, Date time, String contentEx) {
        this.commentId = commentId;
        this.articleId = articleId;
        this.authorId = authorId;
        this.time = time;
        this.contentEx = contentEx;
    }

    public Comment() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContentEx() {
        return contentEx;
    }

    public void setContentEx(String contentEx) {
        this.contentEx = contentEx == null ? null : contentEx.trim();
    }
}