package com.baidupicture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test2
{
	public static String SendGET(String col, String tag)
	{
		String result = "";
		BufferedReader read = null;
		try
		{
			String url = col + "?" + tag;
			System.out.println(url);
			URL realurl = new URL(url);
			URLConnection connection = realurl.openConnection();
			connection.connect();
			read = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = read.readLine()) != null)
			{
				result += line;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (read != null)
			{
				try
				{
					read.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args)
	{
		JSONObject jsonObject = new JSONObject(
				Test2.SendGET(
						"http://image.baidu.com/data/imgs",
						"col=%E7%BE%8E%E5%A5%B3&tag=%E5%B0%8F%E6%B8%85%E6%96%B0&sort=0&pn=10&rn=10&p=channel&from=1"));
		 String object=jsonObject.getString("col");
		 System.out.println(object);
		 JSONArray jsonarray=jsonObject.getJSONArray("imgs");
		 System.out.println(jsonarray.length());
		 for(int i=0;i<jsonarray.length()-1;i++)
		 {
		 System.out.println(((JSONObject)jsonarray.get(i)).getString("downloadUrl"));
		 }
		 System.out.println(URLEncoder.encode("美女"));
	}
}
