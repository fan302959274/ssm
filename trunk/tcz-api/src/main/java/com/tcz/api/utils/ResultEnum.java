package com.tcz.api.utils;

public enum ResultEnum {
	SUCCESS("1000", "成功", "返回正常"),
	// 登录相关
	LOGIN_ERROR("100000", "登录异常", "登录失败!"), ACCOUNT_NO_REGISTER("100001",
			"帐号未注册", "您尚未注册!"), PASSWORD_ERROR("100002", "密码错误", "密码输入有误"),
	// 注册相关
	REGISTER_ERROR("200000", "注册异常", "注册失败!"), ACCOUNT_REGISTERED("200001",
			"帐号已注册", "您的帐号已注册");

	private String code;
	private String msg;
	private String tips;

	private ResultEnum(String code, String msg, String tips) {
		this.code = code;
		this.msg = msg;
		this.tips = tips;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

}
