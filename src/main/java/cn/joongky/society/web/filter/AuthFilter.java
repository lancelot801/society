package cn.joongky.society.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.joongky.exception.AdminException;
import cn.joongky.society.AbstractSociety;
import cn.joongky.society.pojo.UserLogin;

public class AuthFilter extends AbstractSociety implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	// 过滤所有请求
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		// httpResp.setHeader("Access-Control-Allow-Origin",
		// PropertyContext.getInstance().getOriginUrl());
		// httpResp.setHeader("Access-Control-Allow-Credentials", "true");

		String agent = httpReq.getHeader("User-Agent");
		Boolean isWechatAgent = null;
		if (agent != null && agent.toLowerCase().indexOf("micromessenger") >= 0) {
			isWechatAgent = true;
		} else {
			isWechatAgent = false;
		}
		UserLogin ul = (UserLogin) httpReq.getSession().getAttribute("userLogin");
		logger.info("用户请求的URL: " + httpReq.getRequestURI());
		if (httpReq.getRequestURI().contains("/admin")) {
			if (ul != null && ul.getRole().equals("admin")) {

			} else if (ul != null) {
				throw new AdminException("您不是管理员,无访问该接口权限");
			} else {
				throw new AdminException("尚未登录,无访问权限");
			}
		} else if (isWechatAgent) {

		} else if (httpReq.getRequestURI().contains("/student")) {
			if (ul == null) {
				throw new AdminException("尚未登录,无访问权限");
			}
		}
		/*
		 * else if (httpReq.getRequestURI().contains("/admin")) { if(ul!=null &&
		 * ul.getRole().equals("admin")){
		 * 
		 * }else if(ul!=null){ throw new AdminException("您不是管理员,无访问该接口权限");
		 * }else{ throw new AdminException("尚未登录,无访问权限"); }
		 * 
		 * }else if(isWechatAgent) {
		 * 
		 * }
		 */
		chain.doFilter(httpReq, httpResp);
	}

	@Override
	public void destroy() {

	}

}
