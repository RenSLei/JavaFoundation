package priv.rsl.collection_list_set;
import java.util.*;
/*
ö�پ���Vector���е�ȡ����ʽ��
����ö�ٺ͵���������
��ʵö�ٺ͵�����һ���ġ�

��Ϊö�ٵ������Լ����������ƶ�������
���Ա�������ȡ���ˡ�ö�پ���������̭�ˡ�

*/



class VectorDemo  
{
	public static void main(String[] args) 
	{
		Vector v = new Vector();
		
		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");
		
		Enumeration en = v.elements();//elements()��������������ö������

		while (en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
		
	}
}
