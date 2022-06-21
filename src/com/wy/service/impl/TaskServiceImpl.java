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
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    CarPointInfoMapper carPointInfoMapper;
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    CarUserInfoMapper carUserInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    
    @Override
    public void updateData() {
        Map<String, Object> rs = new HashMap<String, Object>();
        CarPointInfoExample queryE = new CarPointInfoExample();
        CarPointInfoExample.Criteria queryC = queryE.createCriteria();
        List<CarPointInfo> list = carPointInfoMapper.selectByExample(queryE); //查询车位

        for (CarPointInfo car : list) {
        	CarUserInfoExample ce = new  CarUserInfoExample();
        	CarUserInfoExample.Criteria cc =ce.createCriteria();
        	cc.andCarIdEqualTo(car.getId());
        	cc.andUsedStatusEqualTo(1);//使用中的分配记录
        	int count = (int)carUserInfoMapper.countByExample(ce);
        	if(count>0){
        		car.setIsUsed(2);//使用中
        	}else{
        		car.setIsUsed(1);//闲置中
        	}
        	carPointInfoMapper.updateByPrimaryKeySelective(car);
        }
        UserInfoExample ue = new UserInfoExample();
        List< UserInfo> ul = userInfoMapper.selectByExample(ue);
        for(UserInfo u:ul){
        	CarUserInfoExample ce = new  CarUserInfoExample();
        	CarUserInfoExample.Criteria cc =ce.createCriteria();
        	cc.andUserIdEqualTo(u.getId());
        	cc.andUsedStatusEqualTo(1);//使用中的分配记录
        	List<CarUserInfo> cl= carUserInfoMapper.selectByExample(ce);
        	double totalFee=0.0;
        	for(CarUserInfo c:cl){
        		totalFee+=c.getMonthFee();//总共车位费用
        	}
        	u.setCarFee(totalFee);
        	userInfoMapper.updateByPrimaryKeySelective(u);
        }
        
        
    }
}

