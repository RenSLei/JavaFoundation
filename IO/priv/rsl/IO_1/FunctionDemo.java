package priv.rsl.IO_1;
/*
装饰设计模式：
当想要对已有的对象进行功能的增强时候，
可以定义新类将已有的对象传入(通常通过构造方法传入)，
基于已有的功能并提供加强功能，自定义的类称为装饰类


*/
//写一个例子来说明：
class Function
{
	//原始的功能只有一个
	public void function()
	{
		System.out.println("OriginalFunction");
	}
	
}

//建立装饰类：
class superFunction
{
	//将需要装饰的对象传进来（构造函数）
	private Function f;
	superFunction(Function f)
	{
		this.f = f;
	}

	public void newfunction()
	{
		f.function();
		System.out.println("newFunction1");
		System.out.println("newFunction2");
	}
}


class FunctionDemo 
{
	public static void main(String[] args) 
	{
		//建立对象
		Function f = new Function();
		
		//原始功能
		//f.function();

		//增强功能：
		superFunction sf = new superFunction(f);
		sf.newfunction();

	}
}
/*
OriginalFunction
newFunction1
newFunction2
*/
