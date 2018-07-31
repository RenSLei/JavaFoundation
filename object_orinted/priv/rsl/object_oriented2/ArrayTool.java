package priv.rsl.object_oriented2;
/*
将ArrayTool.class文件发给其他人，其他人只要将该文件设置到classpath路径下，
就可以使用该工具类了，但是该工具类中定义了多少方法，对方并不知道。因为该类没有
使用说明书。
开始制作程序的说明书。java的说明书通过文档注释来完成。
*/
/**
这是一个可以对数组进行操作的工具类，该类中提供了，获取最值，排序等功能。
@author Ren shilei
@version V1.1
*/
public class ArrayTool //类的权限要足够大才可以生成说明文档，使用public扩大权限
{
	/**
	空参数函数构造函数
	*/
	private ArrayTool(){};
	/**
	获取一个整形数组中的最大值
	@param arr 接受一个int类型的数组
	@return 会返回一个该数组中的最大值
	*/
	public static int getMax(int[] arr) //获取最大值方法
	{
		int max = 0;
		for(int x=1;x<arr.length;x++)
		{
			if(arr[x]>arr[max])
				max=x;
		}
		return arr[max];
	} 
	/**
	获取一个整形数组中的最小值
	@param arr 接受一个int类型的数组
	@return 会返回一个该数组中的最小值
	*/
	public static int getMin(int[] arr)//获取最小值方法
	{
		int min = 0;
		for(int x=1;x<arr.length;x++)
		{
			if(arr[x]<arr[min])
				min=x;
		}
		return arr[min];
	}
	/**
	给int数组进行选择排序
	@param arr 接受一个int类型的数组
	*/
	public static void selectSort(int[] arr)//从小到大_选择排序方法
	{
		for (int x=0;x<arr.length-1 ;x++ )
		{
			for (int y=x+1;y<arr.length ;y++ )
			{
				if (arr[x]>arr[y])
				{
					swap(arr,x,y);
				}
			}
		}
	}
	/**
	给int数组进行冒泡排序
	@param arr 接受一个int类型的数组
	*/
	public static void bubbleSort(int[] arr)//从大到小_冒泡排序方法
	{
		for (int x=0;x<arr.length-1 ;x++ )
		{
			for (int y=0;y<arr.length-1-x ;y++ )
			{
				if (arr[y]<arr[y+1])
				{
					swap(arr,y,y+1);
				}
			}
		}
	}
	/**
	给数组中的元素进行位置置换
	@param arr 接受一个int类型的数组
	@param a 要置换的位置
	@param b 要置换的位置
	*/
	private static void swap(int[] arr,int a,int b)//因为此函数只在内部使用，所以private
	{
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	/**
	用于打印数组中的元素，打印形式是：[element1, element2, ...] 
	*/
	public static void printArray(int[] arr)//打印方法
	{
		System.out.print("[");
		for (int x=0;x<arr.length ;x++ )
		{
			if (x!=arr.length-1)
				System.out.print(arr[x]+",");
				else
				System.out.print(arr[x]+"]");
		}

	}

}
/*
一个类中若没有设置构造函数，则有默认构造函数，且修饰符和所属类一致；
即默认构造函数是伴随类的变化而变化的；
注：所谓默认，是系统的默认，是没有手动设置的构造函数。
*/
