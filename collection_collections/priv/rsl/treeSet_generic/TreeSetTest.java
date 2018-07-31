package priv.rsl.treeSet_generic;
/*
练习：按照字符串长度进行排序

思考：字符串本身有没有比较性？有，但是比较的规则是按照字符串的大小顺序来比较的。
我们的需求是按照字符串的长度进行比较，所以得扩展比较功能
此时就可以创建类来实现Comparator接口，复写compare方法即可

*/

import java.util.*;
class  TreeSetTest
{
	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet(new StrLenComp());

		//往TreeSet集合里存放不同长度的字符串
		ts.add("fdddfh");
		ts.add("dsg");
		ts.add("fd");
		ts.add("fsdgg");
		ts.add("s");
		ts.add("gdhhg");

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			System.out.println(it.next());
		}	
	}
}

//创建类来实现接口功能
class StrLenComp implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		String s1 = (String)o1;
		String s2 = (String)o2;

		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		
		if(num==0)//关键，判断次要条件
			return s1.compareTo(s2);//此时就直接用比较自然顺序的方法即可。
		return num;
	}
}

/*
运行结果：
s
fd
dsg
fsdgg
gdhhg
fdddfh

*/
