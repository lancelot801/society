package cn.joongky.society.pojo;

import java.util.Date;

public class Opinion {
    private String opinionId;

    private Date createdTime;

    private String submiter;

    private String content;

    private String opinionTitle;

    private String status;

    public String getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(String opinionId) {
        this.opinionId = opinionId == null ? null : opinionId.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getSubmiter() {
        return submiter;
    }

    public void setSubmiter(String submiter) {
        this.submiter = submiter == null ? null : submiter.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getOpinionTitle() {
        return opinionTitle;
    }

    public void setOpinionTitle(String opinionTitle) {
        this.opinionTitle = opinionTitle == null ? null : opinionTitle.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}