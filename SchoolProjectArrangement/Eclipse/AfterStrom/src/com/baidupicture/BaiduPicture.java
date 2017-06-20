package com.baidupicture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class BaiduPicture
{
	public static void main(String[] args) throws Exception, IOException
	{
		String str="http://image.baidu.com/data/imgs?col=%E7%BE%8E%E5%A5%B3&tag=%E5%B0%8F%E6%B8%85%E6%96%B0&sort=0&pn=10&rn=10&p=channel&from=1";
		String str1="http://image.baidu.com/data/imgs?col=";
		str1+=URLEncoder.encode("美女");
		str1+="&tag=";
		str1+=URLEncoder.encode("西洋美人");
		str1+="&sort=0&pn=10&rn=10&p=channel&from=1";
//		System.out.println(URLEncoder.encode("美女"));
		System.out.println(URLDecoder.decode(str));         //解码
		URLConnection conn=new URL(str1).openConnection();
		InputStream is=conn.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		StringBuffer buffer=new StringBuffer();
		String line=null;
		while(null!=(line=br.readLine())){
			buffer.append(line);
		}
		br.close();
		isr.close();
		is.close();
		System.out.println(buffer);
		JSONObject jsonObject = new JSONObject(buffer.toString());
		String object=jsonObject.getString("col");
		 System.out.println(object);
		 JSONArray jsonarray=jsonObject.getJSONArray("imgs");
		 System.out.println(jsonarray.length());
		 for(int i=0;i<jsonarray.length()-1;i++)
		 {
		 System.out.println(((JSONObject)jsonarray.get(i)).getString("downloadUrl"));
		 }
	}
}
