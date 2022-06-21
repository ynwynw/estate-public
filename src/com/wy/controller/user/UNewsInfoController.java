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
@RequestMapping("/user/news_info")
public class UNewsInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    NewsInfoService newsInfoService;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    NewsInfoMapper newsInfoMapper;

    /**
    * 返回新闻列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", userInfo);

        return "user/news_info/list";
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
    @RequestMapping("detail2")
    public Object detail2(Integer id, ModelMap modelMap,
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

        return "user/news_info/detail";
    }
}

