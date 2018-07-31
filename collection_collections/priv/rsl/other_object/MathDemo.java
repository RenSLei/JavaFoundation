package priv.rsl.other_object;
/*
java.lang.Math类：
Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。

重点掌握几几个方法：

*/

import java.util.*;
class MathDemo
{
	public static void main(String[] args) 
	{
		show();
		//重点掌握：Random(),产生随机数
		//法一：可以用Math类里的Random方法，如产生10个1~10的随机数：
		for(int x= 0;x<10;x++)
		{
			int ron1 = (int)(Math.random()*10+1);//random默认产生0~1（含0不含1）之间double数
			sop(ron1);
		}

		//法二：可以用util包中的Ranoml类来解决，效果更好：
		Random r = new Random();
		//法一：可以用Math类里的Random方法，如产生10个1~10的随机数：
		for(int x= 0;x<10;x++)
		{
			int ron2 = r.nextInt(10)+1;//更简单
			sop(ron2);
		}


	}

	public static void show()
	{
		//一般需要掌握的方法
		double d1 = Math.ceil(15.46);//ceil返回大于指定数据最小整数16.0
		double d2 = Math.floor(15.46);//floor返回小于指定数据最大整数15.0
		double d3 = Math.pow(2,3);//pow返回2的3次方8.0
		long l = Math.round(15.46);//四舍五入15
		sop("d1="+d1);
		sop("d2="+d2);
		sop("d3="+d3);
		sop("l="+l);
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
