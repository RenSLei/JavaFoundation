package priv.rsl.object_oriented1;
/*
this��䣺���ڹ��캯��֮����л�����ã���ֻ����this�����á�
this���ֻ�ܶ����ڹ��캯���ĵ�һ�С�Ϊʲô��
��Ϊ���캯���е�this����Ҳ���ڳ�ʼ������ʼ���ڲ��ĳ�ʼ����Ҫ��ִ��
*/

class Person4
{
	private String name;
	private int age;

	Person4(String name)//���캯��һ
	{
		this.name = name;//this��Ҫ�ǿ��ĸ������ڵ��ø�this���ڵĺ���
	}

	Person4(String name,int age)//���캯����
	{
		//this.name=name;
		this(name);/*�����Ҳ�ǳ�ʼ����
		             ��ʼ����������name�����ú���һ��
					 ˭�ڵ��ã�p�ڵ���*/
		this.age=age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
}
class PersonDemo4 
{
	public static void main(String[] args) 
	{
		Person4 p = new Person4("lisi",30);
		p.setName("ren shilei");
		System.out.println("name is "+p.getName());
		p.setAge(24);
		System.out.println("age is "+p.getAge());
	}
}

