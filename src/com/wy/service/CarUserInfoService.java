package com.wy.service;

import com.wy.controller.LoginModel;

import com.wy.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface CarUserInfoService {
    /**
      分页查询车位分配数据列表
    */
    public Map<String, Object> getDataList(CarUserInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装车位分配为前台展示的数据形式
    */
    public Map<String, Object> getCarUserInfoModel(CarUserInfo model,
        LoginModel login);

    /**
      分配车位
    */
    public String add(CarUserInfo model, LoginModel login);
}

