package priv.rsl.string;
/*
String:
public final class Stringextends Objectimplements Serializable, Comparable<String>, CharSequenceString 类代表字符串。
Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。


*/


class StringDemo 
{
	public static void main(String[] args) 
	{
		String s1 = "abc";
		/*
		s1是一个类类型变量，“abc”是一个对象。
		字符串最大的特点：
		一旦被初始化就不可以被改变：意思是常量"abc"在内存中一旦存在就不能被改变，只是看谁去指向他的问题。
		像String s1 = "abc";就是s1指向"abc".

		*/
		String s2 = new String("abc");

		/*
		s1 和s2有什么区别？
		s1在内存中有一个对象，s2在内存中有两个对象
		*/
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));//String 类复写了Object类中equals方法,比较的是字符串的地址。该方法用于判断字符串是否相同。
	}
}
/*
运行结果：
false
true
*/
