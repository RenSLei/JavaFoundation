package priv.rsl.string;
/*
StringBuffer是字符串缓冲区
是一个容器
1、长度是可以变化的
2、可以自己操作多个数据类型
3、最终会通过toString方法变成字符串

注意：append方法、insert方法等返回类型是StringBuffer！

1、存储
StringBuffer append():将指定数据作为参数添加到已有数据结尾处。
StringBuffer insert(位置,数据)：可以将数据插入指定位置。

2、删除
	StringBuffer delete(start,end)删除缓冲区中的数据，包含start不包含end
	StringBuffer deleteCharAt(index):删除指定位置的字符。

3、获取
	char charAt(int index) 
	int indexOf(String str) 
	int lastIndexOf(String str) 
	int length() 
	String substring(int start) 

4、修改
	StringBuffer replace(int start, int end, String str)
	void setCharAt(int index, char ch)//注意返回类型是void

5、反转
	StringBuffer reverse()

6、
	将字符串中指定位置的字符串存储到指定字符数组中。
	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)

JDK1.5 版本之后出现了StringBuilder

StringBuffer是线程同步，即适用于多线程，有锁的判断
StringBuilder是线程不同步，即没有锁的判断，适用于单线程，效率高

开发建议使用String Builder

Java升级三个因素：
1，提高效率
2，简化书写
3，提高安全性

*/


class StringBufferDemo 
{
	public static void main(String[] args) 
	{
		method_getChars();
		method_reverse();
		method_update();
		method_del();
		method_add();
		
	}

	public static void method_getChars()
	{
		StringBuffer sb = new StringBuffer("abcdef");
		char[] str = new char[6];
		sb.getChars(1,4,str,1);
		for (int x=0;x<str.length;x++)
		{
			sop("str["+x+"]="+str[x]+';');
		}
	/*结果是
		str[0]= ;
		str[1]=b;
		str[2]=c;
		str[3]=d;
		str[4]= ;
		str[5]= ;
	*/

	}

	public static void method_reverse()
	{
		StringBuffer sb = new StringBuffer("abcdef");
		sb.reverse();
		sop(sb.toString());	
		//结果是fedcba
	}

	public static void method_update()
	{
		StringBuffer sb = new StringBuffer("abcdef");

		sb.replace(1,4,"java");//将1角标到3角标的字符串替换成java
		sb.setCharAt(2,'g');//将2角标字符改为g，返回类型是void
		sop(sb.toString());	
		//结果是ajgvaef
	}

	public static void method_del()
	{
		StringBuffer sb = new StringBuffer("abcdef");

		sb.delete(1,3);// 删除指定位置字符串
		sb.deleteCharAt(2);//删除指定位置字符
		sb.delete(0,sb.length());//清空容器数据
		sop(sb.toString());	
		//结果是容器里没有数据
	}


	public static void method_add()
	{
		StringBuffer sb = new StringBuffer();

		sb.append("abc").append(true).append(34);
		sop(sb.toString());
		/*注意：append方法返回的是类型是StringBuffer，所以是可以继续调用append 方法*/
		//结果是abctrue34
	}


	public static void sop(String str)
	{
		System.out.println(str);
	}

}
