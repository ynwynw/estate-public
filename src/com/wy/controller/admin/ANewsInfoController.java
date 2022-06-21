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
@RequestMapping("/admin/news_info")
public class ANewsInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    NewsInfoService newsInfoService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    NewsInfoMapper newsInfoMapper;

    @RequestMapping(value = "queryDataDetail")
    @ResponseBody
    public Object queryDataDetail(Integer id, HttpServletRequest request) {
        NewsInfo newsInfo = newsInfoMapper.selectByPrimaryKey(id);

        return newsInfo;
    }

    /**
     * 返回新闻列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);

        return "admin/news_info/list";
    }

    /**
     * 根据查询条件分页查询新闻数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(NewsInfo model, Integer page, String createTimeOrder,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return newsInfoService.getDataList(createTimeOrder, model, page,
            CommonVal.pageSize, login); //分页查询数据
    }

    /**
     查看详情接口
    */
    @RequestMapping("detail1")
    public Object detail1(Integer id, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        NewsInfo model = new NewsInfo();
        model.setId(id);

        Map<String, Object> rs = newsInfoService.getDataList(null, model, null,
                null, login);
        List<Map<String, Object>> tmplist = (List<Map<String, Object>>) rs.get(
                "list");

        if ((tmplist != null) && (tmplist.size() > 0)) {
            modelMap.addAttribute("detail", tmplist.get(0));
        } else {
            modelMap.addAttribute("detail", new HashMap<String, Object>());
        }

        return "admin/news_info/detail";
    }

    /**
     进入新增页面
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, NewsInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        modelMap.addAttribute("data", model);

        return "admin/news_info/add_page";
    }

    /**
     新增提交信息接口
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(NewsInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = newsInfoService.add(model, login); //执行添加操作

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
    public String update(ModelMap modelMap, NewsInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        NewsInfo data = newsInfoMapper.selectByPrimaryKey(model.getId());

        if (data.getContent() != null) {
            data.setContent(data.getContent().replaceAll("'", "\\\\'")); //wangeditor需要过滤掉'符号,否则初始化可能报错
        }

        modelMap.addAttribute("data", data);

        return "admin/news_info/update_page";
    }

    /**
     修改提交信息接口
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(NewsInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = newsInfoService.update(model, login); //执行修改操作

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
        newsInfoService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "删除成功");

        return rs;
    }
}

