package priv.rsl.object_oriented1;
/*
����ȫ�Ƕ����ڵ��ã�
this:����ȥ��������ֲ������ͳ�Ա����ͬ���������
thisΪʲô���Խ��������⣿
this���״������ʲô��
this������Ķ��󣬵��״�����һ���أ�
this���������ں���������������á�
��˵�������ĸ������ڵ���this���ڵĺ�����this�ʹ����ĸ�����
*/

class Person2
{
	private String name;
	private int age;

	Person2(String name)
	{
		this.name = name;//this��Ҫ�ǿ��ĸ������ڵ��ø�this���ڵĺ���
	}

	Person2(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public void speak()
	{
        System.out.println("name="+this.name+"...age="+this.age);
	}
}
class PersonDemo2 
{
	public static void main(String[] args) 
	{
		Person2 p = new Person2("lisi");
		Person2 p1 = new Person2("zhangsan");
		p.speak();
		p1.speak();
	}
}

