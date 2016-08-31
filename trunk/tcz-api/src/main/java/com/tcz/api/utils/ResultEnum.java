package com.tcz.api.utils;

/**
 * 客户端返回
 * code: 响应结果码
 * msg:  结果描述，给调用方系统看的描述信息
 * tips: 返回给调用方，需要显示给用户的的友好提示信息，请谨慎定义 
 * @author cf
 *
 */
public enum ResultEnum {
	SUCCESS("1000", "成功", "返回正常"),
	// 登录相关
	LOGIN_ERROR("100000", "登录异常", "登录失败!"), ACCOUNT_NO_REGISTER("100001",
			"帐号未注册", "您尚未注册!"), PASSWORD_ERROR("100002", "密码错误", "密码输入有误"),
	// 注册相关
	REGISTER_ERROR("200000", "注册异常", "注册失败!"), ACCOUNT_REGISTERED("200001",
			"帐号已注册", "您的帐号已注册");

	public String code;
	public String msg;
	public String tips;

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
