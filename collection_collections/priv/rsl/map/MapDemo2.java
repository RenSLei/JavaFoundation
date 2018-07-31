package priv.rsl.map;
/*
如何将所有的键和值全部取出来？

map集合的两种取出方式：
1，Set<k> KeySet:将map中所有的键存入到Set集合中。因为set具备迭代器。
	可以用迭代的方式取出所有的键，再根据get方法获取每一个键对应的值。
	
	Map集合的取出原理：将map集合转成set集合。在通过迭代器取出。

2，Set<Map.Entry<K,V>> entrySet：将map集合中的映射关系存入到了set集合中，
			而这个关系的数据类型就是：map.Entry（其实是一个接口）

*/
import java.util.*;
class MapDemo2
{
	public static void main(String[] args) 
	{
		Map<String,String>map = new HashMap<String,String>();
		
		map.put("02","zhangsan2");
		map.put("01","zhangsan1");
		map.put("03","zhangsan3");
		map.put("04","zhangsan4");
		//==========使用方法二：使用entrySet();=====
		//将map集合中的映射关系取出，存入到Set集合中。
		Set<Map.Entry<String,String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String,String>> it = entrySet.iterator();

		while(it.hasNext())
		{
			Map.Entry<String,String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}


		/*

		=======使用方法一：用KeySet();=======
		//先获取map集合的所有键的Set集合，用KeySet();
		Set<String> keySet = map.keySet();

		//将键存到了set集合里面，就可以获取其迭代器
		Iterator<String> it = keySet.iterator();

		while(it.hasNext())
		{
			String key = it.next();
			String value = map.get(key);
			System.out.println("key:"+key+",value:"+value);
		}
		*/
	}
}
/*
方法一运行结果：
key:01,value:zhangsan1
key:02,value:zhangsan2
key:03,value:zhangsan3
key:04,value:zhangsan4

方法二运行结果：
01:zhangsan1
02:zhangsan2
03:zhangsan3
04:zhangsan4

*/
