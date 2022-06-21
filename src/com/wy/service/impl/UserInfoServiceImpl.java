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
public class UserInfoServiceImpl implements UserInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
      新增
    */
    @Override
    public String add(UserInfo model, LoginModel login) {
        model.setCarFee(0.0); //默认0.0
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        userInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(UserInfo model, LoginModel login) {
        UserInfo preModel = userInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setName(model.getName());
        preModel.setPassWord(model.getPassWord());
        preModel.setRealName(model.getRealName());
        preModel.setCelPhone(model.getCelPhone());
        preModel.setWyFee(model.getWyFee());
        userInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询用户列表数据
    */
    @Override
    public Map<String, Object> getDataList(String nameOrder,
        UserInfo queryModel, Integer page, Integer pageSize, LoginModel login) {
        UserInfoExample se = new UserInfoExample();
        UserInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getName() != null) &&
                (queryModel.getName().equals("") == false)) {
            sc.andNameLike("%" + queryModel.getName() + "%"); //模糊查询
        }

        if ((queryModel.getRealName() != null) &&
                (queryModel.getRealName().equals("") == false)) {
            sc.andRealNameLike("%" + queryModel.getRealName() + "%"); //模糊查询
        }

        if ((queryModel.getCelPhone() != null) &&
                (queryModel.getCelPhone().equals("") == false)) {
            sc.andCelPhoneLike("%" + queryModel.getCelPhone() + "%"); //模糊查询
        }

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((nameOrder != null) && (nameOrder.equals("") == false)) {
            se.setOrderByClause(nameOrder); //按照登录名排序
        }

        int count = (int) userInfoMapper.countByExample(se);
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

        List<UserInfo> list = userInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (UserInfo model : list) {
            list2.add(getUserInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装用户为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getUserInfoModel(UserInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userInfo", model);

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }
}

