package priv.rsl.collections;
/*
学习集合变数组
使用Collection接口中的toArray方法。
*/


import java.util.*;
class CollectionToArrayDemo 
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		/*
		
		1,指定类型的数组到底要定义多长呢？
		当指定类型的数组长度小于集合的size，那么该方法内部会创建一个新的数组。长度为集合的size
		当指定类型的数组长度大于集合的size，那么就不会创建一个新的数组。而是使用传递进来的数组
		所以创建一个刚刚好的数组最优。

		2，为什么要讲集合变为数组？
		为了限定对元素的操作，不需要增删操作。
		
		*/
		String [] arr = al.toArray(new String[al.size()]);
		sop(Arrays.toString(arr));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
