package com.cafe24.bitmall.vo;

public class EventVO {

	private long no;
	private String title;
	private double rate;
	private String originalIcon;
	private String saveIcon;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getOriginalIcon() {
		return originalIcon;
	}
	public void setOriginalIcon(String originalIcon) {
		this.originalIcon = originalIcon;
	}
	public String getSaveIcon() {
		return saveIcon;
	}
	public void setSaveIcon(String saveIcon) {
		this.saveIcon = saveIcon;
	}
	@Override
	public String toString() {
		return "EventVO [no=" + no + ", title=" + title + ", rate=" + rate + ", originalIcon=" + originalIcon
				+ ", saveIcon=" + saveIcon + "]";
	}
	
	
	
}
