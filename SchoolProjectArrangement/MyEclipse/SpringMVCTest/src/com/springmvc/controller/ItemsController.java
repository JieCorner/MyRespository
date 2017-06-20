package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class ItemsController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
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
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.addObject("Controller","ItemsController");
		modelAndView.setViewName("/items/itemsList.jsp");
		
		return modelAndView;
	}

}
