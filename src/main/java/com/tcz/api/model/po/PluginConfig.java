package com.tcz.api.model.po;

import java.util.Date;

public class PluginConfig {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tcz_plugin_config.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tcz_plugin_config.version
     *
     * @mbggenerated
     */
    private Long version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tcz_plugin_config.orders
     *
     * @mbggenerated
     */
    private Integer orders;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tcz_plugin_config.s_enabled
     *
     * @mbggenerated
     */
    private String sEnabled;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tcz_plugin_config.create_time
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tcz_plugin_config.modify_time
     *
     * @mbggenerated
     */
    private Date modifyDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tcz_plugin_config.attributes
     *
     * @mbggenerated
     */
    private String attributes;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tcz_plugin_config.id
     *
     * @return the value of tcz_plugin_config.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tcz_plugin_config.id
     *
     * @param id the value for tcz_plugin_config.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tcz_plugin_config.version
     *
     * @return the value of tcz_plugin_config.version
     *
     * @mbggenerated
     */
    public Long getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tcz_plugin_config.version
     *
     * @param version the value for tcz_plugin_config.version
     *
     * @mbggenerated
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tcz_plugin_config.orders
     *
     * @return the value of tcz_plugin_config.orders
     *
     * @mbggenerated
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tcz_plugin_config.orders
     *
     * @param orders the value for tcz_plugin_config.orders
     *
     * @mbggenerated
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tcz_plugin_config.s_enabled
     *
     * @return the value of tcz_plugin_config.s_enabled
     *
     * @mbggenerated
     */
    public String getsEnabled() {
        return sEnabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tcz_plugin_config.s_enabled
     *
     * @param sEnabled the value for tcz_plugin_config.s_enabled
     *
     * @mbggenerated
     */
    public void setsEnabled(String sEnabled) {
        this.sEnabled = sEnabled == null ? null : sEnabled.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tcz_plugin_config.create_time
     *
     * @return the value of tcz_plugin_config.create_time
     *
     * @mbggenerated
     */
    public Date getcreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tcz_plugin_config.create_time
     *
     * @param createDate the value for tcz_plugin_config.create_time
     *
     * @mbggenerated
     */
    public void setcreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tcz_plugin_config.modify_time
     *
     * @return the value of tcz_plugin_config.modify_time
     *
     * @mbggenerated
     */
    public Date getmodifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tcz_plugin_config.modify_time
     *
     * @param modifyDate the value for tcz_plugin_config.modify_time
     *
     * @mbggenerated
     */
    public void setmodifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tcz_plugin_config.attributes
     *
     * @return the value of tcz_plugin_config.attributes
     *
     * @mbggenerated
     */
    public String getAttributes() {
        return attributes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tcz_plugin_config.attributes
     *
     * @param attributes the value for tcz_plugin_config.attributes
     *
     * @mbggenerated
     */
    public void setAttributes(String attributes) {
        this.attributes = attributes == null ? null : attributes.trim();
    }
}