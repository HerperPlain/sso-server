package com.honglu.crm.config.shiro;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
	
public class SessionManager extends DefaultWebSessionManager {
	public Logger logger = LoggerFactory.getLogger(getClass());
	public SessionManager() {
		super();
	}

	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		// 如果参数中包含“__sid”参数，则使用此sid会话。
		// 例如：http://localhost/project?_sid=xxx&_cookie=true
		// 其实这里还可以使用如下参数：cookie中的session名称：如：JSESSIONID=xxx,路径中的
		// ;JESSIONID=xxx，但建议还是使用 __sid参数。
		String sid = request.getParameter("_sid");
		if (StringUtils.isNotBlank(sid)) {
			logger.info("request params is 【{}】",sid);
			// 是否将sid保存到cookie，浏览器模式下使用此参数。
			if (WebUtils.isTrue(request, "_cookie")) {
				HttpServletRequest rq = (HttpServletRequest) request;
				HttpServletResponse rs = (HttpServletResponse) response;
				Cookie template = getSessionIdCookie();
				Cookie cookie = new SimpleCookie(template);
				cookie.setValue(sid);
				cookie.saveTo(rq, rs);
			}
			// 设置当前session状态
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
					// session来源与url
					ShiroHttpServletRequest.URL_SESSION_ID_SOURCE);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sid);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
			return sid;
		} else {
			return super.getSessionId(request, response);
		}
	}

}
