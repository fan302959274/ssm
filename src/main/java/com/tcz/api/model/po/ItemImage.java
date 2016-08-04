package com.tcz.api.model.po;

import java.util.Date;

public class ItemImage {
    private Long id;

    /** 商品ID */
    private Long itemId;

    /** 标题 */
    private String title;

    /** 原图 */
    private String source;

    /** 大图 */
    private String large;

    /** 中图 */
    private String medium;

    /** 小图 */
    private String thumbnail;

    /** 顺序 */
    private Integer order;

    /** 创建日期 */
    private Date createDate;

    /** 修改日期*/
    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large == null ? null : large.trim();
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium == null ? null : medium.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
}