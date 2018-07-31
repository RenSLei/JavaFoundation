package priv.rsl.other_object;
/*
讲解Calendar里的：
1，设置时间set()
2，add方法

*/

import java.util.*;
class  CalendarDemo2
{
	public static void main(String[] args) 
	{
		Calendar c = Calendar.getInstance();

		//设置时间：
		//c.set(2016,3,21);//结果2016年4月21日星期4

		//为给定的日历字段添加或减去指定的时间量
		c.add(Calendar.YEAR,4);//结果：2021年10月19日星期2
		c.add(Calendar.DAY_OF_MONTH,-5);//结果：2021年10月14日星期4

		printCalendar(c);
		

	}

	public static void printCalendar(Calendar c)
	{
		sop(c.get(Calendar.YEAR)+"年");
		sop((c.get(Calendar.MONTH)+1)+"月");//默认的是0对应1月
		sop(c.get(Calendar.DAY_OF_MONTH)+"日");
		sop("星期"+(c.get(Calendar.DAY_OF_WEEK)-1));
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
