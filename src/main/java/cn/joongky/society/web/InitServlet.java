package cn.joongky.society.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.joongky.society.util.PropertiesUtil;


public class InitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static WebApplicationContext wac;
	private static String realpath;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//初始化spring的工厂
		wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		realpath = config.getServletContext().getRealPath("");
		BeanFactoryContext.setWac(wac);
		// 读取settings.properties里面的值
		PropertiesUtil.setPropertyContext();
	}

	public static WebApplicationContext getWac() {
		return wac;
	}

	public static String getRealpath() {
		return realpath;
	}
}
