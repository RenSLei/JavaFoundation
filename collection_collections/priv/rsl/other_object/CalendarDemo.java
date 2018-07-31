package priv.rsl.other_object;
/*
讲解Calendar类：属于util包：
public abstract class Calendar
extends Object
implements Serializable, Cloneable, Comparable<Calendar>
当我们想要具体的获取某一年或某一天或其他的制定的时间，用此类。

用public static Calendar getInstance()来获取一个Calendar

*/

import java.util.*;
import java.text.*;
class  CalendarDemo
{
	public static void main(String[] args) 
	{
		Calendar c = Calendar.getInstance();
		sop(c.get(Calendar.YEAR)+"年");
		sop((c.get(Calendar.MONTH)+1)+"月");//默认的是0对应1月
		sop(c.get(Calendar.DAY_OF_MONTH)+"日");
		sop("星期"+(c.get(Calendar.DAY_OF_WEEK)-1));
		//结果：2017年10月19日星期4,如果嫌麻烦可以用查表法。

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
