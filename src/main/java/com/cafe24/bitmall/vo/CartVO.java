package com.cafe24.bitmall.vo;

public class CartVO {

	private long no;
	private long userNo;
	private long productNo;
	private long amount;
	private long price;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
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
		return "CartVO [no=" + no + ", userNo=" + userNo + ", productNo=" + productNo + ", amount=" + amount
				+ ", price=" + price + "]";
	}
	

	
	
}
