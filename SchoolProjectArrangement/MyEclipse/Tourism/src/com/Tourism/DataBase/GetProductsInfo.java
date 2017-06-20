package com.Tourism.DataBase;

import com.javabean.ProductInfo;

public class GetProductsInfo {
	static public ProductInfo getproductinfo(String id){
		return JDBCUtils.QueryOrder("select * from tourism_products where orderID=?",id);
	}
}
