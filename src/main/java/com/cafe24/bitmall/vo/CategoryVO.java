package com.cafe24.bitmall.vo;

public class CategoryVO {

	private long no;
	private String name;
	private String description;
	private String date;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CategoryVO [no=" + no + ", name=" + name + ", description=" + description + ", date=" + date + "]";
	}
	
	
}
