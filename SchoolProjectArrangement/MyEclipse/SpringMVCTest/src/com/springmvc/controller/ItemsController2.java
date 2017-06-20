package com.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springmvc.po.Items;

/**
 * Title:
 * Model:
 * Description:
 * @author 郑耿杰
 * @date 2017年5月13日
 */
public class ItemsController2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Items> itemsList=new ArrayList<Items>();
		
		Items items_1=new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(5000f);
		items_1.setDetail("ThinkPad T430联想笔记本电脑!");
		
		Items items_2=new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机!");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		
		request.setAttribute("itemsList", itemsList);
		request.setAttribute("Controller", "ItemsController2");
		request.getRequestDispatcher("/items/itemsList.jsp").forward(request, response);
	}

	

}
