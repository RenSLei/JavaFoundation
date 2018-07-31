package priv.rsl.treeSet_generic;
/*
���Ͷ����ڷ�����:
Ϊʲô��Ҫ�����ڷ����ϣ�
��Ϊ
�����´�����ʾ��

class Demo<T>
{
	public void show(T t)
	{
		System.out.println("show"+t);
	}

	public void print(T t)
	{
		System.out.println("print"+t);
	}

}

class GenericDemo4
{
	public static void main(String[] args) 
	{
		Demo<String> d = new Demo<String>();

		d.show(new Integer(4));
		d.print("haha");
	}
}

����Ǳ���ʧ�ܣ���Ϊ�����Ƕ��������ϵģ�����ķ��������Ĳ����������Ͳ�ͬʱ�ͻ����
��Ҳ�Ƿ�����ľ����ԡ�


*/

//�����ǵ������ǶԲ�ͬ�ķ����������⴫��ͬ�Ĳ���:
class Demo//��ʱ�Ͳ�Ҫʹ�÷�����
{
	//�����Ͷ����ڷ����ϣ���֮Ϊ��������
	//��ʽ�Ƿ��ڷ���ֵ���͵�ǰ�棬λ�ù̶������ҷ�
	public <T> void show(T t)
	{
		System.out.println("show��"+t);
	}

	public <T> void print(T t)
	{
		System.out.println("print��"+t);
	}

	/*ע�⣬��̬���������Է������϶���ķ���(��Ϊ��̬�����ȼ���)
	�����̬�����������������Ͳ�ȷ�������Խ����Ͷ����ڷ�����*/
	public static <W> void method(W t)
	{
		System.out.println("method��"+t);
	}


}

class GenericDemo4
{
	public static void main(String[] args) 
	{
		//�ô����Զ��׼��ġ���ʲô�ͻ���ʲô���͡�
		Demo d = new Demo();

		d.show(new Integer(4));
		d.print("haha");

		Demo.method("��̬��������01");
		Demo.method(2);

	}
}

/*
�����
show��4
print��haha
method����̬��������01
method��2


����˵��һ�㣬����Demo��Ϊ
class Demo <T>
{
	//�����Ͷ����ڷ����ϣ���֮Ϊ��������
	public void show(T t)
	{
		System.out.println("show��"+t);
	}

	public <Q> void print(Q q)
	{
		System.out.println("print��"+t);
	}

}

�������֣�show����û�з��ͣ�print�����з��ͣ��������з���
���ʱ���ͷ���show�Ǹ��ŷ�����Demo�ߵģ������ͷ���print����Ӱ��


*/
