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

class Person3
{
	private String name;
	private int age;
	Person3(int age)
	{
		this.age=age;
	}

	Person3(String name)
	{
		this.name = name;//this��Ҫ�ǿ��ĸ������ڵ��ø�this���ڵĺ���
	}

	Person3(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public void speak()
	{
        System.out.println("name="+this.name+"...age="+this.age);
	}
	//���󣺸��˶���һ�����ڱȽ������Ƿ���ͬ�Ĺ��ܡ�
	public boolean compare(Person3 p)/*ע������б��˺���ʵ��һ�����У���Ҫ��������õģ�
	                                  ��˵������Ķ����Ѿ���һ��age�����ֻ�贫����һ������������ɡ�*/
	{
		return this.age==p.age;/*this���ǵ���compare������������p���Ǵ������Ķ���*/
	}
}
class PersonDemo3 
{
	public static void main(String[] args) 
	{
		Person3 p1 = new Person3(20);
		Person3 p2 = new Person3(25);
		boolean b = p1.compare(p2);//��Ҫ�ú����
		System.out.println(b);
		//Person p = new Person("lisi");
		//Person p1 = new Person("zhangsan");
		//p.speak();
		//p1.speak();
	}
}

