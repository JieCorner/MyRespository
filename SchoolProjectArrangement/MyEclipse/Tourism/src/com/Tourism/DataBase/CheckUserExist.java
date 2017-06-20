package com.Tourism.DataBase;

public class CheckUserExist {
	static public Boolean checkuser(String username){
		return JDBCUtils.QueryDataExist("select * from tourism_user where username=?",username);
	}
}
