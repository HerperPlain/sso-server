package com.honglu.crm.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ShiroSSOUpmFilter extends PermissionsAuthorizationFilter {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        logger.info("权限校验数据为：{}",mappedValue);
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isAuthenticated()){//判断用户是否是登录状态
            logger.info("当前用户为登录状态");
            return true;
        }
        logger.info("当前用户为登出状态，需要重新登录");
        return false;
//        return super.isAccessAllowed(request, response, mappedValue);
    }
}
