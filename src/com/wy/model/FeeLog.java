package com.wy.model;

public class FeeLog {
    private Integer id;
    private String createTime;
    private Integer userId;
    private Double wyFee;
    private Double carFee;
    private Integer isJf;
    private String logDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = (createTime == null) ? null : createTime.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getWyFee() {
        return wyFee;
    }

    public void setWyFee(Double wyFee) {
        this.wyFee = wyFee;
    }

    public Double getCarFee() {
        return carFee;
    }

    public void setCarFee(Double carFee) {
        this.carFee = carFee;
    }

    public Integer getIsJf() {
        return isJf;
    }

    public void setIsJf(Integer isJf) {
        this.isJf = isJf;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = (logDate == null) ? null : logDate.trim();
    }
}

