package com.tcz.api.utils;

import java.io.Serializable;

import com.tcz.api.model.enums.ResultEnum;

public class ResponseUtil<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/** 响应结果码 */
	private String code = ResultEnum.SUCCESS.code;

	/** 结果描述，给调用方系统看的描述信息  */
	private String msg = ResultEnum.SUCCESS.msg;;

	/** 返回给调用方，需要显示给用户的的友好提示信息，请谨慎定义  */
	private String tips = ResultEnum.SUCCESS.tips;

	/** 返回结果 */
	private T result;
	
	public void setFacade(ResultEnum resultEnum){
		this.code = resultEnum.code;
		this.msg = resultEnum.msg;
		this.tips = resultEnum.tips;
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

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	

}
