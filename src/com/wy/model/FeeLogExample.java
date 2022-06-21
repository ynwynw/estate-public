package com.wy.model;
import java.util.ArrayList;
import java.util.List;
public class FeeLogExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public FeeLogExample() {
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
 public Criteria andWyFeeIsNull() {
		 addCriterion("wy_fee is null");
		return (Criteria) this;
		}
  public Criteria andWyFeeIsNotNull(){
		addCriterion("wy_fee is not null");
		return (Criteria) this;
		}
  public Criteria andWyFeeEqualTo(Double value) {
		  addCriterion("wy_fee =", value, "wyFee");
		return (Criteria) this;
		}
   public Criteria andWyFeeNotEqualTo(Double value) {
		  addCriterion("wy_fee <>", value, "wyFee");
		return (Criteria) this;
		}
    public Criteria andWyFeeGreaterThan(Double value) {
		 addCriterion("wy_fee >", value, "wyFee");
		return (Criteria) this;
		}
  public Criteria andWyFeeGreaterThanOrEqualTo(Double value) {
		  addCriterion("wy_fee >=", value, "WyFee");
		return (Criteria) this;
		}
   public Criteria andWyFeeLessThan(Double value) {
		  addCriterion("wy_fee <", value, "wyFee");
		return (Criteria) this;
		}
    public Criteria andWyFeeLessThanOrEqualTo(Double value) {
		  addCriterion("wy_fee <=", value, "wyFee");
		return (Criteria) this;
		}
    public Criteria andWyFeeIn(List<Double> values) {
		  addCriterion("wy_fee in", values, "wyFee");
		return (Criteria) this;
		}
    public Criteria andWyFeeNotIn(List<Double> values) {
		  addCriterion("wy_fee not in", values, "wyFee");
		return (Criteria) this;
		}
     public Criteria andWyFeeBetween(Double value1, Double value2) {
		   addCriterion("wy_fee between", value1, value2, "wyFee");
		return (Criteria) this;
		}
     public Criteria andWyFeeNotBetween(Double value1, Double value2) {
		   addCriterion("wy_fee not between", value1, value2, "wyFee");
		return (Criteria) this;
		}
    public Criteria andWyFeeLike(Double value) {
		  addCriterion("wy_fee like", value, "wyFee");
		return (Criteria) this;
		}
    public Criteria andWyFeeNotLike(Double value) {
		  addCriterion("wy_fee not like", value, "wyFee");
		return (Criteria) this;
		}
 public Criteria andCarFeeIsNull() {
		 addCriterion("car_fee is null");
		return (Criteria) this;
		}
  public Criteria andCarFeeIsNotNull(){
		addCriterion("car_fee is not null");
		return (Criteria) this;
		}
  public Criteria andCarFeeEqualTo(Double value) {
		  addCriterion("car_fee =", value, "carFee");
		return (Criteria) this;
		}
   public Criteria andCarFeeNotEqualTo(Double value) {
		  addCriterion("car_fee <>", value, "carFee");
		return (Criteria) this;
		}
    public Criteria andCarFeeGreaterThan(Double value) {
		 addCriterion("car_fee >", value, "carFee");
		return (Criteria) this;
		}
  public Criteria andCarFeeGreaterThanOrEqualTo(Double value) {
		  addCriterion("car_fee >=", value, "CarFee");
		return (Criteria) this;
		}
   public Criteria andCarFeeLessThan(Double value) {
		  addCriterion("car_fee <", value, "carFee");
		return (Criteria) this;
		}
    public Criteria andCarFeeLessThanOrEqualTo(Double value) {
		  addCriterion("car_fee <=", value, "carFee");
		return (Criteria) this;
		}
    public Criteria andCarFeeIn(List<Double> values) {
		  addCriterion("car_fee in", values, "carFee");
		return (Criteria) this;
		}
    public Criteria andCarFeeNotIn(List<Double> values) {
		  addCriterion("car_fee not in", values, "carFee");
		return (Criteria) this;
		}
     public Criteria andCarFeeBetween(Double value1, Double value2) {
		   addCriterion("car_fee between", value1, value2, "carFee");
		return (Criteria) this;
		}
     public Criteria andCarFeeNotBetween(Double value1, Double value2) {
		   addCriterion("car_fee not between", value1, value2, "carFee");
		return (Criteria) this;
		}
    public Criteria andCarFeeLike(Double value) {
		  addCriterion("car_fee like", value, "carFee");
		return (Criteria) this;
		}
    public Criteria andCarFeeNotLike(Double value) {
		  addCriterion("car_fee not like", value, "carFee");
		return (Criteria) this;
		}
 public Criteria andIsJfIsNull() {
		 addCriterion("is_jf is null");
		return (Criteria) this;
		}
  public Criteria andIsJfIsNotNull(){
		addCriterion("is_jf is not null");
		return (Criteria) this;
		}
  public Criteria andIsJfEqualTo(Integer value) {
		  addCriterion("is_jf =", value, "isJf");
		return (Criteria) this;
		}
   public Criteria andIsJfNotEqualTo(Integer value) {
		  addCriterion("is_jf <>", value, "isJf");
		return (Criteria) this;
		}
    public Criteria andIsJfGreaterThan(Integer value) {
		 addCriterion("is_jf >", value, "isJf");
		return (Criteria) this;
		}
  public Criteria andIsJfGreaterThanOrEqualTo(Integer value) {
		  addCriterion("is_jf >=", value, "IsJf");
		return (Criteria) this;
		}
   public Criteria andIsJfLessThan(Integer value) {
		  addCriterion("is_jf <", value, "isJf");
		return (Criteria) this;
		}
    public Criteria andIsJfLessThanOrEqualTo(Integer value) {
		  addCriterion("is_jf <=", value, "isJf");
		return (Criteria) this;
		}
    public Criteria andIsJfIn(List<Integer> values) {
		  addCriterion("is_jf in", values, "isJf");
		return (Criteria) this;
		}
    public Criteria andIsJfNotIn(List<Integer> values) {
		  addCriterion("is_jf not in", values, "isJf");
		return (Criteria) this;
		}
     public Criteria andIsJfBetween(Integer value1, Integer value2) {
		   addCriterion("is_jf between", value1, value2, "isJf");
		return (Criteria) this;
		}
     public Criteria andIsJfNotBetween(Integer value1, Integer value2) {
		   addCriterion("is_jf not between", value1, value2, "isJf");
		return (Criteria) this;
		}
    public Criteria andIsJfLike(Integer value) {
		  addCriterion("is_jf like", value, "isJf");
		return (Criteria) this;
		}
    public Criteria andIsJfNotLike(Integer value) {
		  addCriterion("is_jf not like", value, "isJf");
		return (Criteria) this;
		}
 public Criteria andLogDateIsNull() {
		 addCriterion("log_date is null");
		return (Criteria) this;
		}
  public Criteria andLogDateIsNotNull(){
		addCriterion("log_date is not null");
		return (Criteria) this;
		}
  public Criteria andLogDateEqualTo(String value) {
		  addCriterion("log_date =", value, "logDate");
		return (Criteria) this;
		}
   public Criteria andLogDateNotEqualTo(String value) {
		  addCriterion("log_date <>", value, "logDate");
		return (Criteria) this;
		}
    public Criteria andLogDateGreaterThan(String value) {
		 addCriterion("log_date >", value, "logDate");
		return (Criteria) this;
		}
  public Criteria andLogDateGreaterThanOrEqualTo(String value) {
		  addCriterion("log_date >=", value, "LogDate");
		return (Criteria) this;
		}
   public Criteria andLogDateLessThan(String value) {
		  addCriterion("log_date <", value, "logDate");
		return (Criteria) this;
		}
    public Criteria andLogDateLessThanOrEqualTo(String value) {
		  addCriterion("log_date <=", value, "logDate");
		return (Criteria) this;
		}
    public Criteria andLogDateIn(List<String> values) {
		  addCriterion("log_date in", values, "logDate");
		return (Criteria) this;
		}
    public Criteria andLogDateNotIn(List<String> values) {
		  addCriterion("log_date not in", values, "logDate");
		return (Criteria) this;
		}
     public Criteria andLogDateBetween(String value1, String value2) {
		   addCriterion("log_date between", value1, value2, "logDate");
		return (Criteria) this;
		}
     public Criteria andLogDateNotBetween(String value1, String value2) {
		   addCriterion("log_date not between", value1, value2, "logDate");
		return (Criteria) this;
		}
    public Criteria andLogDateLike(String value) {
		  addCriterion("log_date like", value, "logDate");
		return (Criteria) this;
		}
    public Criteria andLogDateNotLike(String value) {
		  addCriterion("log_date not like", value, "logDate");
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
