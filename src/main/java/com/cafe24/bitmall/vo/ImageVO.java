package com.cafe24.bitmall.vo;

public class ImageVO {

	private long no;
	private String originalName;
	private String saveName;
	private long productNo;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	@Override
	public String toString() {
		return "ImageVO [no=" + no + ", originalName=" + originalName + ", saveName=" + saveName + ", productNo="
				+ productNo + "]";
	}
	
	
	
}
