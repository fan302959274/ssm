package com.tcz.api.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author cf
 *
 */
public interface MemberService {
	 List<Map<String, Object>> selectYunRecord(Long id);
}
