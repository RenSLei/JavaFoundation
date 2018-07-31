package priv.rsl.map;

/*
����1����ѧ����������������ѧ����
�����.java�ļ����ں�Student���һ���ļ����£��Ϳ����õ����Student.class�ļ��ˡ�
Ϊʲô����������������ǰ�ѧ���������򣿾�����Ϊѧ��������߱��Ƚ��ԣ�����������������

����������һ�����ʱ��Ҫ���ǵ����Ķ����Ǵ����ʲô���͵ļ���:
����hash���о�Ҫ��дhashCode�Լ�equals�������浽�������о�Ҫʵ��Comparable�ӿ�,�Է�ֹ�����쳣��


��Ϊ�������Լ�ֵ����ʽ���ڵġ�
����Ҫʹ�ÿ��������Map���ϡ�TreeMap��


����2����ѧ��������������бȽ�����ȡ������
������Studentl������ıȽ����ǰ��������˳��������ģ����Ե����¶���һ���Ƚ�������ʵ��Comparator
Ȼ�󽫸���Ķ��󴫸�TreeMap

*/

import java.util.*;
//���¶���һ���Ƚ�������ʵ��ComparatorȻ�󽫸���Ķ��󴫸�TreeMap

class StuNameComparator implements Comparator<Student2>
{
	public int compare(Student2 s1,Student2 s2)
	{
		int num = s1.getName().compareTo(s2.getName());
		if (num==0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		return num;
	}
}
class  MapTest2
{
	public static void main(String[] args) 
	{
		//�������new StuNameComparator()����TreeMap���ǰ���ԭ����Student����ıȽ������������
		TreeMap<Student2,String> tm = new TreeMap<Student2,String>(new StuNameComparator());

		tm.put(new Student2("lisi2",21),"beijing");
		tm.put(new Student2("blisi",26),"shanghai");
		tm.put(new Student2("lisi",24),"nanjing");
		tm.put(new Student2("alisi",25),"chengdu");

		Set<Map.Entry<Student2,String>> entrySet = tm.entrySet();

		Iterator<Map.Entry<Student2,String>> it = entrySet.iterator();

		while(it.hasNext())
		{
			Map.Entry<Student2,String> me = it.next();
			Student2 stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu+"..."+addr);
		}
	}
}
