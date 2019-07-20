package com.heyc.gasstation.softem.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {
	
	/**
	 * ����תjson��
	 * @param obj
	 * @return
	 */
	public static String JSONTOString(Object obj) {
		try {
			if (obj != null) {
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(obj);
				return json;
			}
		} catch (JsonProcessingException e) {
			return null;
		}
		return null;
	}
	
	/**
	 * �ַ���תִ�з��ͼ���
	 * @param jsonStr
	 * @param collectionClass
	 * @param elementClasses
	 * @return
	 * @throws Exception
	 */
	public static <T> T readJson(String jsonStr, Class<?> collectionClass, Class<?>... elementClasses) throws Exception {
	       ObjectMapper mapper = new ObjectMapper();

	       JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);

	       return mapper.readValue(jsonStr, javaType);

	}
	
}
