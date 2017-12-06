package com.honglu.crm.controller;

import com.honglu.crm.bo.UUserBo;
import com.honglu.crm.config.shiro.ShiroToken;
import com.honglu.crm.bo.SsoUserBo;
import com.honglu.crm.util.DesUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author hpsgts
 */
@Controller
public class HomeController {
    public Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/")
    @ResponseBody
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "ajaxLogin",method = RequestMethod.POST)
    public ModelAndView ajaxLogin(HttpServletRequest request, HttpServletResponse response, UUserBo entity){

        ShiroToken token = null;
        try {
            token = new ShiroToken(entity.getUserName(), DesUtils.encrypt(entity.getPassword()),request.getRemoteHost());
        } catch (Exception e) {
            logger.error("密码加密失败:{}",e.getMessage());
            e.printStackTrace();
        }
        SecurityUtils.getSubject().login(token);
        ModelAndView model =new ModelAndView();
        model.setViewName("redirect:index.html");
     return model;
    }
    @RequestMapping(value = "index.html")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model =new ModelAndView();
        logger.info("index this Session id is {}",SecurityUtils.getSubject().getSession().getId());
        model.setViewName("index");
        return model;
    }


    @RequestMapping(value = "user.html")
    public ModelAndView getUser(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model =new ModelAndView();
        model.setViewName("user");
        return model;
    }


    @RequestMapping(value = "menu.html")
    public ModelAndView getMenu(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model =new ModelAndView();
        model.setViewName("menu");
        return model;
    }

}
