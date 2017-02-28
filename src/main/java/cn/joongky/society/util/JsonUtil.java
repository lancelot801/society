package cn.joongky.society.util;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONArray;

public class JsonUtil {
	protected final static ObjectMapper objectMapper = new ObjectMapper();

	public static String obj2Json(Object obj) {
		StringWriter sw = new StringWriter();
		try {
			objectMapper.writeValue(sw, obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

	public static Object json2Obj(String json, Class<?> clz) {
		try {
			return objectMapper.readValue(json, clz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date[] getJsonToDateArray(String jsonString) {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Date[] dateArray = new Date[jsonArray.size()];
		String dateString;
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < jsonArray.size(); i++) {
			dateString = jsonArray.getString(i);
			try {
				date = sdf.parse(dateString);
				dateArray[i] = date;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dateArray;
	}
}
