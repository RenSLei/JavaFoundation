package priv.rsl.map;
 /*
Map集合：该集合存储健值对。一对一对往里面存。而且要保证键的唯一性。

1，添加
	put(K key , V value)将指定的值与此映射中的指定键关联（可选操作）。

2,删除
	clear()从此映射中移除所有映射关系（可选操作）。
	remove(Object key) 如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。

3，判断
	containsKey(Object key)如果此映射包含指定键的映射关系，则返回 true。
	containsValue(Object value)如果此映射将一个或多个键映射到指定值，则返回 true。
	isEmpty()如果此映射未包含键-值映射关系，则返回 true。

4，获取。
	get(Object key) 返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
	size() 返回此映射中的键-值映射关系数。
	values() 返回此映射中包含的值的 Collection 视图。

--------
重点内容：
	entrySet() 
          返回此映射中包含的映射关系的 Set 视图。
	keySet() 
          返回此映射中包含的键的 Set 视图。

Map
	|--Hashtable：底层是哈希表数据结构，不可以存入null键null值。该集合是线程同步的。JDK1.0效率低
	|--HashMap：底层是哈希表数据结构，允许使用null值和null键，该集合是不同步的。JDK1.2效率高
	|--TreeMap:底层是二叉树数据结构。线程不同步。可以用于给Map集合中的键进行排序。

和Set很像
其实，Set底层就是使用了Map集合。


*/



import java.util.*;
class  MapDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		Map<String,String> map = new HashMap<String,String>();

		//添加元素
		map.put("01","zhangsan1");
		sop(map.put("01","wangwu"));//如果出现添加相同的键，后添加的值会覆盖原有键对应的值，并会返回原有被替换的值（关键的一点，注意）
		map.put("02","zhangsan2");
		map.put("03","zhangsan3");

		sop("containsKey:"+map.containsKey("022"));//判断	
		//sop("remove:"+map.remove("02"));//删除
		

		sop("get:"+map.get("03"));

		//HashMap是可以用null当键或值存在的
		map.put("04",null);
		sop(map.get("04"));
		
		//获取map集合中所有的值
		Collection<String> coll = map.values();
		sop(coll);
		sop(map);//打印map



	
	}
}
/*
zhangsan1
containsKey:false
get:zhangsan3
null
[wangwu, zhangsan2, zhangsan3, null]
{01=wangwu, 02=zhangsan2, 03=zhangsan3, 04=null}

*/
