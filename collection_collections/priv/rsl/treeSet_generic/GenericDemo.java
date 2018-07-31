package priv.rsl.treeSet_generic;
import java.util.*;

/*
泛型：JDK1.5版本以后出现新特性。用于解决安全问题，是一个安全机制。

好处：
1.将运行时期出现问题ClassCastException,转移到了编译时期。
	方便程序员解决问题。让运行时期问题减少，安全。
2.避免了强制转换的麻烦。

泛型格式：
通过<>来定义要操作的引用数据类型

在使用java提供的对象时，什么时候写泛型呢？
通常在集合框架中很常见，只要见到<>就要定义泛型。

其实<>就说用来接收类型的
当使用集合时，将集合中要存储的数据类型作为参数传递到<>中即可。
*/





class GenericDemo 
{
	public static void main(String[] args) 
	{
		//若不加<String>这个泛型，则程序在编译时期通过，而在运行时期出现异常，用户无法处理
		ArrayList<String>al = new ArrayList<String>();

		al.add("abc01");
		al.add("abc0091");
		al.add("abc04");

	//顺便说一点，add方法是只能存对象的，但是1.5版本出现以后，对于基本数据类型有自动装箱功能
	//所以可以直接存4，编译通过。
		//al.add(4);//相当于al.add(new Integer(4));有了泛型后，此语句在编译时期就通不过。

		//使用迭代器,且里面也要明确是什么类型的数据
		Iterator<String> it = al.iterator();

		while (it.hasNext())
		{
			//强转类型，因为想要打印字符串长度就要用length方法，而此方法是String特有
			//String s = (String)it.next();有了泛型就不用再强制转换了。
			String s = it.next();
			System.out.println(s+":"+s.length());

		}

	}
}
/*

abc01:5
abc0091:7
abc04:5

*/
