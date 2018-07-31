package priv.rsl.map;
/*
练习：
"sfsdhkghkdfjgldaj"获取字符串中的字母出现的次数。

希望打印的结果是：a(1)b(3)c(次数)...

通过结果发现，每一个字母都有对应的次数。
说明字母和次数之间都有映射关系。

注意：当发现有映射关系时，可以选择map集合。
因为Map集合中存放的就是映射关系。

什么时候使用map集合呢？
当数据之间存在着映射关系时，就要先想到map集合。

思路：
1，将字符串转换成字符数组。因为要对每一个字母进行操作。
2，定义一个map集合，因为打印结果的字母有顺序，所以使用treemap集合。

3，遍历字符数组：
	将每一个字母作为键去查map集合
	如果返回null,将该字母和1存入到map集合中
	如果不是返回null，说明该字母在map集合中已经存在并有对应的次数
	那么就获取该次数并进行自增。然后将该字母和自增后的次数存入到map集合中
	覆盖调用原键对应的值
4，将map集合中的数据变成指定的字符串形式返回。
*/

import java.util.*;
class  MapTest3
{
	public static void main(String[] args) 
	{
		String str = charCount("ab,=fgsg+++=-abfdsjkfahaibdsb");
		System.out.println(str);
	}

	public static String charCount(String str)
	{
		char[] chs = str.toCharArray();

		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();

		int count = 0;
		for(int x=0;x<chs.length;x++)
		{
			//当不是字母时就让循环继续执行
			if(!(chs[x]>='a'&&chs[x]<='z'||chs[x]>='A'&&chs[x]<='Z'))
				continue;
			Integer vaule = tm.get(chs[x]);
			
			if(vaule!=null)
				count = vaule;
				count++;
				tm.put(chs[x],count);
				count = 0;
			
		}

//如何让该集合取出的元素是按照规定的形式打印的呢？下面演示：

		StringBuilder sb = new StringBuilder();//用缓冲器StringBuilder来存需要存取的字符

		//Map集合是成对存入的，所以要把键和值一起取出来：keySet和entrySetz两种方式
		Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();

		while(it.hasNext())
		{
			Map.Entry<Character,Integer> me = it.next();
			Character chr = me.getKey();
			Integer value = me.getValue();
			sb.append(chr+"("+value+")");
		}

		//System.out.println(tm);
		return sb.toString();//此函数是String类型的
	}

	
}
