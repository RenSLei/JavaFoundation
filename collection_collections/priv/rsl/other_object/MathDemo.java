package priv.rsl.other_object;
/*
java.lang.Math�ࣺ
Math ���������ִ�л�����ѧ����ķ����������ָ����������ƽ���������Ǻ�����

�ص����ռ�����������

*/

import java.util.*;
class MathDemo
{
	public static void main(String[] args) 
	{
		show();
		//�ص����գ�Random(),���������
		//��һ��������Math�����Random�����������10��1~10���������
		for(int x= 0;x<10;x++)
		{
			int ron1 = (int)(Math.random()*10+1);//randomĬ�ϲ���0~1����0����1��֮��double��
			sop(ron1);
		}

		//������������util���е�Ranoml���������Ч�����ã�
		Random r = new Random();
		//��һ��������Math�����Random�����������10��1~10���������
		for(int x= 0;x<10;x++)
		{
			int ron2 = r.nextInt(10)+1;//����
			sop(ron2);
		}


	}

	public static void show()
	{
		//һ����Ҫ���յķ���
		double d1 = Math.ceil(15.46);//ceil���ش���ָ��������С����16.0
		double d2 = Math.floor(15.46);//floor����С��ָ�������������15.0
		double d3 = Math.pow(2,3);//pow����2��3�η�8.0
		long l = Math.round(15.46);//��������15
		sop("d1="+d1);
		sop("d2="+d2);
		sop("d3="+d3);
		sop("l="+l);
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
