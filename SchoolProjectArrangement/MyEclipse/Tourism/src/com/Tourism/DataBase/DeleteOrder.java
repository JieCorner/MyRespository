package com.Tourism.DataBase;


public class DeleteOrder {
	static public Boolean delete(String username,String productID){
		String deleteword="delete from tourism_order where ProductID='"+productID+"' and username='"+username+"'";
		return JDBCUtils.deleteOrder(deleteword);
	}
}
