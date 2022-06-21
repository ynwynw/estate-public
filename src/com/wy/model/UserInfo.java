package com.wy.model;

public class UserInfo {
    private Integer id;
    private String name;
    private String passWord;
    private String createTime;
    private Double wyFee;
    private Double carFee;
    private String realName;
    private String celPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name == null) ? null : name.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = (passWord == null) ? null : passWord.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = (createTime == null) ? null : createTime.trim();
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = (realName == null) ? null : realName.trim();
    }

    public String getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(String celPhone) {
        this.celPhone = (celPhone == null) ? null : celPhone.trim();
    }
}

