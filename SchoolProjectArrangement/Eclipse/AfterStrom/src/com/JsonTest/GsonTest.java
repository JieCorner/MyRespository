package com.JsonTest;

import org.json.JSONObject;

import com.google.gson.Gson;

public class GsonTest
{
	public static void main(String[] args)
	{
		Person person=new Person();
		person.setAge(20);
		person.setName("zhangsan");
		Gson gson=new Gson();
		String json=gson.toJson(person);
		System.out.println(json);
		JSONObject jsonObject=new JSONObject(json);
		String str=jsonObject.getString("name");
		System.out.println(str);
	}
}
