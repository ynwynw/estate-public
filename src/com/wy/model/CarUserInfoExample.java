package com.wy.model;
import java.util.ArrayList;
import java.util.List;
public class CarUserInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public CarUserInfoExample() {
        oredCriteria = new ArrayList<>();
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
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
    public int getStartRow() {
        return startRow;
    }
    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }
    public int getPageRows() {
        return pageRows;
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
            criteria = new ArrayList<>();
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
    public Criteria andIdIsNull() {
		 addCriterion("id is null");
		return (Criteria) this;
		}
  public Criteria andIdIsNotNull(){
		addCriterion("id is not null");
		return (Criteria) this;
		}
  public Criteria andIdEqualTo(Integer value) {
		  addCriterion("id =", value, "id");
		return (Criteria) this;
		}
   public Criteria andIdNotEqualTo(Integer value) {
		  addCriterion("id <>", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdGreaterThan(Integer value) {
		 addCriterion("id >", value, "id");
		return (Criteria) this;
		}
  public Criteria andIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("id >=", value, "Id");
		return (Criteria) this;
		}
   public Criteria andIdLessThan(Integer value) {
		  addCriterion("id <", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdLessThanOrEqualTo(Integer value) {
		  addCriterion("id <=", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdIn(List<Integer> values) {
		  addCriterion("id in", values, "id");
		return (Criteria) this;
		}
    public Criteria andIdNotIn(List<Integer> values) {
		  addCriterion("id not in", values, "id");
		return (Criteria) this;
		}
     public Criteria andIdBetween(Integer value1, Integer value2) {
		   addCriterion("id between", value1, value2, "id");
		return (Criteria) this;
		}
     public Criteria andIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("id not between", value1, value2, "id");
		return (Criteria) this;
		}
    public Criteria andIdLike(Integer value) {
		  addCriterion("id like", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdNotLike(Integer value) {
		  addCriterion("id not like", value, "id");
		return (Criteria) this;
		}
 public Criteria andCreateTimeIsNull() {
		 addCriterion("create_time is null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeIsNotNull(){
		addCriterion("create_time is not null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeEqualTo(String value) {
		  addCriterion("create_time =", value, "createTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeNotEqualTo(String value) {
		  addCriterion("create_time <>", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeGreaterThan(String value) {
		 addCriterion("create_time >", value, "createTime");
		return (Criteria) this;
		}
  public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("create_time >=", value, "CreateTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeLessThan(String value) {
		  addCriterion("create_time <", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLessThanOrEqualTo(String value) {
		  addCriterion("create_time <=", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeIn(List<String> values) {
		  addCriterion("create_time in", values, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotIn(List<String> values) {
		  addCriterion("create_time not in", values, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeBetween(String value1, String value2) {
		   addCriterion("create_time between", value1, value2, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeNotBetween(String value1, String value2) {
		   addCriterion("create_time not between", value1, value2, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLike(String value) {
		  addCriterion("create_time like", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotLike(String value) {
		  addCriterion("create_time not like", value, "createTime");
		return (Criteria) this;
		}
 public Criteria andUserIdIsNull() {
		 addCriterion("user_id is null");
		return (Criteria) this;
		}
  public Criteria andUserIdIsNotNull(){
		addCriterion("user_id is not null");
		return (Criteria) this;
		}
  public Criteria andUserIdEqualTo(Integer value) {
		  addCriterion("user_id =", value, "userId");
		return (Criteria) this;
		}
   public Criteria andUserIdNotEqualTo(Integer value) {
		  addCriterion("user_id <>", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdGreaterThan(Integer value) {
		 addCriterion("user_id >", value, "userId");
		return (Criteria) this;
		}
  public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("user_id >=", value, "UserId");
		return (Criteria) this;
		}
   public Criteria andUserIdLessThan(Integer value) {
		  addCriterion("user_id <", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdLessThanOrEqualTo(Integer value) {
		  addCriterion("user_id <=", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdIn(List<Integer> values) {
		  addCriterion("user_id in", values, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdNotIn(List<Integer> values) {
		  addCriterion("user_id not in", values, "userId");
		return (Criteria) this;
		}
     public Criteria andUserIdBetween(Integer value1, Integer value2) {
		   addCriterion("user_id between", value1, value2, "userId");
		return (Criteria) this;
		}
     public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("user_id not between", value1, value2, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdLike(Integer value) {
		  addCriterion("user_id like", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdNotLike(Integer value) {
		  addCriterion("user_id not like", value, "userId");
		return (Criteria) this;
		}
 public Criteria andCarIdIsNull() {
		 addCriterion("car_id is null");
		return (Criteria) this;
		}
  public Criteria andCarIdIsNotNull(){
		addCriterion("car_id is not null");
		return (Criteria) this;
		}
  public Criteria andCarIdEqualTo(Integer value) {
		  addCriterion("car_id =", value, "carId");
		return (Criteria) this;
		}
   public Criteria andCarIdNotEqualTo(Integer value) {
		  addCriterion("car_id <>", value, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdGreaterThan(Integer value) {
		 addCriterion("car_id >", value, "carId");
		return (Criteria) this;
		}
  public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("car_id >=", value, "CarId");
		return (Criteria) this;
		}
   public Criteria andCarIdLessThan(Integer value) {
		  addCriterion("car_id <", value, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdLessThanOrEqualTo(Integer value) {
		  addCriterion("car_id <=", value, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdIn(List<Integer> values) {
		  addCriterion("car_id in", values, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdNotIn(List<Integer> values) {
		  addCriterion("car_id not in", values, "carId");
		return (Criteria) this;
		}
     public Criteria andCarIdBetween(Integer value1, Integer value2) {
		   addCriterion("car_id between", value1, value2, "carId");
		return (Criteria) this;
		}
     public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("car_id not between", value1, value2, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdLike(Integer value) {
		  addCriterion("car_id like", value, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdNotLike(Integer value) {
		  addCriterion("car_id not like", value, "carId");
		return (Criteria) this;
		}
 public Criteria andMonthFeeIsNull() {
		 addCriterion("month_fee is null");
		return (Criteria) this;
		}
  public Criteria andMonthFeeIsNotNull(){
		addCriterion("month_fee is not null");
		return (Criteria) this;
		}
  public Criteria andMonthFeeEqualTo(Double value) {
		  addCriterion("month_fee =", value, "monthFee");
		return (Criteria) this;
		}
   public Criteria andMonthFeeNotEqualTo(Double value) {
		  addCriterion("month_fee <>", value, "monthFee");
		return (Criteria) this;
		}
    public Criteria andMonthFeeGreaterThan(Double value) {
		 addCriterion("month_fee >", value, "monthFee");
		return (Criteria) this;
		}
  public Criteria andMonthFeeGreaterThanOrEqualTo(Double value) {
		  addCriterion("month_fee >=", value, "MonthFee");
		return (Criteria) this;
		}
   public Criteria andMonthFeeLessThan(Double value) {
		  addCriterion("month_fee <", value, "monthFee");
		return (Criteria) this;
		}
    public Criteria andMonthFeeLessThanOrEqualTo(Double value) {
		  addCriterion("month_fee <=", value, "monthFee");
		return (Criteria) this;
		}
    public Criteria andMonthFeeIn(List<Double> values) {
		  addCriterion("month_fee in", values, "monthFee");
		return (Criteria) this;
		}
    public Criteria andMonthFeeNotIn(List<Double> values) {
		  addCriterion("month_fee not in", values, "monthFee");
		return (Criteria) this;
		}
     public Criteria andMonthFeeBetween(Double value1, Double value2) {
		   addCriterion("month_fee between", value1, value2, "monthFee");
		return (Criteria) this;
		}
     public Criteria andMonthFeeNotBetween(Double value1, Double value2) {
		   addCriterion("month_fee not between", value1, value2, "monthFee");
		return (Criteria) this;
		}
    public Criteria andMonthFeeLike(Double value) {
		  addCriterion("month_fee like", value, "monthFee");
		return (Criteria) this;
		}
    public Criteria andMonthFeeNotLike(Double value) {
		  addCriterion("month_fee not like", value, "monthFee");
		return (Criteria) this;
		}
 public Criteria andUsedStatusIsNull() {
		 addCriterion("used_status is null");
		return (Criteria) this;
		}
  public Criteria andUsedStatusIsNotNull(){
		addCriterion("used_status is not null");
		return (Criteria) this;
		}
  public Criteria andUsedStatusEqualTo(Integer value) {
		  addCriterion("used_status =", value, "usedStatus");
		return (Criteria) this;
		}
   public Criteria andUsedStatusNotEqualTo(Integer value) {
		  addCriterion("used_status <>", value, "usedStatus");
		return (Criteria) this;
		}
    public Criteria andUsedStatusGreaterThan(Integer value) {
		 addCriterion("used_status >", value, "usedStatus");
		return (Criteria) this;
		}
  public Criteria andUsedStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("used_status >=", value, "UsedStatus");
		return (Criteria) this;
		}
   public Criteria andUsedStatusLessThan(Integer value) {
		  addCriterion("used_status <", value, "usedStatus");
		return (Criteria) this;
		}
    public Criteria andUsedStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("used_status <=", value, "usedStatus");
		return (Criteria) this;
		}
    public Criteria andUsedStatusIn(List<Integer> values) {
		  addCriterion("used_status in", values, "usedStatus");
		return (Criteria) this;
		}
    public Criteria andUsedStatusNotIn(List<Integer> values) {
		  addCriterion("used_status not in", values, "usedStatus");
		return (Criteria) this;
		}
     public Criteria andUsedStatusBetween(Integer value1, Integer value2) {
		   addCriterion("used_status between", value1, value2, "usedStatus");
		return (Criteria) this;
		}
     public Criteria andUsedStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("used_status not between", value1, value2, "usedStatus");
		return (Criteria) this;
		}
    public Criteria andUsedStatusLike(Integer value) {
		  addCriterion("used_status like", value, "usedStatus");
		return (Criteria) this;
		}
    public Criteria andUsedStatusNotLike(Integer value) {
		  addCriterion("used_status not like", value, "usedStatus");
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
