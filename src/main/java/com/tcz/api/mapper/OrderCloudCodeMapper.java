package com.tcz.api.mapper;

import com.tcz.api.model.OrderCloudCode;

public interface OrderCloudCodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_cloudCode
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_cloudCode
     *
     * @mbggenerated
     */
    int insert(OrderCloudCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_cloudCode
     *
     * @mbggenerated
     */
    int insertSelective(OrderCloudCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_cloudCode
     *
     * @mbggenerated
     */
    OrderCloudCode selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_cloudCode
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrderCloudCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_cloudCode
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderCloudCode record);
}