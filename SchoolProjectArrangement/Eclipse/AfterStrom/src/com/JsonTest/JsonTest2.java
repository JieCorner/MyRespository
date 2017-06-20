package com.JsonTest;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonTest2
{
	public static void main(String[] args)
	{
		String jsonContent="[{'hello':333,'abc':false,'xyz':{'a':1,'b':'ab'}}]";
		JSONArray jsonArray=new JSONArray(jsonContent);
		System.out.println(jsonArray.length());
		for(int i=0;i<jsonArray.length();i++)
		{
			JSONObject jsonObject2=jsonArray.getJSONObject(i);
			int value1=jsonObject2.getInt("hello");
			boolean value2=jsonObject2.getBoolean("abc");
			JSONObject jsonObject3=jsonObject2.getJSONObject("xyz");
			int value3=jsonObject3.getInt("a");
			String value4=jsonObject3.getString("b");
			System.out.println(value1);
			System.out.println(value2);
			System.out.println(value3);
			System.out.println(value4);
		}
	}
}
