package priv.rsl.string;
/*
获取一个字符串在另一个字符串中出现的次数
思路：
一个计数器、获取子串第一次出现的位置、每一次获取完后从剩下的串中继续获取、直到获取失败为止。
*/

class StringTest2 
{
	public static int getSubCount(String str,String s)
	{
		int i = 1;
		int count = 0;
		int index = 0;
		while((index=str.indexOf(s))!=-1)
		{
			sop("str"+(i++)+"="+str);
			str = str.substring(index+s.length());
			count++;
		}
		return count;
	}
/*
练习方法二：

*/
	public static int getSubCount_2(String str,String s)
	{
		int count = 0;
		int index = 0;
		while((index=str.indexOf(s,index))!=-1)
			{	
				sop("index="+index+"    count="+count);
				index= index+s.length();
			}
		return count;
	}
	public static void main(String[] args) 
	{
		String s = "dakkdsgskkfsgkkfskkasfkafkk";
		sop("法一：");
		sop("count="+getSubCount(s,"kk"));
		sop("法二：");
		sop("count="+getSubCount_2(s,"kk"));
	}
	public static void sop(String str)
	{
		System.out.println(str);
	}
}
/*
运行结果：
法一：
str1=dakkdsgskkfsgkkfskkasfkafkk
str2=dsgskkfsgkkfskkasfkafkk
str3=fsgkkfskkasfkafkk
str4=fskkasfkafkk
str5=asfkafkk
count=5
法二：
index=2    count=0
index=8    count=0
index=13    count=0
index=17    count=0
index=25    count=0
count=0

*/
