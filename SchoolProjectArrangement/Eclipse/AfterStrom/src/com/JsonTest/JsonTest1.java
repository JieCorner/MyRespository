package com.JsonTest;

import org.json.JSONObject;

public class JsonTest1
{
	public static void main(String[] args)
	{
		String jsonContent="{'hello':'world','abc':'xyz'}";
		JSONObject jsonObject=new JSONObject(jsonContent);
		String str=jsonObject.getString("hello");
		System.out.println(str);
	}
}
