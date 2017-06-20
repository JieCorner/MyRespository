package com.news.management.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.news.management.bean.IndexData;
import com.news.management.bean.NewsCategory;
import com.news.management.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	private NewsService newsService;
	private static IndexData indexdata=new IndexData();
	public Map responseJson;
	public NewsService getNewsService() {
		return newsService;
	}
	@Autowired
	public void setNewsService(@Qualifier("newsService")NewsService newsService) {
		this.newsService = newsService;
	}
	public Map getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}

	public IndexData getIndexdata() {
		return indexdata;
	}

	public void setIndexdata(IndexData indexdata) {
		this.indexdata = indexdata;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("INDEXDATA")==null){
			session.setAttribute("INDEXDATA", "get");
			//设置数据
			indexdata.setNewslist(newsService.getNewsList());
			indexdata.setCategorylist(newsService.getCategoryList());
		}else if("get".equals(session.getAttribute("INDEXDATA"))){
		}
		return SUCCESS;
	}
	
	public String getIndexData(){
		Map<String, String> map = new HashMap<String, String>();
		//循环
		String indexdataforajax="";
		for(int i=0;i<indexdata.getNewslist().size();i++){
			//显示新闻
			indexdataforajax+="<div class='RealtimeNew' style='width: 500px;height: 100px;margin-top: 40px'><img style='height: 120px;width: 180px;float:left;margin-right: 20px;' class='media-object' src='"+indexdata.getNewslist().get(i).getPicName()+"'><div style='width: 300px;float: left'><h3><a href='ViewNewsForUserAction?news.NumberId="+indexdata.getNewslist().get(i).getNumberId()+"' style='color:#000000'><p class='RealNewsTitle'>"+indexdata.getNewslist().get(i).getTitle()+"</p></a></h3><p class='RealNewsIntro'>"+indexdata.getNewslist().get(i).getNewsSource()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+indexdata.getNewslist().get(i).getViewtimes()+"次浏览</p></div></div>";
		}
		map.put("requestnewslisthtml", indexdataforajax);
		String categorydataforajax="";
		//System.out.println(indexdata.getCategorylist().size());
		if(indexdata.getCategorylist().size()<6){
			for(int i=0;i<indexdata.getCategorylist().size();i++){
				//显示类别
				categorydataforajax+="<li class='newCategoryClass' style='width:60px'><a href='getNewsByCategoryAction.action?categoryId="+indexdata.getCategorylist().get(i).getCategoryId()+"' style='color: ivory'> "+indexdata.getCategorylist().get(i).getNewsCategoryName()+" </a></li>";
			}
		}else{
			for(int i=0;i<5;i++){
				//显示类别
				categorydataforajax+="<li class='newCategoryClass' style='width:60px'><a href='getNewsByCategoryAction.action?categoryId="+indexdata.getCategorylist().get(i).getCategoryId()+"' style='color: ivory'> "+indexdata.getCategorylist().get(i).getNewsCategoryName()+" </a></li>";
			}
			categorydataforajax+="<li class='dropdown'><a href='#' style='color:white' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>更多<span class='caret'></span></a><ul class='dropdown-menu'>";
			for(int i=5;i<indexdata.getCategorylist().size();i++){
				categorydataforajax+="<li><a href='getNewsByCategoryAction.action?categoryId="+indexdata.getCategorylist().get(i).getCategoryId()+"'>"+indexdata.getCategorylist().get(i).getNewsCategoryName()+"</a>";
			}
			categorydataforajax+="</ul></li>";
		}
		
		map.put("requestcategoryhtml", categorydataforajax);
		this.setResponseJson(map);  
		return SUCCESS;
	}
	
	
}
