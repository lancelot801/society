package cn.joongky.society.web;

import org.springframework.web.context.WebApplicationContext;

public class BeanFactoryContext {
	private static WebApplicationContext wac;
	private static String accessToken;
	private static String jsapiTicket;

	public static WebApplicationContext getWac() {
		return wac;
	}
	public static void setWac(WebApplicationContext wac) {
		BeanFactoryContext.wac = wac;
	}
	public static String getAccessToken() {
		return accessToken;
	}
	public static void setAccessToken(String accessToken) {
		BeanFactoryContext.accessToken = accessToken;
	}
	public static String getJsapiTicket() {
		return jsapiTicket;
	}
	public static void setJsapiTicket(String jsapiTicket) {
		BeanFactoryContext.jsapiTicket = jsapiTicket;
	}
	public static Object getService(String serviceName) {
		return wac.getBean(serviceName);
	}
}
