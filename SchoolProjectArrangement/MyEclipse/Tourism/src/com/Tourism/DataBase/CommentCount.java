package com.Tourism.DataBase;

public class CommentCount {
	static public int getComCount(String key){
		return JDBCUtils.GetProductCount("select count(*) from tourism_comment where productsID=?", key);
	}
}
