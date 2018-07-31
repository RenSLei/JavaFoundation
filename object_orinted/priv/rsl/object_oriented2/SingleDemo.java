package priv.rsl.object_oriented2;
/*
设计模式：解决某一问题行之有效的解决办法；
java中有23种设计模式：
单例设计模式：解决一个类在内存中只存在一个对象。
想要保证对象唯一。
1、为了避免其他程序过多建立该类对象。先禁止其他程序建立该类对象。
2、为了让其他程序可以访问该对象，在本类中自定义一个对象。
3、为了方便其他程序对自定义对象访问，可以对外提供一些访问方式。

这三步用代码体现：
1、将构造函数私有化；
2、在类中创建一个本类对象
3、提供一个方法可以获取到该对象

*/

class Single
{
	private int num;//属性一，私有化；

	private String name;//属性二，私有化；

	public void setNum(int num)//设置num的方法
	{
		this.num=num;
	}

	public int getNum()//获取num的方法
	{
		return num;
	}
	public void setName(String name)//设置name的方法
	{
		this.name=name;
	}
	public String getName()//获取name的方法
	{
		return name;
	}

	/*下面是单例设计模式的三串代码*/
	
	/*1、私有化，禁止其他程序建立该类对象*/
	private Single(){}
	
        /*2、在类中创建一个本类对象，静态方法只能调用静态成员，所以s是是静态的，内部成员一般私有化*/
	private static Single s = new Single();
	
	/*3、提供一个方法可以获取到该对象，
	只能通过类名调用（因为程序不可以自己创建该类对象）的方法只能是静态方法*/
	public static Single getInstance()
	{
		return s;
	}


}


class SingleDemo
{
	public static void main(String[] args) 
	{	
	    	/*Single一旦加载，则里面静态随之加载，即建立新的对象s,接着调用getInstance方法，将s赋给ss
		因此ss和s同时指向此对象*/
		Single s1 = Single.getInstance();
		s1.setNum(8);
		System.out.printf("属性num是%-3d；属性name是%s\n",s1.getNum(),s1.getName());
		Single s2 = Single.getInstance();/*新建一个同样指向s的变量s2*/
		s2.setName("ren shilei");
		
		/*注意，s、s1、s2都指向同一个对象，当用s1改变num后，
		 再用s2改变name后，打印此对象的两个属性，都显示*/
		System.out.printf("属性num是%-3d；属性name是%s",s2.getNum(),s2.getName());
//		即操作的是一个对象的属性值，因为单例模式就是只有一个对象，
//		而Single s2 = Single.getInstance();只是新建一个指向对象s的引用变量而已。
		
	}
}
