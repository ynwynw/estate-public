package com.wy.controller.admin;

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
@RequestMapping("/admin/fee_log")
public class AFeeLogController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    FeeLogService feeLogService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    FeeLogMapper feeLogMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台

        UserInfoExample userInfoE = new UserInfoExample();
        UserInfoExample.Criteria userInfoC = userInfoE.createCriteria();
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoE);
        List<Map<String, Object>> userInfoList2 = new ArrayList<Map<String, Object>>();

        for (UserInfo m : userInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            userInfoList2.add(map);
        }

        modelMap.addAttribute("userInfoList", userInfoList2);
        modelMap.addAttribute("isJfList", DataListUtils.getIsJfList()); //返回is_jf数据列表
    }

    /**
     * 返回每月费用列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "admin/fee_log/list";
    }

    /**
     * 根据查询条件分页查询每月费用数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(FeeLog model, Integer page, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return feeLogService.getDataList(model, page, CommonVal.pageSize, login); //分页查询数据
    }

    /**
     进入新增费用单页面
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, FeeLog model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台
        modelMap.addAttribute("data", model);

        return "admin/fee_log/add_page";
    }

    /**
     新增费用单提交信息接口
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(FeeLog model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = feeLogService.add(model, login); //执行添加操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "添加成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     删除数据接口
    */
    @RequestMapping("del")
    @ResponseBody
    public Object del(Integer id, ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        feeLogService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "删除成功");

        return rs;
    }
}

