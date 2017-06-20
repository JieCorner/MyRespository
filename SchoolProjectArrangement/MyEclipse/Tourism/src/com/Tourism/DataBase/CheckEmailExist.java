package com.Tourism.DataBase;

public class CheckEmailExist {
	static public Boolean checkuser(String email){
		return JDBCUtils.QueryDataExist("select * from tourism_user where email=?",email);
	}
}
