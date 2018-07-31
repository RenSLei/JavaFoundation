package priv.rsl.treeSet_generic;
/*
���ĵ�����˵�����͵�ʹ�÷�Χ��
�������ڼ����У�������ǿת���鷳�ԣ������Ǽ��ϻ��ǵ������Լ��Ƚ�����������Ӧ�÷���
���͵�Ӧ�ã�
ѧϰ���������֪���ڶ������ʱ��
1��Ӧ������߱��Ƚ��ԣ�ʵ��Comparable�ӿڣ�
2��Ӧ�ö���hashCode��equals������HashSet�ı�֤Ψһ�Ե�ԭ��
3��Ӧ�ø�дcompareTo������ʹ�����Լ��ıȽ��ԣ�
4������Ҫ��չ���ܵ�ʱ��ֻ��Ҫ�����µıȽ������ࣩ��ʵ��Comparator
	Ȼ�����������Ϊ�������ݵ����ϵĹ��캯���Ｔ�ɸ����µıȽϷ�����
*/


import java.util.*;
class GenericDemo2 
{
	public static void main(String[] args) 
	{
		//ʹ��TreeSet������ʾ
		TreeSet<String> ts = new TreeSet<String>(new LenComparator());

		ts.add("abcd");
		ts.add("ab");
		ts.add("a");
		ts.add("saf");
		ts.add("fesg");
		ts.add("grasgasrg");

		//��������
		Iterator<String> it = ts.iterator();

		while (it.hasNext())
		{
			String s = it.next();
			System.out.println(s);
		}
		
	}

}

//���ڵ������ǲ���Ҫ�����Զ�����ַ����ȽϹ��ܣ��밴�ճ�������
class LenComparator implements Comparator<String>//˵��1
{
	public int compare(String s1,String s2)
	{
		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if (num==0)
			return s1.compareTo(s2);
		return num;

	}
} 
/*
˵��1��
���͵��ص����ڱ���ǿ�ƻ����鷳���˴�����һ��Ӧ�á�
ֱ�Ӹ��߽ӿڽ��ܵ���String���͵Ķ���
���ǣ���equals�����Ͳ����÷��ͣ�����ת������Ϊ����û�з���
���н����
a
ab
saf
abcd
fesg
grasgasrg




*/











