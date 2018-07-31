package priv.rsl.string;
/*
JDK 1.5版本出现的新特性

方法的可变参数
在使用时候注意：可变参数一定要定义在参数列表最后面

*/




class  ParamMethodDemo
{
	public static void main(String[] args) 
	{
		
		//当要传递的数据参数个数不确定时，假如函数写成：public static void show(int[] arr)
		//则每次都要定义一个数组。作为实际的参数。
		/*
		int [] arr ={1,2};
		show(arr);

		int [] arr1 ={1,2,4,5,6};
		show(arr1);
		*/
		/*
		下面讲解可变参数：
		其实就是上一种数组参数的简写形式
		不用每次都手动的建立数组对象
		只要将要操作的元素作为参数传递即可
		隐式将这些参数封装成了数组

		
		*/
		//show(1,2);
		show("haha",2,4,65,7);//这样就简化多了
	}

	public static void show(String s, int... arr)
	{
		System.out.println(arr[0]+s);
	}
}
