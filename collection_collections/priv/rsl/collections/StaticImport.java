package priv.rsl.collections;
/*
StaticImport ��̬���룺

��������ʱ����Ҫָ������İ���
����������ʱ��ָ���߱������Ķ��������



*/

import java.util.*;
import static java.util.Arrays.*;//�������Arrays������е����о�̬��Ա��

import static java.lang.System.*;
//Collections��Ҳȫ�Ǿ�̬������Ҳ���Ե��롣

class  StaticImport 
{
	public static void main(String[] args) 
	{
		out.println("Hello World!");

		int [] arr = {3,5,2};

		sort(arr);//����Ӧ����Arrays.sort(arr);
		out.println(Arrays.toString(arr));//ע��˴���Arrars����ʡ�ԣ���ΪͬObject���toString����ͬ��
	}
}
