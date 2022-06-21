package com.wy.model;

public class CarPointInfo {
    private Integer id;
    private String createTime;
    private String carNo;
    private String carImg;
    private String address;
    private Integer isUsed;

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

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = (carNo == null) ? null : carNo.trim();
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = (carImg == null) ? null : carImg.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = (address == null) ? null : address.trim();
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }
}

