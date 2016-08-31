package com.tcz.api.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * copy对象至map中null改为""
 *
 * @class com.xianglin.xlnodecore.common.util.BeanUtils
 * @date 2015年9月17日 下午2:18:46
 */
public class BeanUtils {

	public static final Logger log = LoggerFactory.getLogger(BeanUtils.class);

	public static List<Map<String, Object>> beanToMap(List<?> source) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		if (source == null) {
			throw new Exception("beanToMap source bean is null");
		}
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for (Object s : source) {
			Map<String, Object> map = new HashMap<String, Object>();
			Field[] fds = s.getClass().getDeclaredFields();
			for (Field f : fds) {
				f.setAccessible(true);
				if(null != f.get(source)){
					if("class java.util.Date".equals(f.getType().toString())){
						map.put(f.getName(),sf.format(f.get(source)));
					}else{
						map.put(f.getName(),f.get(source));
					}
				}else{
						map.put(f.getName(),"");
				}
			}
			mapList.add(map);
		}

		return mapList;
	}

	public static Map<String, Object> beanToMap(Object source) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		if (source == null) {
			throw new Exception("beanToMap source bean is null");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fds = source.getClass().getDeclaredFields();
		for (Field f : fds) {
			f.setAccessible(true);
			if(null != f.get(source)){
				if("class java.util.Date".equals(f.getType().toString())){
					map.put(f.getName(),sf.format(f.get(source)));
				}else{
					map.put(f.getName(),f.get(source));
				}
			}else{
					map.put(f.getName(),"");
			}
			
		}
		return map;
	}

}
