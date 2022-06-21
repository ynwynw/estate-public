package com.wy.controller.user;

import com.wy.controller.LoginModel;

import com.wy.dao.*;

import com.wy.model.*;

import com.wy.service.*;
import com.wy.service.impl.*;

import com.wy.util.*;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user/car_user_info")
public class UCarUserInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    CarUserInfoService carUserInfoService;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    CarPointInfoMapper carPointInfoMapper;
    @Autowired
    CarUserInfoMapper carUserInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台

        UserInfoExample userInfoE = new UserInfoExample();
        UserInfoExample.Criteria userInfoC = userInfoE.createCriteria();
        userInfoC.andIdEqualTo(login.getId()); //ID等于当前登录id

        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoE);
        List<Map<String, Object>> userInfoList2 = new ArrayList<Map<String, Object>>();

        for (UserInfo m : userInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            userInfoList2.add(map);
        }

        modelMap.addAttribute("userInfoList", userInfoList2);

        CarPointInfoExample carPointInfoE = new CarPointInfoExample();
        CarPointInfoExample.Criteria carPointInfoC = carPointInfoE.createCriteria();
        List<CarPointInfo> carPointInfoList = carPointInfoMapper.selectByExample(carPointInfoE);
        List<Map<String, Object>> carPointInfoList2 = new ArrayList<Map<String, Object>>();

        for (CarPointInfo m : carPointInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getCarNo());
            carPointInfoList2.add(map);
        }

        modelMap.addAttribute("carPointInfoList", carPointInfoList2);
        modelMap.addAttribute("usedStatusList",
            DataListUtils.getUsedStatusList()); //返回used_status数据列表
    }

    /**
     * 返回车位分配列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", userInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "user/car_user_info/list";
    }

    /**
     * 根据查询条件分页查询车位分配数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(CarUserInfo model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        model.setUserId(login.getId()); //使用用户等于当前登录id

        return carUserInfoService.getDataList(model, page, CommonVal.pageSize,
            login); //分页查询数据
    }
}

