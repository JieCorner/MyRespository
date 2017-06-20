package com.javabean;

public class ProductInfo {
	private int cost;
	private int praise;
	private int bad;
	private String place;
	public void setPlace(String place) {
		this.place = place;
	}
	public int getCost() {
		return cost;
	}
	public String getPlace() {
		return place;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
}
