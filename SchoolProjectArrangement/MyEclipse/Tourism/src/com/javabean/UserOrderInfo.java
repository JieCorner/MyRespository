package com.javabean;

import java.sql.Date;

public class UserOrderInfo {
	private String ProductID;
	private String staringplace;
	private String endplace;
	private String timeconsume;
	private String startdate;
	private String Adult;
	private String Children;
	private String Cost;
	public UserOrderInfo(String ProductID,String staringplace,String endplace,String timeconsume,
			String startdate,String Adult,String Children,String Cost) {
		this.ProductID=ProductID;
		this.staringplace=staringplace;
		this.endplace=endplace;
		this.startdate=startdate;
		this.timeconsume=timeconsume;
		this.Adult=Adult;
		this.Children=Children;
		this.Cost=Cost;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public String getStaringplace() {
		return staringplace;
	}
	public void setStaringplace(String staringplace) {
		this.staringplace = staringplace;
	}
	public String getEndplace() {
		return endplace;
	}
	public void setEndplace(String endplace) {
		this.endplace = endplace;
	}
	public String getTimeconsume() {
		return timeconsume;
	}
	public void setTimeconsume(String timeconsume) {
		this.timeconsume = timeconsume;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getAdult() {
		return Adult;
	}
	public void setAdult(String adult) {
		Adult = adult;
	}
	public String getChildren() {
		return Children;
	}
	public void setChildren(String children) {
		Children = children;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	
	
}
