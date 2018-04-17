package com.cafe24.bitmall.vo;

public class OrderVO {

	private long no;
	private String date;
	private long totalPrice;
	private String state;
	private String paymentOption;
	private long userNo;
	private long deliverySiteNo;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	public long getDeliverySiteNo() {
		return deliverySiteNo;
	}
	public void setDeliverySiteNo(long deliverySiteNo) {
		this.deliverySiteNo = deliverySiteNo;
	}
	@Override
	public String toString() {
		return "OrderVO [no=" + no + ", date=" + date + ", totalPrice=" + totalPrice + ", state=" + state
				+ ", paymentOption=" + paymentOption + ", userNo=" + userNo + ", deliverySiteNo=" + deliverySiteNo
				+ "]";
	}
	
	
	
	
}
