package com.Tourism.DataBase;

public class InsertUserInfo {
	static public Boolean insertuser(String username,String sex,String email,String password,String phone){
		String insertword="insert into tourism_user(username,sex,email,password,phone) values (?,?,?,?,?)";
		Boolean i=JDBCUtils.insertData(insertword,username,sex,email,password,phone);
		if(i==true){
			return true;
		}else{
			return false;
		}
	}
}
