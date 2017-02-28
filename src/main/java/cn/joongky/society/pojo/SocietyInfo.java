package cn.joongky.society.pojo;

import java.util.Date;

public class SocietyInfo {
    private String societyId;

    private String societyName;

    private String logoUrl;

    private String introduction;

    private String details;

    private Integer membersCount;

    private Date createdTime;

    private Float societyStar;

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId == null ? null : societyId.trim();
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName == null ? null : societyName.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Integer getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(Integer membersCount) {
        this.membersCount = membersCount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Float getSocietyStar() {
        return societyStar;
    }

    public void setSocietyStar(Float societyStar) {
        this.societyStar = societyStar;
    }
}