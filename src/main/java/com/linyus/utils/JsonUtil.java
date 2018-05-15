package com.linyus.utils;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * create by eason on 2018年5月15日
 */
public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * object转换为json
	 */
	public static String toJson(Object data) {
		try {
			return mapper.writeValueAsString(data);
		} catch (Exception e) {
			System.err.println("json格式转换异常, " + e);
		}
		return null;
	}
	
	/**
	 * json转换为object(无泛型要求)
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		if (StringUtils.isNotBlank(json)) {
			try {
				return mapper.readValue(json, clazz);
			} catch (Exception e) {
				System.err.println("json格式转换异常, " + e);
			}
		}
		return null;
	}
	
	/**
	 * json转换为object(泛型要求)
	 */
	public static <T> T fromJson(String json, TypeReference<T> typeRef) {
		if (StringUtils.isNotBlank(json)) {
			try {
				return mapper.readValue(json, typeRef);
			} catch (Exception e) {
				System.err.println("json格式转换异常, " + e);
			}
		}
		return null;
	}
	
	/**
	 * object转换为object(无泛型要求)
	 */
	public static <T> T objToObj(Object obj, Class<T> clazz) {
		return fromJson(toJson(obj), clazz);
	}
	
	/**
	 * object转换为object(泛型要求)
	 */
	public static <T> T objToObj(Object obj, TypeReference<T> typeRef) {
		return fromJson(toJson(obj), typeRef);
	}
}
