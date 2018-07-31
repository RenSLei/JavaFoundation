package priv.rsl.treeSet_generic;
//泛型定义在接口上
interface Inter<T>
{
	void show(T t);
}

class InterImpl <T> implements Inter<T>
{
	public void show(T t)
	{
		System.out.println("show:"+t);
	}
}


class GenericDemo5 
{
	public static void main(String[] args) 
	{
		//由调用者来指定需要传入的参数类型泛型
		InterImpl<Integer> i  = new InterImpl<Integer>();
		i.show(4);
	}
}
/*
结果：
show:4

*/
