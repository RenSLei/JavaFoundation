package priv.rsl.collections;
/*
StaticImport 静态导入：

当类重名时，需要指定具体的包名
当方法重名时，指定具备所属的对象或者类



*/

import java.util.*;
import static java.util.Arrays.*;//导入的是Arrays这个类中的所有静态成员。

import static java.lang.System.*;
//Collections里也全是静态方法，也可以导入。

class  StaticImport 
{
	public static void main(String[] args) 
	{
		out.println("Hello World!");

		int [] arr = {3,5,2};

		sort(arr);//本来应该是Arrays.sort(arr);
		out.println(Arrays.toString(arr));//注意此处的Arrars不能省略，因为同Object里的toString方法同名
	}
}
