package priv.rsl.collection_list_set;
import java.util.*;
/*
LinkedList底层是链表数据结构。
LinkedList:特有方法：
addFirst();
addLast();

getFirst();
getLast();
获得元素，但是不删除元素。
如果集合中没有元素会出现NoSuchElementException异常

removeFirst();
removeLast();
获得元素，但是删除元素。
如果集合中没有元素会出现NoSuchElementException异常


在JDK1.6出现了替代方法。

offerFirst();
offerLast();

peekFirst();
peekLast();
获得元素，但是不删除元素。如果集合中没有元素,会返回null.

pollFirst();
pollLast();
获得元素，但是删除元素。如果集合中没有元素,会返回null.

*/


class LinkedListDemo 
{
	public static void main(String[] args) 
	{
		LinkedList link = new LinkedList();

		link.add("java01");
		link.addFirst("java02");
		link.addLast("java03");
		link.add("java04");

		sop("演示addFirst和addLast方法："+link);//思考打印结果

		sop("get首元素："+link.getFirst()+"\nget后长度："+link.size());
		sop("remove末元素："+link.removeLast()+"\nremove后长度："+link.size());

		while(!link.isEmpty())
		{
			sop(link.removeFirst());//取完后link为空
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*
运行结果：
演示addFirst和addLast方法：[java02, java01, java03, java04]
get首元素：java02
get后长度：4
remove末元素：java04
remove后长度：3
java02
java01
java03
*/
