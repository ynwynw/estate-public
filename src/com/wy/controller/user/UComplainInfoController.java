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
@RequestMapping("/user/complain_info")
public class UComplainInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    ComplainInfoService complainInfoService;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    ComplainInfoMapper complainInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台
        modelMap.addAttribute("isDealList", DataListUtils.getIsDealList()); //返回is_deal数据列表
    }

    /**
     * 返回投诉列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", userInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "user/complain_info/list";
    }

    /**
     * 根据查询条件分页查询投诉数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(ComplainInfo model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        model.setUserId(login.getId()); //投诉用户等于当前登录id

        return complainInfoService.getDataList(model, page, CommonVal.pageSize,
            login); //分页查询数据
    }

    /**
     进入我要投诉页面
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, ComplainInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台
        modelMap.addAttribute("data", model);

        return "user/complain_info/add_page";
    }

    /**
     我要投诉提交信息接口
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(ComplainInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = complainInfoService.add(model, login); //执行添加操作

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
     进入修改页面
    */
    @RequestMapping("update")
    public String update(ModelMap modelMap, ComplainInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台

        ComplainInfo data = complainInfoMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "user/complain_info/update_page";
    }

    /**
     修改提交信息接口
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(ComplainInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = complainInfoService.update(model, login); //执行修改操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "修改成功");

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
        complainInfoService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "删除成功");

        return rs;
    }
}

