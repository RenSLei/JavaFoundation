package priv.rsl.treeSet_generic;
//���Ͷ����ڽӿ���
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
		//�ɵ�������ָ����Ҫ����Ĳ������ͷ���
		InterImpl<Integer> i  = new InterImpl<Integer>();
		i.show(4);
	}
}
/*
�����
show:4

*/
