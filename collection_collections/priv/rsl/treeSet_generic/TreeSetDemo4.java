package priv.rsl.treeSet_generic;
import java.util.*;
/*
���ļ���Ϊ��˵��TreeSet����ĵڶ��ַ�ʽ��Comparator��ʽ����

|--Set:Ԫ�������򣨴����ȡ����˳��һ��һ�£���Ԫ�ز������ظ���
	|--HashSet:�ײ����ݽṹ�ǹ�ϣ���̷߳�ͬ��
	|--TreeSet:
			���Զ�Set�����е�Ԫ�ؽ���������Ȼ˳��.
			�ײ����ݽṹ��:  ������---˵��1
			��֤Ԫ��Ψһ�Ե����ݣ�
			compareTo���� return 0 

TreeSet����ĵ�һ�ַ�ʽ��
			��Ԫ������߱��Ƚ��ԡ�Ԫ����Ҫʵ��Comparable�ӿڣ�����compareTo������

TreeSet����ĵڶ��ַ�ʽ��
			��Ԫ�������߱��Ƚ���ʱ�����߾߱��ıȽ��Բ�������Ҫ�ġ�
			��ʱ�����Ҫ�ü�������߱��Ƚ��ԡ�
			�ڼ��ϳ�ʼ��ʱ��Ҫ��TreeSet���϶���ñȽϷ�ʽ
			��ǡ������ȽϷ�ʽ�����乹�캯����Ĳ�����Comparator�ӿڵ��������
��������һ���࣬ʵ��Comparator�ӿڣ�����compare������



ע�⣺Comparable������compareTo����
��Comparator����compare����
�Ƚ�������һ���á�ֻ��Ҫ����������ȥʵ��Comparator����д�����Ϳɲ����޸����е�compareTo�����ˡ�


�������������Կ�����Comparator��Comparable���ǽӿ�
���ӿ���������չ���ܵģ�����ӵ�д˹��ܵ���ȥʵ���������ˡ�


������TreeSet�����д洢�Զ������ѧ��
�밴��ѧ���������������




*/
class TreeSetDemo4 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		//��ΪTreeSet���в�����comparator������Ĺ��췽�������Ծͽ����ӿ�Comparator������
		TreeSet ts = new TreeSet(new myCompare());
		
		ts.add(new Student4("lisi02",22));
		ts.add(new Student4("lisi007",20));
		ts.add(new Student4("lisi09",19));
		ts.add(new Student4("lisi01",19));
		ts.add(new Student4("lisi01",32));
		ts.add(new Student4("lisi03",40));
		ts.add(new Student4("lisi007",21));

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			Student4 stu = (Student4)it.next();
			sop(stu.getName()+"...."+stu.getAge());
		}

	}
}

class Student4 //implements Comparable//ʵ��Comparable�ӿڣ�ǿ����ѧ���߱��Ƚ��ԡ�
{
	private String name;
	private int age;

	Student4(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}

	/*public int compareTo(Object obj)//����CompareTo
	{
		if(!(obj instanceof Student))
			throw new RuntimeException("����ѧ������");
		Student s= (Student)obj;

		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
		{
			return this.name.compareTo(s.name);
		}
		return -1;
	}*/

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
}


//��ΪTreeSet���в�����comparator������Ĺ��췽�������Ծͽ����ӿ�Comparator������
class myCompare implements Comparator//�Ƚ���
{
	//�����Լ��ıȽϷ���������������
	public int compare(Object o1,Object o2)
	{
		if (!(o1 instanceof Student4 && o2 instanceof Student4))
			throw new RuntimeException("����ѧ������");

			Student4 stu1 = (Student4)o1;
			Student4 stu2 = (Student4)o2;

			int num = stu1.getName().compareTo(stu2.getName());

			if (num==0)
			{
				return new Integer(stu1.getAge()).compareTo(new Integer(stu2.getAge()));
				
			}

			return num;
	}
}



/*


���н����
lisi007....20
lisi007....21
lisi01....19
lisi01....32
lisi02....22
lisi03....40
lisi09....19

*/
