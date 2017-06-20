package com.javaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexJudge
{
	// 判断在某个字符串中查询某个字符或者某个子字串（regex="a|f" / "ads|fr"）
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

	// 在某个字符串中获取一段字符串（regex="[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"）
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

	// 对字符串的分割（regex=":"分割标志）(str="aa:bb:cc")
	static public void RegexshiltString(String regex, String str)
	{
		Pattern pat = Pattern.compile(regex);
		String[] rs = pat.split(str);
		for (int i = 0; i < rs.length; i++)
		{
			System.out.println(rs[i]);
		}
	}

	// 字符串的替换/删除（regex="@"匹配所有的”@“）(str="@@aa@b@@t")(replaceTo="#"为""时表示删除)
	static public void RegexreplaceString(String regex, String str,String replaceTo)
	{
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(str);
		String s1 = mat.replaceAll(replaceTo);
		System.out.println(s1);
//		return s1;
	}
}
