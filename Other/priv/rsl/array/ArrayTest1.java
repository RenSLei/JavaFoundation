package priv.rsl.array;
class ArrayTest1//数组（优化的进制转化代码） 
{
	public static void main(String[] args) 
	{
		System.out.print("6 to bin is ");
		toBin(6);
		System.out.println();
		System.out.print("6 to Ba is ");
		toBa(6);
		System.out.println();
		System.out.print("6 to Hex is ");
		toHex(6);

	}
	/*
	十进制—->二进制
	*/
	public static void toBin(int num)
	{
		trans(num,1,1);
	}
	/*
	十进制-->八进制
	*/
	public static void toBa(int num)
	{
		trans(num,7,3);
	}
	/*
	十进制-->十六进制
	*/
	public static void toHex(int num)
	{
		trans(num,15,4);
	}	
	/*
	定义一个进制转化函数，来转化进制。其中，用一个字符数组来做成进制元素表。
	用一个字符数组来倒着存放进制元素，再打印。
	*/
	public static void trans(int num,int base,int offset)//num:需要转换的数；base:用于与的基数；offset:需要移动的位数；
	{
		char[] chs={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] arr=new char[32];//arr数组用来存放进制元素，最多有32个（如二进制）；
		int pos=arr.length;//pos为位置指向变量；从数组最后开始存放；
		while(num!=0)//当num移动到所有的二进制位都是0时（即num的值为0），不再执行下面循环体；
		{
			int temp = num & base;
			arr[--pos] =chs[temp];
			num=num>>>offset;
		}
		for (int x=pos;x<arr.length ;x++ )
		{
			System.out.print(arr[x]);
		}
	}
}
