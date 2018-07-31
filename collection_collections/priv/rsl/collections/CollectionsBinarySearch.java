package priv.rsl.collections;
/*
集合框架的工具类。
Collections:
讲解binarySearch：
折半查找，条件是对排序的集合必须是有序的，如List


*/



import java.util.*;
class  CollectionsBinarySearch
{
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("z");
		list.add("zz");
		list.add("kkkk");
		list.add("qq");
		
		Collections.sort(list);//按照自然顺序排列集合List
		sop(list);

		int index = Collections.binarySearch(list,"kkkk");//使用Collections里的方法binarySearch查找角标
	
		sop("index="+index);

		Collections.sort(list,new StrLenComparator());//按照自定义的顺序排列集合List

		sop(list);

		int index2 = Collections.binarySearch(list,"kkkk",new StrLenComparator());//让"kkk"在自定义的顺序中查找，注意要添加比较器对象进来

		sop("index2="+index2);

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);

	}
}
	class StrLenComparator implements Comparator<String>
	{
		public  int compare(String s1,String s2)
		{
			if(s1.length()>s2.length())
				return 1;
			if(s1.length()<s2.length())
				return -1;
			return s1.compareTo(s2);
		}
	}

/*
结果：

[aaa, abcd, kkkk, qq, z, zz]
index=2
[z, qq, zz, aaa, abcd, kkkk]
index2=5


*/
