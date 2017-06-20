package com.easyui.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport {
	public Map responseJson;
	private int page;
	private int rows;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Map getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
       
        for(int i=page*10-10;i<page*rows;i++){
          Map<String, Object> m = new HashMap<String, Object>();  
          m.put("user", "蜡笔小新"+i);  
          m.put("email", "xiaoxin@163.com");  
          m.put("date", "2014-10-1");  
          list.add(m);  
        }
//        Map<String, Object> m = new HashMap<String, Object>();  
//        m.put("user", "蜡笔小新");  
//        m.put("email", "xiaoxin@163.com");  
//        m.put("date", "2014-10-1");  
//        list.add(m);  
//  
//        Map<String, Object> m1 = new HashMap<String, Object>();  
//        m1.put("user", "樱桃小丸子");  
//        m1.put("email", "yingtao@163.com");  
//        m1.put("date", "2014-10-1");  
//        list.add(m1);  
        
        
        map.put("rows", list);  
        map.put("total", 20);  //显示行数
		//请求时会默认传递page和rows参数到服务器,由服务器根据这两个判断返回的行数数据(用firefix查看)
        //如果从数据库查询的话可以用LIMIT参数
        
//		System.out.println(page+":"+rows);
        this.setResponseJson(map);  
		return SUCCESS;
	}
	
	
}
