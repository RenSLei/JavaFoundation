package priv.rsl.collection_list_set;
import java.util.*;
/*
|--Set:元素是无序（存入和取出的顺序不一定一致），元素不可以重复。
	|--HashSet:底层数据结构是哈希表。
	|--TreeSet:
Set集合的功能和Collection是一致的。

*/

class HashSetDemo 
{
	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		HashSet hs =new HashSet();

		hs.add("java01");
		sop(hs.add("java02"));
		sop(hs.add("java02"));
		sop(hs.add("java03"));
		hs.add("java04");
		hs.add("java04");

		//获取元素也只能与Collection一样用迭代器
		Iterator it = hs.iterator();

		while (it.hasNext())
		{
			sop(it.next());
		}
	}
}
/*
运行结果：
true      //第一次addjava02成功
false     //第二次addjava02失败，因为重复
true      //第三次addjava03成功
java04
java03
java02
java01

*/
