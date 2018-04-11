package com.cafe24.bitmall.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVO {

	private long no;
	@NotEmpty
	private String id;
	@NotEmpty
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty @Pattern(regexp="^[1-2]{1}[0-9]{3}[-][0-1]{0,1}[0-9]{1}[-][0-3]{1}[0-9]{1}$")
	private String birth;
	@NotEmpty @Pattern(regexp="^[0]{1}[0-9]{1,2}[-][0-9]{3,4}[-][0-9]{4}$")
	private String tel;
	@NotEmpty @Pattern(regexp="^[0]{1}[0-9]{2}[-][0-9]{4}[-][0-9]{4}$")
	private String phone;
	@NotEmpty @Pattern(regexp="^[0-9]{2,4}[-][0-9]{2,4}$")
	private String zipcode;
	@NotEmpty
	private String address;
	@NotEmpty @Email
	private String email;
	private String regDate;
	private String delete;
	private String auth;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "UserVO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", birth=" + birth
				+ ", tel=" + tel + ", phone=" + phone + ", zipcode=" + zipcode + ", address=" + address + ", email="
				+ email + ", regDate=" + regDate + ", delete=" + delete + ", auth=" + auth + "]";
	}

	
	
	
}
