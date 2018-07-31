package priv.rsl.collection_list_set;
import java.util.*;
/*
去掉容器里的重复元素

*/

class ArrayListTest 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();

		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java03");

		//补加一个小细节
		/*
		在迭代时循环中next调用一次，就要hasNext判断一次
		
		Iterator it = al.iterator();

		while(it.hasNext())
		{
			sop(it.next()+"...."+it.next());
		}
		注意，当al中的元素时奇数时，就会排除异常。

		*/
		sop("原集合："+al);
		sop("去重复后的集合："+singleElement(al));
	}

	public static ArrayList singleElement(ArrayList al)
	{
		//定义一个临时容器,用来存放修改后的数据，并返回
		ArrayList newAl = new ArrayList();
		
		//为了遍历传进来的容器的元素，使用迭代器Iterator
		Iterator it = al.iterator();

		//使用hasNext()和nest方法、contatins方法
		while (it.hasNext())
		{
			Object obj = it.next();

			if(!newAl.contains(obj))
				newAl.add(obj);
		}
		return newAl;
	}
}
/*
运行结果：
原集合：[java01, java02, java01, java02, java01, java03]
去重复后的集合：[java01, java02, java03]
*/
