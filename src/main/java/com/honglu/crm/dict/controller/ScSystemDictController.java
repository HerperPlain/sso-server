package com.honglu.crm.dict.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.honglu.crm.dict.biz.SystemDictService;
import com.honglu.crm.dict.entity.SystemDictEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/dict")
public class ScSystemDictController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SystemDictService buImpl;

    @RequestMapping(value = "/queryData")
    public Map<String,Object> queryData(HttpServletRequest request, HttpServletResponse response,SystemDictEntity model){
        int pageSize = Integer.parseInt(String.valueOf(request.getParameter("length")));
        int pageStart = Integer.parseInt(String.valueOf(request.getParameter("start")));
        int pageNumber = (pageStart)/pageSize;
        String queryParams = request.getParameter("search[value]");
        Page<SystemDictEntity> page = buImpl.listViewAll(pageNumber,pageSize,queryParams);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("data",page.getContent());
        dataMap.put("sEcho",0);
        dataMap.put("iTotalRecords",0);
        dataMap.put("iTotalDisplayRecords",page.getTotalElements());
        dataMap.put("iDisplayStart",pageStart);
        dataMap.put("iDisplayLength",pageSize);
        return dataMap;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> save(HttpServletRequest request, HttpServletResponse response,SystemDictEntity model){
        logger.info("request data：【{}】",model);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("data","200");
        dataMap.put("message","success");
        return dataMap;
    }
}
