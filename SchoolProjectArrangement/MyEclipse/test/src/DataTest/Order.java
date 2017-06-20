package DataTest;

import java.sql.Date;

public class Order {
	private String ProductID;
	private String username;
	private String staringplace;
	private String phone;
	private Date startdate;
	private String Adult;
	private String Children;
	private String Remark;
	private String Cost;
	
	public Order(String ProductID,String username,String staringplace,String phone,String startdate,
			String Adult,String Children,String Remark,String Cost) {
		String[] date="05/31/2016".split("/");
		this.ProductID=ProductID;
		this.username=username;
		this.staringplace=staringplace;
		this.phone=phone;
		this.startdate=new Date(new java.util.Date(startdate).getTime());
		this.Adult=Adult;
		this.Children=Children;
		this.Remark=Remark;
		this.Cost=Cost;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStaringplace() {
		return staringplace;
	}
	public void setStaringplace(String staringplace) {
		this.staringplace = staringplace;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getStartdate() {
		return startdate;
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
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	
}
