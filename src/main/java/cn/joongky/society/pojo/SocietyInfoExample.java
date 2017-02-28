package cn.joongky.society.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocietyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SocietyInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSocietyIdIsNull() {
            addCriterion("society_id is null");
            return (Criteria) this;
        }

        public Criteria andSocietyIdIsNotNull() {
            addCriterion("society_id is not null");
            return (Criteria) this;
        }

        public Criteria andSocietyIdEqualTo(String value) {
            addCriterion("society_id =", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdNotEqualTo(String value) {
            addCriterion("society_id <>", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdGreaterThan(String value) {
            addCriterion("society_id >", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdGreaterThanOrEqualTo(String value) {
            addCriterion("society_id >=", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdLessThan(String value) {
            addCriterion("society_id <", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdLessThanOrEqualTo(String value) {
            addCriterion("society_id <=", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdLike(String value) {
            addCriterion("society_id like", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdNotLike(String value) {
            addCriterion("society_id not like", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdIn(List<String> values) {
            addCriterion("society_id in", values, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdNotIn(List<String> values) {
            addCriterion("society_id not in", values, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdBetween(String value1, String value2) {
            addCriterion("society_id between", value1, value2, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdNotBetween(String value1, String value2) {
            addCriterion("society_id not between", value1, value2, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyNameIsNull() {
            addCriterion("society_name is null");
            return (Criteria) this;
        }

        public Criteria andSocietyNameIsNotNull() {
            addCriterion("society_name is not null");
            return (Criteria) this;
        }

        public Criteria andSocietyNameEqualTo(String value) {
            addCriterion("society_name =", value, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameNotEqualTo(String value) {
            addCriterion("society_name <>", value, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameGreaterThan(String value) {
            addCriterion("society_name >", value, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameGreaterThanOrEqualTo(String value) {
            addCriterion("society_name >=", value, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameLessThan(String value) {
            addCriterion("society_name <", value, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameLessThanOrEqualTo(String value) {
            addCriterion("society_name <=", value, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameLike(String value) {
            addCriterion("society_name like", value, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameNotLike(String value) {
            addCriterion("society_name not like", value, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameIn(List<String> values) {
            addCriterion("society_name in", values, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameNotIn(List<String> values) {
            addCriterion("society_name not in", values, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameBetween(String value1, String value2) {
            addCriterion("society_name between", value1, value2, "societyName");
            return (Criteria) this;
        }

        public Criteria andSocietyNameNotBetween(String value1, String value2) {
            addCriterion("society_name not between", value1, value2, "societyName");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andDetailsIsNull() {
            addCriterion("details is null");
            return (Criteria) this;
        }

        public Criteria andDetailsIsNotNull() {
            addCriterion("details is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsEqualTo(String value) {
            addCriterion("details =", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotEqualTo(String value) {
            addCriterion("details <>", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsGreaterThan(String value) {
            addCriterion("details >", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("details >=", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLessThan(String value) {
            addCriterion("details <", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLessThanOrEqualTo(String value) {
            addCriterion("details <=", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLike(String value) {
            addCriterion("details like", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotLike(String value) {
            addCriterion("details not like", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsIn(List<String> values) {
            addCriterion("details in", values, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotIn(List<String> values) {
            addCriterion("details not in", values, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsBetween(String value1, String value2) {
            addCriterion("details between", value1, value2, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotBetween(String value1, String value2) {
            addCriterion("details not between", value1, value2, "details");
            return (Criteria) this;
        }

        public Criteria andMembersCountIsNull() {
            addCriterion("members_count is null");
            return (Criteria) this;
        }

        public Criteria andMembersCountIsNotNull() {
            addCriterion("members_count is not null");
            return (Criteria) this;
        }

        public Criteria andMembersCountEqualTo(Integer value) {
            addCriterion("members_count =", value, "membersCount");
            return (Criteria) this;
        }

        public Criteria andMembersCountNotEqualTo(Integer value) {
            addCriterion("members_count <>", value, "membersCount");
            return (Criteria) this;
        }

        public Criteria andMembersCountGreaterThan(Integer value) {
            addCriterion("members_count >", value, "membersCount");
            return (Criteria) this;
        }

        public Criteria andMembersCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("members_count >=", value, "membersCount");
            return (Criteria) this;
        }

        public Criteria andMembersCountLessThan(Integer value) {
            addCriterion("members_count <", value, "membersCount");
            return (Criteria) this;
        }

        public Criteria andMembersCountLessThanOrEqualTo(Integer value) {
            addCriterion("members_count <=", value, "membersCount");
            return (Criteria) this;
        }

        public Criteria andMembersCountIn(List<Integer> values) {
            addCriterion("members_count in", values, "membersCount");
            return (Criteria) this;
        }

        public Criteria andMembersCountNotIn(List<Integer> values) {
            addCriterion("members_count not in", values, "membersCount");
            return (Criteria) this;
        }

        public Criteria andMembersCountBetween(Integer value1, Integer value2) {
            addCriterion("members_count between", value1, value2, "membersCount");
            return (Criteria) this;
        }

        public Criteria andMembersCountNotBetween(Integer value1, Integer value2) {
            addCriterion("members_count not between", value1, value2, "membersCount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andSocietyStarIsNull() {
            addCriterion("society_star is null");
            return (Criteria) this;
        }

        public Criteria andSocietyStarIsNotNull() {
            addCriterion("society_star is not null");
            return (Criteria) this;
        }

        public Criteria andSocietyStarEqualTo(Float value) {
            addCriterion("society_star =", value, "societyStar");
            return (Criteria) this;
        }

        public Criteria andSocietyStarNotEqualTo(Float value) {
            addCriterion("society_star <>", value, "societyStar");
            return (Criteria) this;
        }

        public Criteria andSocietyStarGreaterThan(Float value) {
            addCriterion("society_star >", value, "societyStar");
            return (Criteria) this;
        }

        public Criteria andSocietyStarGreaterThanOrEqualTo(Float value) {
            addCriterion("society_star >=", value, "societyStar");
            return (Criteria) this;
        }

        public Criteria andSocietyStarLessThan(Float value) {
            addCriterion("society_star <", value, "societyStar");
            return (Criteria) this;
        }

        public Criteria andSocietyStarLessThanOrEqualTo(Float value) {
            addCriterion("society_star <=", value, "societyStar");
            return (Criteria) this;
        }

        public Criteria andSocietyStarIn(List<Float> values) {
            addCriterion("society_star in", values, "societyStar");
            return (Criteria) this;
        }

        public Criteria andSocietyStarNotIn(List<Float> values) {
            addCriterion("society_star not in", values, "societyStar");
            return (Criteria) this;
        }

        public Criteria andSocietyStarBetween(Float value1, Float value2) {
            addCriterion("society_star between", value1, value2, "societyStar");
            return (Criteria) this;
        }

        public Criteria andSocietyStarNotBetween(Float value1, Float value2) {
            addCriterion("society_star not between", value1, value2, "societyStar");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}