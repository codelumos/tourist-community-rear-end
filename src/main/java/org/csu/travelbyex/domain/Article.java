package org.csu.travelbyex.domain;

public class Article {
    private Integer articleId;

    private String authorId;

    private String title;

    private String coverPath;

    private Integer likes;

    private Integer readers;

    private String lp;

    private String sp;

    private String spotName;

    private String tag1;

    private String tag2;

    private String tag3;

    private String contentEx;

    public Article(Integer articleId, String authorId, String title, String coverPath, Integer likes, Integer readers, String lp, String sp, String spotName, String tag1, String tag2, String tag3, String contentEx) {
        this.articleId = articleId;
        this.authorId = authorId;
        this.title = title;
        this.coverPath = coverPath;
        this.likes = likes;
        this.readers = readers;
        this.lp = lp;
        this.sp = sp;
        this.spotName = spotName;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.contentEx = contentEx;
    }

    public Article() {
        super();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath == null ? null : coverPath.trim();
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getReaders() {
        return readers;
    }

    public void setReaders(Integer readers) {
        this.readers = readers;
    }

    public String getLp() {
        return lp;
    }

    public void setLp(String lp) {
        this.lp = lp == null ? null : lp.trim();
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp == null ? null : sp.trim();
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName == null ? null : spotName.trim();
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1 == null ? null : tag1.trim();
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2 == null ? null : tag2.trim();
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3 == null ? null : tag3.trim();
    }

    public String getContentEx() {
        return contentEx;
    }

    public void setContentEx(String contentEx) {
        this.contentEx = contentEx == null ? null : contentEx.trim();
    }
}