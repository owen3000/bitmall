package com.cafe24.bitmall.vo;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class ProductVO {

	private long no;
	@NotBlank
	private String code;
	@NotEmpty 
	private String name;
	@NotEmpty
	private String manufacturer;
	private long price;
	@NotEmpty
	private String description;
	private long categoryNo;
	private long salesStatusNo;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public long getSalesStatusNo() {
		return salesStatusNo;
	}
	public void setSalesStatusNo(long salesStatusNo) {
		this.salesStatusNo = salesStatusNo;
	}
	@Override
	public String toString() {
		return "ProductVO [no=" + no + ", code=" + code + ", name=" + name + ", manufacturer=" + manufacturer
				+ ", price=" + price + ", description=" + description + ", categoryNo=" + categoryNo
				+ ", salesStatusNo=" + salesStatusNo + "]";
	}
	
	
}
