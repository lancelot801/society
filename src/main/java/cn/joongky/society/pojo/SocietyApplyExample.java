package cn.joongky.society.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocietyApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SocietyApplyExample() {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(String value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(String value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(String value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(String value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(String value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLike(String value) {
            addCriterion("apply_id like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotLike(String value) {
            addCriterion("apply_id not like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<String> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<String> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(String value1, String value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(String value1, String value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
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

        public Criteria andApplyerIdIsNull() {
            addCriterion("applyer_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyerIdIsNotNull() {
            addCriterion("applyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyerIdEqualTo(String value) {
            addCriterion("applyer_id =", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdNotEqualTo(String value) {
            addCriterion("applyer_id <>", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdGreaterThan(String value) {
            addCriterion("applyer_id >", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdGreaterThanOrEqualTo(String value) {
            addCriterion("applyer_id >=", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdLessThan(String value) {
            addCriterion("applyer_id <", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdLessThanOrEqualTo(String value) {
            addCriterion("applyer_id <=", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdLike(String value) {
            addCriterion("applyer_id like", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdNotLike(String value) {
            addCriterion("applyer_id not like", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdIn(List<String> values) {
            addCriterion("applyer_id in", values, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdNotIn(List<String> values) {
            addCriterion("applyer_id not in", values, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdBetween(String value1, String value2) {
            addCriterion("applyer_id between", value1, value2, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdNotBetween(String value1, String value2) {
            addCriterion("applyer_id not between", value1, value2, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdIsNull() {
            addCriterion("applyer_identity_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdIsNotNull() {
            addCriterion("applyer_identity_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdEqualTo(String value) {
            addCriterion("applyer_identity_id =", value, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdNotEqualTo(String value) {
            addCriterion("applyer_identity_id <>", value, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdGreaterThan(String value) {
            addCriterion("applyer_identity_id >", value, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdGreaterThanOrEqualTo(String value) {
            addCriterion("applyer_identity_id >=", value, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdLessThan(String value) {
            addCriterion("applyer_identity_id <", value, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdLessThanOrEqualTo(String value) {
            addCriterion("applyer_identity_id <=", value, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdLike(String value) {
            addCriterion("applyer_identity_id like", value, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdNotLike(String value) {
            addCriterion("applyer_identity_id not like", value, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdIn(List<String> values) {
            addCriterion("applyer_identity_id in", values, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdNotIn(List<String> values) {
            addCriterion("applyer_identity_id not in", values, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdBetween(String value1, String value2) {
            addCriterion("applyer_identity_id between", value1, value2, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdentityIdNotBetween(String value1, String value2) {
            addCriterion("applyer_identity_id not between", value1, value2, "applyerIdentityId");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeIsNull() {
            addCriterion("applied_time is null");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeIsNotNull() {
            addCriterion("applied_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeEqualTo(Date value) {
            addCriterion("applied_time =", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeNotEqualTo(Date value) {
            addCriterion("applied_time <>", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeGreaterThan(Date value) {
            addCriterion("applied_time >", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applied_time >=", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeLessThan(Date value) {
            addCriterion("applied_time <", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeLessThanOrEqualTo(Date value) {
            addCriterion("applied_time <=", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeIn(List<Date> values) {
            addCriterion("applied_time in", values, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeNotIn(List<Date> values) {
            addCriterion("applied_time not in", values, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeBetween(Date value1, Date value2) {
            addCriterion("applied_time between", value1, value2, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeNotBetween(Date value1, Date value2) {
            addCriterion("applied_time not between", value1, value2, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeIsNull() {
            addCriterion("checked_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeIsNotNull() {
            addCriterion("checked_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeEqualTo(Date value) {
            addCriterion("checked_time =", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeNotEqualTo(Date value) {
            addCriterion("checked_time <>", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeGreaterThan(Date value) {
            addCriterion("checked_time >", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("checked_time >=", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeLessThan(Date value) {
            addCriterion("checked_time <", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeLessThanOrEqualTo(Date value) {
            addCriterion("checked_time <=", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeIn(List<Date> values) {
            addCriterion("checked_time in", values, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeNotIn(List<Date> values) {
            addCriterion("checked_time not in", values, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeBetween(Date value1, Date value2) {
            addCriterion("checked_time between", value1, value2, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeNotBetween(Date value1, Date value2) {
            addCriterion("checked_time not between", value1, value2, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(String value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(String value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(String value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(String value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLike(String value) {
            addCriterion("check_status like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotLike(String value) {
            addCriterion("check_status not like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<String> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<String> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(String value1, String value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(String value1, String value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNull() {
            addCriterion("feedback_Id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNotNull() {
            addCriterion("feedback_Id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdEqualTo(String value) {
            addCriterion("feedback_Id =", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotEqualTo(String value) {
            addCriterion("feedback_Id <>", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThan(String value) {
            addCriterion("feedback_Id >", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_Id >=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThan(String value) {
            addCriterion("feedback_Id <", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThanOrEqualTo(String value) {
            addCriterion("feedback_Id <=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLike(String value) {
            addCriterion("feedback_Id like", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotLike(String value) {
            addCriterion("feedback_Id not like", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIn(List<String> values) {
            addCriterion("feedback_Id in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotIn(List<String> values) {
            addCriterion("feedback_Id not in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdBetween(String value1, String value2) {
            addCriterion("feedback_Id between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotBetween(String value1, String value2) {
            addCriterion("feedback_Id not between", value1, value2, "feedbackId");
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