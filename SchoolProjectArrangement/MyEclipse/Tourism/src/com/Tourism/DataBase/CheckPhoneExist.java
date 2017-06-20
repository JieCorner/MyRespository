package com.Tourism.DataBase;

public class CheckPhoneExist {
	static public Boolean checkuser(String phone){
		return JDBCUtils.QueryDataExist("select * from tourism_user where phone=?",phone);
	}
}
