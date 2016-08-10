package com.tcz.api.model.vo.item;
/**
 * Vo - 正在购物
 * 
 * @author candy.tam
 *
 */
public class CurrentShoppVo {

	/** 会员用户名 */
	private String userName;
	
	/** 个人主页 */
	private String userWeb;
	
	/** 用户头像 */
	private String userPhoto;
	
	/** 商品名称 */
	private String itemTitle;
	
	/** 商品路径 */
	private String itemPath;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserWeb() {
		return userWeb;
	}

	public void setUserWeb(String userWeb) {
		this.userWeb = userWeb;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemPath() {
		return itemPath;
	}

	public void setItemPath(String itemPath) {
		this.itemPath = itemPath;
	}
	
}
