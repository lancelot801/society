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

import cn.joongky.society.AbstractSociety;
import cn.joongky.society.web.PropertyContext;

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
//		httpResp.setHeader("Access-Control-Allow-Origin", PropertyContext.getInstance().getOriginUrl());
//		httpResp.setHeader("Access-Control-Allow-Credentials", "true");

		String agent = httpReq.getHeader("User-Agent");
		Boolean isWechatAgent = null;
		if (agent != null && agent.toLowerCase().indexOf("micromessenger") >= 0) {
			isWechatAgent = true;
		} else {
			isWechatAgent = false;
		}
		//Person p = (Person) httpReq.getSession().getAttribute("person");
		// 拦截1
		if (!isWechatAgent) {
//			if (url.indexOf("/wx") >= 0 && !(url.indexOf("/wx/wget") >= 0)) {
//				return;
//			}
//			// 拦截3
//			if (url.indexOf("/api") >= 0 && !(url.indexOf("/wx") >= 0)) {
//				if (p == null) {
//					System.out.println("session中没有person, 返回code-101，前端跳转");
//					httpResp.getWriter().write("{\"resultCode\":-101,\"reason\":\"No session\"}");
//					return;
//				}
//			}
		} else if (isWechatAgent ) {
			// TODO 临时后台测试登录
//			PersonService personService = (PersonService) BeanFactoryContext.getService("personService");
//			p = personService.getPersonByOpenid("o_ZEjwMBW4cPp72Sn4ONzFa-7BAk");
//			httpReq.getSession().setAttribute("person", p);
//			System.out.println( 
//			(WechatUtil.replaceAccessToken(WechatFinalValue.QUERY_USER).
//			replace("OPENID","o_ZEjwMBW4cPp72Sn4ONzFa-7BAk" )));
		}

		chain.doFilter(httpReq, httpResp);
	}

	@Override
	public void destroy() {

	}

}
