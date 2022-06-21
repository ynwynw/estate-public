package com.wy.service.impl;

import com.wy.controller.LoginModel;

import com.wy.dao.*;

import com.wy.model.*;

import com.wy.service.*;

import com.wy.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class CarUserInfoServiceImpl implements CarUserInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    CarUserInfoMapper carUserInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    CarPointInfoMapper carPointInfoMapper;

    /**
      分配车位
    */
    @Override
    public String add(CarUserInfo model, LoginModel login) {
    	
    	CarUserInfoExample ce = new  CarUserInfoExample();
    	CarUserInfoExample.Criteria cc =ce.createCriteria();
    	cc.andCarIdEqualTo(model.getCarId());
    	cc.andUsedStatusEqualTo(1);//使用中的分配记录
    	int count = (int)carUserInfoMapper.countByExample(ce);
    	if(count>0){
    		return "该车位正使用中，不能重新分配";
    	}
    	
        model.setUsedStatus(1); //默认使用中,
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        carUserInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
    *根据参数查询车位分配列表数据
    */
    @Override
    public Map<String, Object> getDataList(CarUserInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        CarUserInfoExample se = new CarUserInfoExample();
        CarUserInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if (queryModel.getCarId() != null) {
            sc.andCarIdEqualTo(queryModel.getCarId());
        }

        if (queryModel.getUsedStatus() != null) {
            sc.andUsedStatusEqualTo(queryModel.getUsedStatus()); //查询使用状态等于指定值
        }

        if (queryModel.getUserId() != null) {
            sc.andUserIdEqualTo(queryModel.getUserId());
        }

        int count = (int) carUserInfoMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //分页

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);
        }

        List<CarUserInfo> list = carUserInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (CarUserInfo model : list) {
            list2.add(getCarUserInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装车位分配为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getCarUserInfoModel(CarUserInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("carUserInfo", model);

        if (model.getUserId() != null) {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(model.getUserId()); //使用用户为外接字段,需要关联用户来解释该字段

            if (userInfo != null) {
                map.put("userIdStr", userInfo.getName());
            }
        }

        if (model.getCarId() != null) {
            CarPointInfo carPointInfo = carPointInfoMapper.selectByPrimaryKey(model.getCarId()); //车位id为外接字段,需要关联车位来解释该字段

            if (carPointInfo != null) {
                map.put("carIdStr", carPointInfo.getCarNo());
            }
        }

        map.put("usedStatusStr",
            DataListUtils.getUsedStatusNameById(model.getUsedStatus() + "")); //解释使用状态字段

        return map;
    }
}

