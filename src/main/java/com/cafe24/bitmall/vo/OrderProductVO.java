package com.cafe24.bitmall.vo;

public class OrderProductVO {

	private long no;
	private long orderNo;
	private long productNo;
	private long amount;
	private long price;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderProductVO [no=" + no + ", orderNo=" + orderNo + ", productNo=" + productNo + ", amount=" + amount
				+ ", price=" + price + "]";
	}

	
	
}
