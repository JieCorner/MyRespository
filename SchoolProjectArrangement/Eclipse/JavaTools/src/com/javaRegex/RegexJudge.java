package com.javaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexJudge
{
	// �ж���ĳ���ַ����в�ѯĳ���ַ�����ĳ�����ִ���regex="a|f" / "ads|fr"��
	static public boolean RegexincludeString(String regex, String str)
	{
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(str);
		if (mat.find())
		{
			return true;
		} else
		{
			return false;
		}
	}

	// ��ĳ���ַ����л�ȡһ���ַ�����regex="[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"��
	static public void RegexgetString(String regex, String str)
	{
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(str);
		while (mat.find())
		{
			String getstr = mat.group();
			System.out.println(getstr);
		}
	}

	// ���ַ����ķָregex=":"�ָ��־��(str="aa:bb:cc")
	static public void RegexshiltString(String regex, String str)
	{
		Pattern pat = Pattern.compile(regex);
		String[] rs = pat.split(str);
		for (int i = 0; i < rs.length; i++)
		{
			System.out.println(rs[i]);
		}
	}

	// �ַ������滻/ɾ����regex="@"ƥ�����еġ�@����(str="@@aa@b@@t")(replaceTo="#"Ϊ""ʱ��ʾɾ��)
	static public void RegexreplaceString(String regex, String str,String replaceTo)
	{
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(str);
		String s1 = mat.replaceAll(replaceTo);
		System.out.println(s1);
//		return s1;
	}
}
