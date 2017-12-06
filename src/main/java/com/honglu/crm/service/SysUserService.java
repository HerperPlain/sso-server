package com.honglu.crm.service;

import com.honglu.crm.bo.UUserBo;
import com.honglu.crm.config.shiro.ShiroToken;
import com.honglu.crm.util.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 用户产销
 */
@Service
public class SysUserService {
    private  Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public UUserBo queryData(ShiroToken token){
        String sql = "select  \n" +
                "  \t\ta.user_id as id, a.user_name as userName, a.Nick_name as nickName, a.password, a.mobile, a.state, a.Create_time as createTime, a.Create_man as createMan, \n" +
                "    a.modify_time as modifyTime, a.modify_man as modifyMan, a.Remark as remark, a.user_pic as userPic, a.ip, a.last_login_time as lastLoginTime, c.Role_name as roleName, c.role_id as roleId\n" +
                "  \tfrom sc_user a\n" +
                "  \tleft join sc_user_role b on a.user_id = b.u_id\n" +
                "\tleft join sc_role c on b.r_id = c.role_id \n" +
                "  \twhere a.user_name = '"+token.getUsername()+"'\n" +
                "  \tand a.password = '"+ token.getPswd()+"'";
        List<Map<String,Object>> dataList = jdbcTemplate.queryForList(sql);
        if(dataList!=null && dataList.size()==1){
            Map<String,Object> map = dataList.get(0);
            UUserBo bo = new UUserBo();
            bo.setId(Integer.parseInt(String.valueOf(map.get("id"))));
            bo.setUserName(String.valueOf(map.get("userName")));
            bo.setNickName(String.valueOf(map.get("nickName")));
            bo.setPassword(String.valueOf(map.get("password")));
            bo.setMobile(String.valueOf(map.get("mobile")));
            bo.setState(Integer.parseInt(String.valueOf(map.get("state"))));
            bo.setCreateTime(String.valueOf(map.get("createTime")));
            bo.setCreateMan(String.valueOf(map.get("createMan")));
            bo.setModifyTime(String.valueOf(map.get("modifyTime")));
            bo.setModifyMan(String.valueOf(map.get("modifyMan")));
            bo.setRemark(String.valueOf(map.get("remark")));
            bo.setUserPic(String.valueOf(map.get("userPic")));
            bo.setIp(String.valueOf(map.get("ip")));
            bo.setLastLoginTime(String.valueOf(map.get("lastLoginTime")));
            bo.setRoleName(String.valueOf(map.get("roleName")));
            bo.setRoleId(Integer.parseInt(String.valueOf(map.get("roleId"))));
            return bo;
        }


        return  null;
    }
}
