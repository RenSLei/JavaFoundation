package priv.rsl.string;
/*
获取两个字符串中最大相同子串，第一个动作，将短的那个串进行长度一次递减的子串打印。
"abcwerthelloyuiodef"
"cvhellobnm"
思路：
	1、将短的子串按照长度递减的方法获取到
	2、将每获取到的子串去长串中判断是否包含，若含，已经找到！
*/

class StringTest4 
{
	/*练习四*/
	public static String getMaxSubString(String s1,String s2)
	{
		String max = "",min = "";
		max = (s1.length()>s2.length())?s1:s2;

		min = (max==s1)?s2:s1;

		for (int x = 0;x<min.length() ;x++ )
		{
			for (int y= 0,z=min.length()-x;z!=min.length()+1 ;y++,z++ )
			{
				String temp = min.substring(y,z);
				if(max.contains(temp))
					return temp;
			}
		}
		return " ";
		//如果长串中不包含子串任何内容，则在内循环中没有任何返回值，需要在最后返回一字符串
	}
	public static void main(String[] args) 
	{
		String s1 = "abcwerthelloyuiodef";
		String s2 = "cvhellobnm";
		sop("最长的子串是："+getMaxSubString(s1,s2));
	}
	public static void sop(String str)
	{
		System.out.println(str);
	}
}
/*
运行结果是：
最长的子串是：hello
*/
