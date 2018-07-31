package priv.rsl.object_oriented6;
/*
异常在子父类覆盖中的体现：
1、子类在覆盖父类时，如果父类的方法抛出异常，那么子类的覆盖方法，只能
抛出父类的异常或者该异常的子类。

2、如果父类方法抛出多个异常，那么子类在覆盖该方法时，只能抛出父类异常的子集。

3、如果父类或者接口的方法中没有异常抛出，那么子类在覆盖方法时，也不可以抛出异常。
	如果子类方法发生了异常，就必须在内部进行try处理，绝对不能抛。
*/


//体现1的代码说明：
class AException extends Exception
{

}

class BException extends AException
{

}

class CException extends Exception
{

}
/*
Exception 
	|--AException
		|--BException
	|--CException

*/

class Fu
{
	void show()throws AException
	{

	}
}

class Zi extends Fu
{
	void show()throws BException//或AException,但不能抛CException
	{

	}
}



class ExceptionDemo6
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
