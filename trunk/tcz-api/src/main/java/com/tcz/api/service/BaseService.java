package com.tcz.api.service;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {

	void setBaseMapper();

	int deleteByPrimaryKey(ID id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(ID id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKeyWithBLOBs(T record);

	int updateByPrimaryKey(T record);
}