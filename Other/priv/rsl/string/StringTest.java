package priv.rsl.string;

class StringTest 
{
	public static void sop(String str)
	{
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		String s = "   abc df   ";
		sop("原字符串：("+s+")");
		String s1 = myTrim(s);
		String s2 = reverseString(s,3,5);//包含头不包含尾
		String s3 = reverseString(s);
		sop("去空格后字符串：("+s1+")");	
		sop("部分反转后字符串：("+s2+")");	
		sop("全部反转后字符串：("+s3+")");	
	}

	//练习一：将字符串两端的空格去除
	public static String myTrim(String s)
	{
		int sta = 0,end = s.length()-1;
		while(sta<=end && s.charAt(sta)==' ')
		sta++;
		while(sta<=end && s.charAt(end)==' ')
		end--;
		return s.substring(sta,end+1);
	}

	//练习二：反转字符串
	public static String reverseString(String s,int x,int y)
	{
		//将字符串转成数组
		char[] str = s.toCharArray();
		//将数组反转
		reverse(str,x,y);
		//将数组转成字符串
		return new String(str);
	}

	public static String reverseString(String s)
	{
		return reverseString(s,0,s.length());
	}

	private static void reverse(char[] arr,int x,int y)
	{
		for(int sta = x,end = y-1;sta<end;sta++,end--)
		{
			swap(arr,sta,end);
		}
	}

	private static void swap(char[] arr ,int x, int y)
	{
		char temp = arr[x];
		arr[x]=arr[y];
		arr[y]= temp;
	}
}

/*
运行结果：

原字符串：(   abc df   )
去空格后字符串：(abc df)
部分反转后字符串：(   bac df   )
全部反转后字符串：(   fd cba   )


*/
