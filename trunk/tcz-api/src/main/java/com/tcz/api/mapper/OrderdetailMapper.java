package com.tcz.api.mapper;

import com.tcz.api.model.Orderdetail;

public interface OrderdetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_detail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_detail
     *
     * @mbggenerated
     */
    int insert(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_detail
     *
     * @mbggenerated
     */
    int insertSelective(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_detail
     *
     * @mbggenerated
     */
    Orderdetail selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcz_order_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Orderdetail record);
}