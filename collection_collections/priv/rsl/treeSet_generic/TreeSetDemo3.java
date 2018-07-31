package priv.rsl.treeSet_generic;
import java.util.*;
/*
���ļ���Ϊ��˵��TreeSet�ײ�����ݽṹ�Ƕ�������

|--Set:Ԫ�������򣨴����ȡ����˳��һ��һ�£���Ԫ�ز������ظ���
	|--HashSet:�ײ����ݽṹ�ǹ�ϣ���̷߳�ͬ���ġ�
			�ж�Ԫ�ص�HashCodeֵ�Ƿ���ͬ������ͬ���Ż��ж�equals�Ƿ�Ϊtrue
			���Ԫ�ص�HashCodeֵ��ͬ���������equals.

	|--TreeSet:���Զ�Set�����е�Ԫ�ؽ���������Ȼ˳��.
			�ײ����ݽṹ��:  ������---˵��1
			��֤Ԫ��Ψһ�Ե����ݣ�
			compareTo���� return 0 

TreeSet����ĵ�һ�ַ�ʽ��
			��Ԫ������߱��Ƚ��ԡ�Ԫ����Ҫʵ��Comparable�ӿڣ�����compareTo������
			���ַ�ʽҲ��ΪԪ�ص���Ȼ˳�򣬻���Ĭ��˳��
		

������TreeSet�����д洢�Զ������ѧ��
�밴��ѧ���������������




*/
class TreeSetDemo3 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		
		ts.add(new Student3("lisi02",22));
		ts.add(new Student3("lisi007",20));
		ts.add(new Student3("lisi09",19));
		ts.add(new Student3("lisi01",19));
		ts.add(new Student3("lisi03",40));

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			Student3 stu = (Student3)it.next();
			sop(stu.getName()+"...."+stu.getAge());
		}

	}
}

class Student3 implements Comparable//ʵ��Comparable�ӿ�
{
	private String name;
	private int age;

	Student3(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}

	public int compareTo(Object obj)//����CompareTo����
	{
		return 1;//˵��2
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
���������ݽṹ����һ������ṹ��Ĭ�������Ǵ�С��������С�ķ���ߣ���ķ��ұ�
����ʹ������Ͳ������Ч�ʡ�
�籾��(����ԭ�е�compareTo����ȥ����)
�ײ����ݽṹ��                  
                   22
                20   40
       lisi09 19
    lisi01 19

�������ر��ʱ���Ƚϻ������Զ����У�������ÿ����22Ϊ�Ƚϻ�����

˵��2��
�˴�return 1���ǹ��ڶ��������ݽṹ��һ��ʵ�飬
Ŀ�ģ���д�ӿ�Comparable�ӿ��е�compareTo������
ʵ�ֽ����ݰ�ԭ˳�������
ԭ���ǰѺ������Ϊ��ǰ��Ĵ�С����Ȼ�󰴴�С�����˳�������ʱ�����ԭ����


���н����
lisi02....22
lisi007....20
lisi09....19
lisi01....19
lisi03....40

*/
