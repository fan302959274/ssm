package com.tcz.api.model.vo.item;

public class ItemOwnerVo {

	/** 商品名称 */
	private String itemTitle;
	
	/** 商品图片 */
	private String itemImage;
	
	/** 用户主页 */
	private String userWeb;
	
	/** 用户名 */
	private String userName;
	
	/** 期数 */
	private Integer periods;
	
	/** IP地址*/
	private String ipAddr;

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getUserWeb() {
		return userWeb;
	}

	public void setUserWeb(String userWeb) {
		this.userWeb = userWeb;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPeriods() {
		return periods;
	}

	public void setPeriods(Integer periods) {
		this.periods = periods;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	
}
