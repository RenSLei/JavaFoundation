package priv.rsl.other_object;
/*
����Calendar�ࣺ����util����
public abstract class Calendar
extends Object
implements Serializable, Cloneable, Comparable<Calendar>
��������Ҫ����Ļ�ȡĳһ���ĳһ����������ƶ���ʱ�䣬�ô��ࡣ

��public static Calendar getInstance()����ȡһ��Calendar

*/

import java.util.*;
import java.text.*;
class  CalendarDemo
{
	public static void main(String[] args) 
	{
		Calendar c = Calendar.getInstance();
		sop(c.get(Calendar.YEAR)+"��");
		sop((c.get(Calendar.MONTH)+1)+"��");//Ĭ�ϵ���0��Ӧ1��
		sop(c.get(Calendar.DAY_OF_MONTH)+"��");
		sop("����"+(c.get(Calendar.DAY_OF_WEEK)-1));
		//�����2017��10��19������4,������鷳�����ò����

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
