package com.wy.model;

public class CarUserInfo {
    private Integer id;
    private String createTime;
    private Integer userId;
    private Integer carId;
    private Double monthFee;
    private Integer usedStatus;

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

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Double getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(Double monthFee) {
        this.monthFee = monthFee;
    }

    public Integer getUsedStatus() {
        return usedStatus;
    }

    public void setUsedStatus(Integer usedStatus) {
        this.usedStatus = usedStatus;
    }
}

