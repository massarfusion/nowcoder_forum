package com.nowcoder.community.entity;

import java.util.Date;

public class DiscussPost {

    private int id;
    private int userId;
    private String title;
    private String Content;
    private int type;

    private int status;

    private Date createTime;

    private int commentCount;

    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DiscussPost{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", Content='").append(Content).append('\'');
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }

}

