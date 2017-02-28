package cn.joongky.society.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpinionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpinionExample() {
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

        public Criteria andOpinionIdIsNull() {
            addCriterion("opinion_id is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIdIsNotNull() {
            addCriterion("opinion_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionIdEqualTo(String value) {
            addCriterion("opinion_id =", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotEqualTo(String value) {
            addCriterion("opinion_id <>", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdGreaterThan(String value) {
            addCriterion("opinion_id >", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdGreaterThanOrEqualTo(String value) {
            addCriterion("opinion_id >=", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdLessThan(String value) {
            addCriterion("opinion_id <", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdLessThanOrEqualTo(String value) {
            addCriterion("opinion_id <=", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdLike(String value) {
            addCriterion("opinion_id like", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotLike(String value) {
            addCriterion("opinion_id not like", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdIn(List<String> values) {
            addCriterion("opinion_id in", values, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotIn(List<String> values) {
            addCriterion("opinion_id not in", values, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdBetween(String value1, String value2) {
            addCriterion("opinion_id between", value1, value2, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotBetween(String value1, String value2) {
            addCriterion("opinion_id not between", value1, value2, "opinionId");
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

        public Criteria andSubmiterIsNull() {
            addCriterion("submiter is null");
            return (Criteria) this;
        }

        public Criteria andSubmiterIsNotNull() {
            addCriterion("submiter is not null");
            return (Criteria) this;
        }

        public Criteria andSubmiterEqualTo(String value) {
            addCriterion("submiter =", value, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterNotEqualTo(String value) {
            addCriterion("submiter <>", value, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterGreaterThan(String value) {
            addCriterion("submiter >", value, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterGreaterThanOrEqualTo(String value) {
            addCriterion("submiter >=", value, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterLessThan(String value) {
            addCriterion("submiter <", value, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterLessThanOrEqualTo(String value) {
            addCriterion("submiter <=", value, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterLike(String value) {
            addCriterion("submiter like", value, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterNotLike(String value) {
            addCriterion("submiter not like", value, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterIn(List<String> values) {
            addCriterion("submiter in", values, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterNotIn(List<String> values) {
            addCriterion("submiter not in", values, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterBetween(String value1, String value2) {
            addCriterion("submiter between", value1, value2, "submiter");
            return (Criteria) this;
        }

        public Criteria andSubmiterNotBetween(String value1, String value2) {
            addCriterion("submiter not between", value1, value2, "submiter");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleIsNull() {
            addCriterion("opinion_title is null");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleIsNotNull() {
            addCriterion("opinion_title is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleEqualTo(String value) {
            addCriterion("opinion_title =", value, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleNotEqualTo(String value) {
            addCriterion("opinion_title <>", value, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleGreaterThan(String value) {
            addCriterion("opinion_title >", value, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("opinion_title >=", value, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleLessThan(String value) {
            addCriterion("opinion_title <", value, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleLessThanOrEqualTo(String value) {
            addCriterion("opinion_title <=", value, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleLike(String value) {
            addCriterion("opinion_title like", value, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleNotLike(String value) {
            addCriterion("opinion_title not like", value, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleIn(List<String> values) {
            addCriterion("opinion_title in", values, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleNotIn(List<String> values) {
            addCriterion("opinion_title not in", values, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleBetween(String value1, String value2) {
            addCriterion("opinion_title between", value1, value2, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andOpinionTitleNotBetween(String value1, String value2) {
            addCriterion("opinion_title not between", value1, value2, "opinionTitle");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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