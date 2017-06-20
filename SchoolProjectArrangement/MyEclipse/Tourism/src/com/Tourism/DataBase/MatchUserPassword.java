package com.Tourism.DataBase;

public class MatchUserPassword {
	static public Boolean matchuserpwd(String username,String password){
		Boolean exist=JDBCUtils.QueryDataExist("select * from tourism_user where username=?",username);
		if(exist){
			String getpassword=JDBCUtils.QueryMatchPassword("select * from tourism_user where username=?", username);
			if(getpassword!=null&&getpassword.equals(password)){     
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	static public Boolean matchemailpwd(String email,String password){
		Boolean exist=JDBCUtils.QueryDataExist("select * from tourism_user where email=?",email);
		if(exist){
			String getpassword=JDBCUtils.QueryMatchPassword("select * from tourism_user where email=?", email);
			if(getpassword!=null&&getpassword.equals(password)){     
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}
