package com.tcz.api.model.enums;

/**
 * 前台返回码 code: 结果返回码 msg: 结果描述，给调用方系统看的描述信息 tips: 返回给调用方，需要显示给用户的的友好提示信息，请谨慎定义
 * 
 * @author cf
 *
 */
public enum ResultEnum {
	SUCCESS("1000", "成功", "返回正常"), ERROR("4000", "异常", "系统异常"),
	// 登录相关
	LOGIN_ERROR("100000", "登录异常", "登录失败！"), ACCOUNT_NO_REGISTER("100001",
			"帐号未注册", "您的帐号未注册！"), PASSWORD_ERROR("100002", "密码错误", "密码输入错误"), ACCOUNT_ERROR(
			"100003", "帐号错误", "帐号不存在"), ACCOUNT_NO_ENABLED("100004", "帐号未激活",
			"此帐号未激活，请与客服联系！"), ACCOUNT_FREEZE("100005", "帐号已冻结",
			"帐号已冻结，请与客服联系！"), PASSWORD_LOCKED_FIVEMIN("100006", "密码被锁定",
			"失败次数超限，被冻结5分钟！"), PASSWORD_LOCKED("100007", "密码被锁定",
			"密码被系统锁定，请与客服联系！"),
	// 注册相关
	REGISTER_ERROR("200000", "注册异常", "注册失败！"), ACCOUNT_REGISTERED("200001",
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
