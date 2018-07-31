package priv.rsl.map;

/*
Map��ϰ�� 
��ƪ��ϰʹ��Map���ϣ�����ֵ�ɶԵĴ��뷽ʽ������ѧ����Ϊ��������ַ��Ϊֵ���롣Ȼ��ʹ������ȡ��Map����Ԫ�صķ�����keySet��entrySet
1,����ѧ������ࣨ---˵��1---����
2������map��������ѧ����Ϊ������ַ��Ϊֵ���롣//����Ҫ�ظ���ֵ�����ظ������Ҫ��֤Ψһ�Ը�дHashCode������equals
3����ȡmap�����е�Ԫ�ء�


*/
import java.util.*;
class Student2 implements Comparable<Student>/*��������߱�һ���ɱ��ԣ���ֹ������ڶ�������*/
{
	private String name;
	private int age;
	Student2(String name,int age)
	{
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student2 s)
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}

	public int hashCode()
	{
		return name.hashCode()+age*34;
	}

	public boolean eauals(Object obj)
	{
		if(!(obj instanceof Student2))
			throw new ClassCastException("���Ͳ�ƥ��");

		Student2 s = (Student2)obj;

		return this.name.equals(s.name) && this.age==s.age;

	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return name+":"+age;
	}

	@Override
	public int compareTo(Student o) {
	    // TODO Auto-generated method stub
	    return 0;
	}
}

/*---��������ϰ�ߣ�������һ�����ʱ��1��Ҫʵ�ֱȽϽӿ�Comparable<����>�ӿڣ���������߱��Ƚ����ԡ�
                                       2��Ҫ��дHashCode()��equals()����*/
class  MapTest
{
	public static void main(String[] args) 
	{
		HashMap<Student2,String> hm = new HashMap<Student2,String>();

		hm.put(new Student2("lisi",21),"beijing");
		hm.put(new Student2("lisi",25),"shanghai");
		hm.put(new Student2("lisi",23),"nanjing");
		hm.put(new Student2("lisi",24),"chengdu");

		//��һ��ȡ����ʽ keySet
		Set<Student2> keySet = hm.keySet();
		Iterator<Student2> it = keySet.iterator();

		while (it.hasNext())
		{
			Student2 stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu.getName()+":"+stu.getAge()+":"+addr);
		}

		//�ڶ���ȡ����ʽ entrySet
		Set<Map.Entry<Student2,String>> entrySet = hm.entrySet();

		Iterator<Map.Entry<Student2,String>> iter = entrySet.iterator();

		while (iter.hasNext())
		{
			Map.Entry<Student2,String> me = iter.next();
			Student2 stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu+":"+addr);
		}

	}
}
