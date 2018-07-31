package priv.rsl.collections;
/*
集合框架的工具类。
Collections:



*/



import java.util.*;
class  CollectionsDemo2
{
	public static void main(String[] args) 
	{
		maxDemo();	
	}

	public static void maxDemo()
	{
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("z");
		list.add("zz");
		list.add("kkkk");
		list.add("qq");
		
		Collections.sort(list);
		sop(list);

		String max1 = Collections.max(list);//按照自然顺序比较后的最大元素
		sop("max1="+max1);

		Collections.sort(list,new StrLenComparator3());
		sop(list);

		String max2 = Collections.max(list,new StrLenComparator3());//取出使用比较器后最大的元素
		sop("max2="+max2);
		

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);

	}
}
	class StrLenComparator3 implements Comparator<String>
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
max1=zz
[z, qq, zz, aaa, abcd, kkkk]
max2=kkkk
*/
