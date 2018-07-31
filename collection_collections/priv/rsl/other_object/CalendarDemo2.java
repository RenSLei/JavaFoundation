package priv.rsl.other_object;
/*
����Calendar��ģ�
1������ʱ��set()
2��add����

*/

import java.util.*;
class  CalendarDemo2
{
	public static void main(String[] args) 
	{
		Calendar c = Calendar.getInstance();

		//����ʱ�䣺
		//c.set(2016,3,21);//���2016��4��21������4

		//Ϊ�����������ֶ���ӻ��ȥָ����ʱ����
		c.add(Calendar.YEAR,4);//�����2021��10��19������2
		c.add(Calendar.DAY_OF_MONTH,-5);//�����2021��10��14������4

		printCalendar(c);
		

	}

	public static void printCalendar(Calendar c)
	{
		sop(c.get(Calendar.YEAR)+"��");
		sop((c.get(Calendar.MONTH)+1)+"��");//Ĭ�ϵ���0��Ӧ1��
		sop(c.get(Calendar.DAY_OF_MONTH)+"��");
		sop("����"+(c.get(Calendar.DAY_OF_WEEK)-1));
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
