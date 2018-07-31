package priv.rsl.collections;
/*
Arrays:用于操作数组的工具类。
里面都是静态方法,如binarySearch,toString,equals,fill,copyOf,copyOf
sort,asList(重点)。

*/


import java.util.*;
class  ArraysDemo
{
	public static void main(String[] args) 
	{
		//int [] arr = {2,4,5};
		//sop(Arrays.toString(arr));//操作数组，变成字符串；


		String [] arr = {"fadc","dd","gg"};

		List<String> list = Arrays.asList(arr);

		//把数组变成list集合有什么好处？
		/*
		可以使用集合的思想和方法来操作数组中的元素。
		
		注意：将数组变成集合，不可以使用集合的增删方法。
		因为数组的长度是固定的
		可以使用如：
		contains
		get
		indexof()
		subList()
		
		如果增删。那么会发生UnsupportedOperationException

		*/
		sop("contains:"+list.contains("dd"));
		//list.add("kkk");//UnsupportedOperationException
		sop(list);

		Integer[] nums = {2,4,5};//int[] nums = {2,4,5};

		List<Integer> li = Arrays.asList(nums);
		
		/*
		如果数组中的元素都是对象，那么变成集合时，数组中的元素就直接转成集合中的元素
		如果数组中的元素都是基本数据类型。那么会将数组作为集合中的元素存在。

		*/
		sop(li);

	}


	



	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}

	
