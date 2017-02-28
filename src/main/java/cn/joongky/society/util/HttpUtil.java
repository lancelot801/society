package cn.joongky.society.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	private static final String APPLICATION_JSON = "application/json";
	private static final String APPLICATION_URL = "x-www-form-urlencoded";

	public static String sendPost(String uri, String json) {

		String content = null;
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		
		try {
			httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(uri);
	        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
	        
	        StringEntity se = new StringEntity(json, ContentType.create(APPLICATION_JSON, "utf-8"));
	        //StringEntity se = new StringEntity(json);
	        //se.setContentType(CONTENT_TYPE_TEXT_JSON);
	        //se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
	        httpPost.setEntity(se);
			response = httpclient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 200 && statusCode < 400) {
				HttpEntity entity = response.getEntity();
				if (entity != null)
					content = EntityUtils.toString(entity, "UTF-8");
			}
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null)
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (httpclient != null)
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return content;
	}
	
	/**
	 * 
	 * @param contentType	"application/json" or "x-www-form-urlencoded"
	 * @param uri
	 * @return
	 */
	public static String sendGet(String contentType, String uri) {
		
		String content = null;
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		
		try {
			httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(uri);
			httpGet.addHeader(HTTP.CONTENT_TYPE, contentType);
			
			response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null)
				content = EntityUtils.toString(entity, "UTF-8");
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null)
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (httpclient != null)
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return content;
	}
	public static String sendGetWithHeader(String contentType, String authorization, String uri) {
		
		String content = null;
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		
		try {
			httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(uri);
			httpGet.addHeader(HTTP.CONTENT_TYPE, contentType);
			httpGet.addHeader("Authorization", authorization);
			
			response = httpclient.execute(httpGet);
				HttpEntity entity = response.getEntity();
				if (entity != null)
					content = EntityUtils.toString(entity, "UTF-8");
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null)
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (httpclient != null)
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return content;
	}

	public static String sendPostWithHeader(String accept, String contentType, String contentLength, String authorization, String uri, String json) {
		
		String content = null;
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		
		try {
			httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(uri);
			httpPost.addHeader(HTTP.CONTENT_TYPE, contentType);
			httpPost.addHeader("Accept", "application/json");
//			httpPost.addHeader("Content-Length", contentLength);
			httpPost.addHeader("Authorization", authorization);
			
			StringEntity se = new StringEntity(json, ContentType.create(APPLICATION_JSON, "utf-8"));
			//StringEntity se = new StringEntity(json);
			//se.setContentType(CONTENT_TYPE_TEXT_JSON);
			//se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
			httpPost.setEntity(se);
			response = httpclient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 200 && statusCode < 400) {
				HttpEntity entity = response.getEntity();
				if (entity != null)
					content = EntityUtils.toString(entity, "UTF-8");
			}
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null)
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (httpclient != null)
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return content;
	}
	
	public static String sendPostXml(String uri, String xml) {

		String content = null;
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		
		try {
			httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(uri);
	        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_URL);
	        
	        StringEntity se = new StringEntity(xml, ContentType.create(APPLICATION_URL, "utf-8"));
	        //StringEntity se = new StringEntity(json);
	        //se.setContentType(CONTENT_TYPE_TEXT_JSON);
	        //se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
	        httpPost.setEntity(se);
			response = httpclient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 200 && statusCode < 400) {
				HttpEntity entity = response.getEntity();
				if (entity != null)
					content = EntityUtils.toString(entity, "UTF-8");
			}
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null)
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (httpclient != null)
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return content;
	}
}
