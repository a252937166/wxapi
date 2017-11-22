package com.ouyang.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

/**
 * 返回数据
 * @author hanjiang.Yue
 *
 * @param <T>
 */
public class HttpResult<T> implements Serializable{

	private static final long serialVersionUID = 7475582465876485316L;

	private static final Integer CODE_SUCCESS = 200;

	private Integer code = CODE_SUCCESS;

	private boolean success = true;

	private String msg;
	
	@JsonInclude(Include.NON_NULL)
	private T result;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
}
