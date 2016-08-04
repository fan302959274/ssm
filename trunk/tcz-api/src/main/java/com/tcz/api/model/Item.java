package com.tcz.api.model;

import java.math.BigDecimal;
import java.util.Date;

public class Item {
    private Long id;

    /** 品牌ID */
    private Long brandId;

    /** 分类ID */
    private Long categoryId;

    /** 编号 */
    private String sn;

    /** 名称 */
    private String name;

    /** 展现图片*/
    private String image;

    /** 成本 */
    private BigDecimal cost;

    /** 已销售金额 */
    private Integer sales;

    /** 价格 */
    private Integer price;

    /** 当前期数 */
    private Integer periods;

    /** 最大期数 */
    private Integer maxPeriods;

    /** 是否上架 */
    private String isMarketable;

    /** 创建日期 */
    private Date createDate;

    /** 修改日期*/
    private Date modifyDate;

    /** 商品介绍 */
    private String introduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Integer getMaxPeriods() {
        return maxPeriods;
    }

    public void setMaxPeriods(Integer maxPeriods) {
        this.maxPeriods = maxPeriods;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable == null ? null : isMarketable.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}