package com.tcz.api.model.vo.item;
/**
 * Vo - 彩票
 * 
 * @author candy.tam
 *
 */
public class LotteryVo {

	/** 彩票ID */
	private String id;
	
	/** 商品名称 */
	private String itemName;
	
	/** 商品图片 */
	private String itemImage;
	
	/** 用户主页 */
	private String memWeb;

	/** 会员姓名 */
	private String memName;
	
	/** 用户名 */
	private String memUserName;
	
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getMemUserName() {
		return memUserName;
	}

	public void setMemUserName(String memUserName) {
		this.memUserName = memUserName;
	}

	public String getMemWeb() {
		return memWeb;
	}

	public void setMemWeb(String memWeb) {
		this.memWeb = memWeb;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
