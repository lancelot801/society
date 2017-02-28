package cn.joongky.society.pojo;

import java.util.Date;

public class ActivityActor {
    private String activityActorId;

    private String activityId;

    private String actorId;

    private Date joinedTime;

    public String getActivityActorId() {
        return activityActorId;
    }

    public void setActivityActorId(String activityActorId) {
        this.activityActorId = activityActorId == null ? null : activityActorId.trim();
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId == null ? null : actorId.trim();
    }

    public Date getJoinedTime() {
        return joinedTime;
    }

    public void setJoinedTime(Date joinedTime) {
        this.joinedTime = joinedTime;
    }
}