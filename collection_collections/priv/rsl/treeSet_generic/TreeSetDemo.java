package priv.rsl.treeSet_generic;
import java.util.*;
/*
|--Set:元素是无序（存入和取出的顺序不一定一致），元素不可以重复。
	|--HashSet:底层数据结构是哈希表。线程非同步的。
			判断元素的HashCode值是否相同，若相同，才会判断equals是否为true
			如果元素的HashCode值不同，不会调用equals.

	|--TreeSet:可以对Set集合中的元素进行排序。自然顺序.

*/



class TreeSetDemo 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		
		ts.add("cba");
		ts.add("aaa");
		ts.add("bca");
		ts.add("abcd");

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			sop(it.next());
		}

	}
}
/*
运行结果：
aaa
abcd
bca
cba
-------------------------
可以看到是有序的存储的集合
*/
