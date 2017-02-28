package cn.joongky.society.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import cn.joongky.society.web.PropertyContext;


public class PropertiesUtil {

	private static PropertiesUtil util = null;
	private static Map<String, Properties> props = null;

	private PropertiesUtil() {
	}

	public static PropertiesUtil getInstance() {
		if (util == null) {
			props = new HashMap<String, Properties>();
			util = new PropertiesUtil();
		}
		return util;
	}

	public Properties load(String name) {
		if (props.get(name) != null) {
			return props.get(name);
		} else {
			Properties prop = new Properties();
			try {
				prop.load(new InputStreamReader(PropertiesUtil.class.getResourceAsStream("/" + name + ".properties"), "UTF-8"));
				props.put(name, prop);
				return prop;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// 加载resources目录下面的settings.properties文件
	public static void setPropertyContext() {
		Properties prop = PropertiesUtil.getInstance().load("settings");
		PropertyContext.getInstance().setAppId(prop.getProperty("app_id"));
		PropertyContext.getInstance().setPayAppId(prop.getProperty("pay_app_id"));
		PropertyContext.getInstance().setMchId(prop.getProperty("mch_id"));
		PropertyContext.getInstance().setPayKey(prop.getProperty("pay_key"));
		PropertyContext.getInstance().setImgurl(prop.getProperty("img_url"));
		PropertyContext.getInstance().setAppSecret(prop.getProperty("appsecret"));
		PropertyContext.getInstance().setOriginUrl(prop.getProperty("origin_url"));
		PropertyContext.getInstance().setToken(prop.getProperty("token"));
		PropertyContext.getInstance().setMsg(prop.getProperty("msg"));
		PropertyContext.getInstance().setPageSize(Integer.parseInt(prop.getProperty("pageSize")));
	}
}