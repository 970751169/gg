package com.gg.www.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.gg.www.client.backUser.BackUserUtils;
import com.gg.www.client.backUser.vo.BackUserVo;
import com.gg.www.common.JsonResult;

@Component
public class BackUserInterceptor implements HandlerInterceptor {

	private static final Log log = LogFactory.getLog("programLog");

	@Autowired
	protected JsonResult jsonResult;

	@Autowired
	protected BackUserUtils backUserUtils;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (request == null) {
			log.info("BackUserInterceptor|preHandle|request is null,false");
			return false;
		}
		response.setContentType("text/html;charset=UTF-8");
		String token = request.getHeader("token");
		if (token == null || token.length() == 0) {
			this.needLogin(request, response);
			return false;
		}
		log.info("BackUserInterceptor|preHandle|token=" + token);
		BackUserVo backUserVo = this.backUserUtils.getBackUserVo(token);
		if (backUserVo == null || backUserVo.getToken() == null || backUserVo.getToken().trim().length() == 0) {
			this.needLogin(request, response);
			return false;
		}
		request.setAttribute("backUserVo", backUserVo);
		// 权限部分 admin 是超级管理员，不需要验证权限
		// 这个过滤器用于过滤 controller包里面的 base 包，超级管理员可以通过，无需授权，其他人不给授权
		if ("admin".equals(backUserVo.getUsername()) || "超级管理员".equals(backUserVo.getRoleName())) {
			return this.ok(request, response, handler);
		}

		this.noPower(response);
		return false;
	}

	private boolean ok(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			return HandlerInterceptor.super.preHandle(request, response, handler);
		} catch (Exception e) {
			log.info("LoginInterceptor|preHandle|OK|e" + e);
			e.printStackTrace();
			return false;
		}
	}

	private void needLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().append(this.jsonResult.notLoggedIn(request.getAttribute("RequestURL")).toString());
		} catch (IOException e) {
			log.info("LoginInterceptor|needLogin|IOException|" + e);
			e.printStackTrace();
		}
	}

	private void noPower(HttpServletResponse response) {
		try {
			response.getWriter().append(this.jsonResult.noPower().toString());
		} catch (IOException e) {
			log.info("LoginInterceptor|noPower|IOException|" + e);
			e.printStackTrace();
		}
	}
}

