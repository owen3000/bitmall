package com.cafe24.bitmall.vo;

public class OrderProductOptVO {

	private long orderProductNo;
	private long optNo;
	public long getOrderProductNo() {
		return orderProductNo;
	}
	public void setOrderProductNo(long orderProductNo) {
		this.orderProductNo = orderProductNo;
	}
	public long getOptNo() {
		return optNo;
	}
	public void setOptNo(long optNo) {
		this.optNo = optNo;
	}
	@Override
	public String toString() {
		return "OrderProductOptVO [orderProductNo=" + orderProductNo + ", optNo=" + optNo + "]";
	}
	
	
}
