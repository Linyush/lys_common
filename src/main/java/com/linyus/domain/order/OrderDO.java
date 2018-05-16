package com.linyus.domain.order;

import java.io.Serializable;
import java.util.Date;

import com.linyus.utils.JsonUtil;

/**
 * create by eason on 2018年5月16日
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = -4425915159547773514L;

	private Long id;
	private Date createTime;

	private String orderNo;
	private String product;
	private Integer status;

	public Long getId() {
		return id;
	}

	public OrderDO setId(Long id) {
		this.id = id;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public OrderDO setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public OrderDO setOrderNo(String orderNo) {
		this.orderNo = orderNo;
		return this;
	}

	public String getProduct() {
		return product;
	}

	public OrderDO setProduct(String product) {
		this.product = product;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public OrderDO setStatus(Integer status) {
		this.status = status;
		return this;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
