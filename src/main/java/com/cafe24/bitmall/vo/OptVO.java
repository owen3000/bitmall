package com.cafe24.bitmall.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class OptVO {

	private long no;
	@NotEmpty
	private String name;
	private String value;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "OptVO [no=" + no + ", name=" + name + ", value=" + value + "]";
	}
	

	
	
}
