package priv.rsl.treeSet_generic;
import java.util.*;
/*
|--Set:Ԫ�������򣨴����ȡ����˳��һ��һ�£���Ԫ�ز������ظ���
	|--HashSet:�ײ����ݽṹ�ǹ�ϣ���̷߳�ͬ���ġ�
			�ж�Ԫ�ص�HashCodeֵ�Ƿ���ͬ������ͬ���Ż��ж�equals�Ƿ�Ϊtrue
			���Ԫ�ص�HashCodeֵ��ͬ���������equals.

	|--TreeSet:���Զ�Set�����е�Ԫ�ؽ���������Ȼ˳��.

������TreeSet�����д洢�Զ������ѧ��
�밴��ѧ���������������




*/
class TreeSetDemo2 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		
		ts.add(new Student2("lisi02",22));
		ts.add(new Student2("lisi007",20));
		ts.add(new Student2("lisi09",19));
		ts.add(new Student2("lisi01",19));

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			Student2 stu = (Student2)it.next();
			sop(stu.getName()+"...."+stu.getAge());
		}

	}
}

class Student2 implements Comparable//˵��1
{
	private String name;
	private int age;

	Student2(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}

	public int compareTo(Object obj)
	{
		if(!(obj instanceof Student2))
			throw new RuntimeException("����ѧ������");
		Student2 s= (Student2)obj;

		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
		{
			return this.name.compareTo(s.name);//˵��2 
		}
		return -1;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
}



/*
˵��1��
�ýӿ�ǿ����ѧ���߱��Ƚ���
�����ԭ��ΪʲôҪ��ѧ����߱��Ƚ��ԣ�
��ΪTreeSet���ϵ��ص���ǶԴ洢���������Ԫ�ؽ�����Ȼ�������ݵ��ǣ�
�����ڴ洢����ѧ���࣬���߱��ɱ���
���Ա��뽫��ʵ��Comparable�ӿڣ����˽ӿڵķ�����ֻ��һ����compareTo
int compareTo(T o)
�Ƚϴ˶�����ָ�������˳������ö���С�ڡ����ڻ����ָ��������ֱ𷵻ظ������������������
����д����compare To�ž߱��ɱ���


˵��2��
String������Ҳ��compareTo��������ʵ������ʵ�ֵĽӿ�comparable
��ס������ʱ������Ҫ������ͬʱ��һ���ж�һ�´�Ҫ������


���н����
lisi01....19
lisi09....19
lisi007....20
lisi02....22

*/
