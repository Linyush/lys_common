package com.linyus.response;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;

import com.linyus.utils.JsonUtil;

/**
 * create by eason on 2018年4月8日
 */
public class PageBean<T> implements Serializable {
	private static final long serialVersionUID = 2490549037212562206L;

	private List<T> content = Collections.emptyList();
	private Long total = 0L;

	public PageBean() {}

	public PageBean(List<T> content, Long total) {
		this.content = content;
		this.total = total;
	}

	public PageBean(Page<T> page) {
		this.content = page.getContent();
		this.total = page.getTotalElements();
	}

	public List<T> getContent() {
		return content;
	}

	public PageBean<T> setContent(List<T> content) {
		this.content = content;
		return this;
	}

	public Long getTotal() {
		return total;
	}

	public PageBean<T> setTotal(Long total) {
		this.total = total;
		return this;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
}