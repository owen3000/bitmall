package com.cafe24.bitmall.vo;

public class SalesStatusVO {

	private long no;
	private String status;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SalesStatusVO [no=" + no + ", status=" + status + "]";
	}
	
	
	
}
