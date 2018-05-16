package com.linyus.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.linyus.utils.JsonUtil;

/**
 * create by eason on 2018年5月16日
 */
public class RspBean<T> implements Serializable {
	private static final long serialVersionUID = 7881959694504343932L;
	private static final String SUCCESS = "SUCCESS";

	private int code;
	private String msg;
	private T data;

	public RspBean() {}

	public int getCode() {
		return code;
	}

	public RspBean<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public RspBean<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public RspBean<T> setData(T data) {
		this.data = data;
		return this;
	}

	/**
	 * 返回成功
	 */
	public static <T> RspBean<T> success() {
		return new RspBean<T>().setMsg(SUCCESS);
	}
	
	/**
	 * 返回成功数据
	 */
	public static <T> RspBean<T> success(T data) {
		return new RspBean<T>().setMsg(SUCCESS).setData(data);
	}
	
	/**
	 * 返回成功数据(分页)
	 */
	public static <K> RspBean<PageBean<K>> success(Page<K> page) {
		return new RspBean<PageBean<K>>().setMsg(SUCCESS).setData(new PageBean<K>(page));
	}
	
	/**
	 * 返回失败
	 */
	public static <T> RspBean<T> fail(String msg) {
		return new RspBean<T>().setCode(-1).setMsg(msg);
	}
	
	/**
	 * 返回提示
	 */
	public static <T> RspBean<T> unSuit(int code, String msg) {
		return new RspBean<T>().setCode(code).setMsg(msg);
	}
	
	/**
	 * 返回分页实体
	 */
	public static <T> PageBean<T> pageBean(Page<T> page) {
		return new PageBean<T>(page);
	}
	
	/**
	 * 返回分页实体
	 */
	public static <T> PageBean<T> pageBean(List<T> content, Long total) {
		return new PageBean<T>(content, total);
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
