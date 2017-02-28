package cn.joongky.society.web;

// 存放配置文件里面的值，单例
public class PropertyContext {
	private String appId;
	private String payAppId;
	private String mchId;
	private String payKey;
	private String appSecret;
	private String originUrl;
	private String token;
	private String msg;
	private int pageSize;
	private String imgurl;
	
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	private static PropertyContext propertyContext;
	
	private PropertyContext() {
	}
	
	public static PropertyContext getInstance() {
		if (propertyContext == null) {
			propertyContext = new PropertyContext();
		}
		return propertyContext;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public String getPayAppId() {
		return payAppId;
	}

	public void setPayAppId(String payAppId) {
		this.payAppId = payAppId;
	}
	
	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	
	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getOriginUrl() {
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
