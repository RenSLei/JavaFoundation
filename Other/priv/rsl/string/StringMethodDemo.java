package priv.rsl.string;
/*
String类适用于描述字符串事物。那么它就提供了多个方法对字符串进行操作。

常见的操作有哪些？
"abcd"

1、获取(重要)
	1.1字符串中包含的字符数，即字符串的长度
		int length();获取长度。
	1.2根据位置获取位置上某个字符。
		char charAt(int index);
	1.3根据字符获取该字符在字符串的位置。
		int indexOf(int ch);返回的是ch 在字符串中第一次出现的位置。
		int indexOf(int ch, int fromIndex)返回在此字符串中第一次出现ch的位置，从fromIndex指定的位置开始搜索。

		int indexOf(String str);返回的是str在字符串中第一次出现的位置。
		int indexOf(String str, int fromIndex)返回在此字符串中第一次出现str的位置，从fromIndex指定的位置开始搜索。

		int lastIndexOf(int ch) 返回指定字符在此字符串中最后一次出现处的位置。 
2、判断
	2.1字符串中是否包含某一个子串。
		boolean contains(str): 
		特殊之处：indexOf(str):可以索引str第一次出现的位置，如果返回值为-1，表示该str不在串中。
		所以，用于对指定串判断是否存在也是可以的。
		即if(str.indexOf("abfs")!=-1)即为非空。

		而且该方法既可以判断，又可以获取出现的位置。

	2.2字符串是否有内容。
		boolean isEmpty():判断长度是否为零。
	2.3字符串是否以指定内容开头。
		boolean startsWith(str);
	2.4字符串是否以指定内容结尾。
		boolean endsWith(str);
	2.5判断字符串内容是否相同。复写了Object中的equals方法。
		boolean equals(str);
	2.6判断内容是否相同，并忽略大小写。
		boolean equalsIgnoreCase(str);
3、转换
	3.1将字符数组转成字符串
		构造函数：	String(char[] value)
					String(char[] value, int offset, int count)分配一个新的 String，它包含取自字节数组参数一个子数组的字符。
		静态方法：	static String copyValueOf(char[] value)
					static String copyValueOf(char[] value, int offset, int count)

					static String copyValueOf(char[] value):
				
	3.2将字符串转成字符数组
		char[] toCharArray();

	3.3将字节数组转成字符串
		String(byte[] value)
		String(byte[] value, int offset, int count)分配一个新的 String，它包含取自字符数组参数一个子数组的字符。

	3.4将字符串转成字节数组
		byte[] getBytes();
	3.5将基本数据类型转换成字符串
		static String ValueOf(int):
		static String ValueOf(double):
		
		特殊：字符串和字节数组在转换过程中，是可以指定编码表的。
4、替换
	String replace(oldchar,newchar);
	
5、切割
	String[] split(regex);
6、子串。获取字符串中的一部分。
	String substring(begin);
	String substring(begin,end);
7、转换，去除空格，比较
	7.1将字符串转成大写或者小写
		String toUpperCase()
		String toLowerCase()
	7.2将字符串两端的多个空格去除
		String trim()
	7.3对两个字符串进行自然顺序的比较
		int compareTo(String)
	
		
*/

class StringMethodDemo 
{
	public static void method_7()
	{
		String s = "    Hello Java    ";
		sop("转换成小写："+s.toLowerCase());
		sop("转换成大写："+s.toUpperCase());
		sop("去除空格："+s.trim());//有用,去除两边的字符

		String s1 = "acc";
		String s2 = "aac";
		
		/*按照字典顺序比较，在最小不同的字符索引处
		返回的是此索引位置的对应字符的值的差值
		原串比参数串的字母更靠则返回正数否则为负*/
		sop("比较两个字符串："+s1.compareTo(s2));//返回为正值，2
	}

	public static void method_sub()
	{
		String s = "abcdef";

		sop(s.substring(2));//从指定位置到结尾。如果角标不存在，会出现字符串角标越界异常。
		sop(s.substring(2,4));//包含头，不包含尾。s.substring(0.s.length());
	}

	public static void method_split()
	{
		String s = "zhangsan,lisi,wangwu";

		String[] arr = s.split(",");
		for (int x=0;x<arr.length;x++)
		{
			sop(arr[x]);
		}
	}

	public static void method_replace()
	{
		String s = "hello java";
		String s1 = s.replace('a','n');//如果要替换的字符不存在，返回的还是原串。
		String s2 = s.replace("java","world");

		sop("原字符串s:"+s);
		sop("替换字符后的字符串s1："+s1);
		sop("替换字符串后的字符串s2："+s2);
	}

	public static void method_trans()
	{
		sop("转换方法：");
		char[] arr = {'a','b','c','d','e','f'};
		String s = new String(arr);
		String s1 = new String(arr,2,3);//注意2是代表起始角标，3是个数
	
		sop("将字符数组arr[]转化为字符串s="+s);
		sop("将字符数组arr[]按条件转化为字符串s1="+s1);

		String s2 = "zxcvbnm";
		char[] chs = s2.toCharArray();
		sop("将字符串转化为数组：");
		for(int x=0;x<chs.length;x++)
		{
			
			sop("ch="+chs[x]);
		}




	}

	public static void method_is()
	{
		sop("判断方法：");
		String str = "ArrayDemo.java";
		//判断文件名称是否是Array单词开头。
		
		sop("是Array单词开头?"+str.startsWith("Array"));

		//判断文件名称是否是.java的文件
		sop("是.java的文件?"+str.endsWith(".java"));
	
		//判断文件中是否包含Demo
		sop("包含Demo?"+str.contains("Demo"));

	}

	public static void method_get()
	{
		sop("获取方法：");
		String str = "abcdeakpf";

		//长度
		sop("总长度为："+str.length());//打印9

		//根据索引获取字符
		sop("根据位置获得字符："+str.charAt(4));//当访问到字符串中不存在的角标的时候会发生StringIndexOutOfBoundsException异常

		//根据字符获取索引
		sop("根据字符并从指定位置开始索引字符位置："+str.indexOf('a',3));//如果没有找到，返回的是-1.

		//反向索引一个字符出现的位置
		sop("反向索引一个字符出现的位置:"+str.lastIndexOf("a"));//输出5，即第二个5的角标。只是从尾处开始索引。

		//

	}

	public static void main(String[] args) 
	{
		sop("\n大小写转换、去空格：");
		method_7();
		sop("\n获取子串：");
		method_sub();
		sop("\n切割：");
		method_split();
		sop("\n替换：");
		method_replace();
		sop("\n转换：");
		method_trans();
		sop("\n判断：");
		method_is();
		sop("\n获取:");
		method_get();

		/*
		String s1 = "abc";
		String s2 = new String("abc");
		String s3 = "abc";
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		/*
		打印结果是false和true,分析true的原因：因为在常量池中已经有"abc"这个常量字符串
		所以在String s3 = "abc";的时候，s1、s3都指向"abc".即s1==s3.
		*/
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}

/*
运行结果：
大小写转换、去空格：
转换成小写：    hello java
转换成大写：    HELLO JAVA
去除空格：Hello Java
比较两个字符串：2

获取子串：
cdef
cd

切割：
zhangsan
lisi
wangwu

替换：
原字符串s:hello java
替换字符后的字符串s1：hello jnvn
替换字符串后的字符串s2：hello world

转换：
转换方法：
将字符数组arr[]转化为字符串s=abcdef
将字符数组arr[]按条件转化为字符串s1=cde
将字符串转化为数组：
ch=z
ch=x
ch=c
ch=v
ch=b
ch=n
ch=m

判断：
判断方法：
是Array单词开头?true
是.java的文件?true
包含Demo?true

获取:
获取方法：
总长度为：9
根据位置获得字符：e
根据字符并从指定位置开始索引字符位置：5
反向索引一个字符出现的位置:5

*/
