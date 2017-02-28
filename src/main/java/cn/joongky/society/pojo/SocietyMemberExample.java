package cn.joongky.society.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocietyMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SocietyMemberExample() {
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

        public Criteria andSmemberIdIsNull() {
            addCriterion("smember_id is null");
            return (Criteria) this;
        }

        public Criteria andSmemberIdIsNotNull() {
            addCriterion("smember_id is not null");
            return (Criteria) this;
        }

        public Criteria andSmemberIdEqualTo(String value) {
            addCriterion("smember_id =", value, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdNotEqualTo(String value) {
            addCriterion("smember_id <>", value, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdGreaterThan(String value) {
            addCriterion("smember_id >", value, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("smember_id >=", value, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdLessThan(String value) {
            addCriterion("smember_id <", value, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdLessThanOrEqualTo(String value) {
            addCriterion("smember_id <=", value, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdLike(String value) {
            addCriterion("smember_id like", value, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdNotLike(String value) {
            addCriterion("smember_id not like", value, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdIn(List<String> values) {
            addCriterion("smember_id in", values, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdNotIn(List<String> values) {
            addCriterion("smember_id not in", values, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdBetween(String value1, String value2) {
            addCriterion("smember_id between", value1, value2, "smemberId");
            return (Criteria) this;
        }

        public Criteria andSmemberIdNotBetween(String value1, String value2) {
            addCriterion("smember_id not between", value1, value2, "smemberId");
            return (Criteria) this;
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("member_id like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("member_id not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeIsNull() {
            addCriterion("joined_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeIsNotNull() {
            addCriterion("joined_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeEqualTo(Date value) {
            addCriterion("joined_time =", value, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeNotEqualTo(Date value) {
            addCriterion("joined_time <>", value, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeGreaterThan(Date value) {
            addCriterion("joined_time >", value, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("joined_time >=", value, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeLessThan(Date value) {
            addCriterion("joined_time <", value, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeLessThanOrEqualTo(Date value) {
            addCriterion("joined_time <=", value, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeIn(List<Date> values) {
            addCriterion("joined_time in", values, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeNotIn(List<Date> values) {
            addCriterion("joined_time not in", values, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeBetween(Date value1, Date value2) {
            addCriterion("joined_time between", value1, value2, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andJoinedTimeNotBetween(Date value1, Date value2) {
            addCriterion("joined_time not between", value1, value2, "joinedTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeIsNull() {
            addCriterion("left_time is null");
            return (Criteria) this;
        }

        public Criteria andLeftTimeIsNotNull() {
            addCriterion("left_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeftTimeEqualTo(Date value) {
            addCriterion("left_time =", value, "leftTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeNotEqualTo(Date value) {
            addCriterion("left_time <>", value, "leftTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeGreaterThan(Date value) {
            addCriterion("left_time >", value, "leftTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("left_time >=", value, "leftTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeLessThan(Date value) {
            addCriterion("left_time <", value, "leftTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeLessThanOrEqualTo(Date value) {
            addCriterion("left_time <=", value, "leftTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeIn(List<Date> values) {
            addCriterion("left_time in", values, "leftTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeNotIn(List<Date> values) {
            addCriterion("left_time not in", values, "leftTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeBetween(Date value1, Date value2) {
            addCriterion("left_time between", value1, value2, "leftTime");
            return (Criteria) this;
        }

        public Criteria andLeftTimeNotBetween(Date value1, Date value2) {
            addCriterion("left_time not between", value1, value2, "leftTime");
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