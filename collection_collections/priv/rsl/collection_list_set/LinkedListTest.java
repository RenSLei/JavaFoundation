package priv.rsl.collection_list_set;
/*
使用LinkedList模拟一个堆栈或者队列的数据结构。

堆栈：先进后出  如同一个杯子
队列：先进先出 FIFO  如同一个水管 First in First out


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
		return link.removeFirst();//堆栈的话将Last改为First即可。
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

先进先出的队列：
java01
java02
java03
java04
先进后出的堆栈：
java04
java03
java02
java01

*/
