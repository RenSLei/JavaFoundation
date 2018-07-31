package priv.rsl.treeSet_generic;


//有一个类
class Worker
{

}

//又一个类
class Student
{
	
}

/*
有一个工具，操作上述两个类，为了提高通用性,
早期还没有泛型的时候，是通过定义Object来完成扩展：
*/
class Tool1
{
	private Object obj;
	public void setObject(Object obj)
	{
		this.obj = obj;
	}

	public Object getObject()
	{
		return obj;
	}
}

/*
出现了泛型后，就让这个类带参数
*/
class Tool2<QQ>//使类带参数，即是属于哪种类型
{
	private QQ q;
	public void setObject(QQ q)
	{
		this.q = q;
	}

	public QQ getObject()
	{
		return q;
	}
}

class GenericDemo3 
{
	public static void main(String[] args) 
	{
		//演示早期使用Object完成扩展出现的问题：
		//Tool1 t = new Tool1();
		//t.setObject(new Student());//本想传入的是Worker对象，结果传入的是Student
		//Worker W = (Worker)t.getObject();//以为是Worker对象所以转成Worker对象
		//运行结果1

		//演示运用泛型后的好处
		Tool2<Worker> t = new Tool2<Worker>();

		t.setObject(new Worker());//若此处传的是new Student(),则编译失败
		Worker w = t.getObject();//不用强转了
		//运行结果2
	}
}
/*
运行结果1：
E:\Step1\day15_集合框架\08-泛型类>javac GenericDemo3.java

E:\Step1\day15_集合框架\08-泛型类>java GenericDemo3
Exception in thread "main" java.lang.ClassCastException: Student cannot be cast to Worker
        at GenericDemo3.main(GenericDemo3.java:42)

分析：当传入Student类的时候，又将其转换为Worker类，所以编译时不会出错，运行出错，就是问题


运行结果2：
E:\Step1\day15_集合框架\08-泛型类>javac GenericDemo3.java

E:\Step1\day15_集合框架\08-泛型类>java GenericDemo3

分析：不会出现任何问题

分析：什么时候使用泛型？
当类中要操作的引用数据类型不确定的时候
早期定义Object来完成扩展
现在定义泛型来完成扩展



*/
