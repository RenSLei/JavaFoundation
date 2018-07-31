package priv.rsl.collection_list_set;
/*
ʹ��LinkedListģ��һ����ջ���߶��е����ݽṹ��

��ջ���Ƚ����  ��ͬһ������
���У��Ƚ��ȳ� FIFO  ��ͬһ��ˮ�� First in First out


*/
import java.util.*;
class DuiLie
{
	private LinkedList link;
	DuiLie()
	{
		link = new LinkedList();
	}
	
	public void myAdd(Object obj)
	{
		link.addFirst(obj);	
	}

	public Object myGet()
	{
		return link.removeFirst();//��ջ�Ļ���Last��ΪFirst���ɡ�
	}

	public boolean isNull()
	{
		return link.isEmpty();
	}
}


class LinkedListTest
{
	public static void main(String[] args) 
	{
		DuiLie l = new DuiLie();
		l.myAdd("java01");
		l.myAdd("java02");
		l.myAdd("java03");
		l.myAdd("java04");
		
		while (!l.isNull())
		{
			sop(l.myGet());
		}
		
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*

�Ƚ��ȳ��Ķ��У�
java01
java02
java03
java04
�Ƚ�����Ķ�ջ��
java04
java03
java02
java01

*/
