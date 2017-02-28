package cn.joongky.society.pojo;

import java.util.Date;

public class MemberApply {
    private String applyId;

    private String applerId;

    private Date appliedTime;

    private Date checkedTime;

    private String feedbackId;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getApplerId() {
        return applerId;
    }

    public void setApplerId(String applerId) {
        this.applerId = applerId == null ? null : applerId.trim();
    }

    public Date getAppliedTime() {
        return appliedTime;
    }

    public void setAppliedTime(Date appliedTime) {
        this.appliedTime = appliedTime;
    }

    public Date getCheckedTime() {
        return checkedTime;
    }

    public void setCheckedTime(Date checkedTime) {
        this.checkedTime = checkedTime;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId == null ? null : feedbackId.trim();
    }
}