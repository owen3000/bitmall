package com.cafe24.bitmall.vo;

public class DeliverySiteVO {

	private long no;
	private String name;
	private String tel;
	private String phone;
	private String email;
	private String zipcode;
	private String address;
	private String requirements;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	@Override
	public String toString() {
		return "DeliverySiteVO [no=" + no + ", name=" + name + ", tel=" + tel + ", phone=" + phone + ", email=" + email
				+ ", zipcode=" + zipcode + ", address=" + address + ", requirements=" + requirements + "]";
	}
	
	
}
