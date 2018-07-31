package priv.rsl.object_oriented6;

/*
为了简化类名的书写，使用一个关键字，import
import  导入的是包中的类

假如某包中有很多类，可以逐个导入，也可以用通配符 * 全部导入
但在实际开发中不建议用*因为占内存较大

假如导入的类来自不同包且重名，此时这个类必须加包名。





*/

class  PackageDemo
{
	public static void main(String[] args) 
	{
	    priv.rsl.object_oriented6.DemoA d = new priv.rsl.object_oriented6.DemoA();//注意类名是包名.类名
		d.show();
		//packb.DemoB p = new packb.DemoB();//注意只有其子类才可以访问method;
		//p.method();
	}
}

/*
注意：
	1、编译的时候：
		1)若想把包放在当前目录用：javac -d . 类名(PackageDemo).java
		2）若想把包放在指定目录用：javac -d 指定目录路径 类名(PackageDemo).java
	2、运行：
		java 包名.类名
	3、包的出现使java源文件和运行文件相分离。
*/
