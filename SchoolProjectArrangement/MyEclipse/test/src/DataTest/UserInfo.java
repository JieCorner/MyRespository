package DataTest;

public class UserInfo {
	private String UserName;
	private String Sex;
	private String Email;
	private String Phone;	
	public UserInfo(String UserName,String Sex,String Email,String Phone) {
		this.Email=Email;
		this.UserName=UserName;
		this.Phone=Phone;
		this.Sex=Sex;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	private String PassWord;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}	
}
