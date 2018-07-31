package priv.rsl.collections;
/*
���Ͽ�ܵĹ����ࡣ
Collections:
����Collections���Ͽ�ܹ��������reverseOrder()��

public static <T> Comparator<T> reverseOrder()
����һ���Ƚ�������ǿ����תʵ���� Comparable �ӿڵĶ��� collection ����Ȼ˳�򡣣���Ȼ˳����ͨ����������� compareTo ����ǿ������ġ���
�˷�������ʹ�õ�����䣬������Ȼ˳���ʵ���� Comparable �ӿڵĶ��� collection�������飩�������򣨻�ά������
���磬���� a ��һ���ַ������顣��ô��
Arrays.sort(a, Collections.reverseOrder());
���������ֵ䣨��ĸ��˳��������������

���أ���ָ���ıȽ�����ת����
public static <T> Comparator<T> reverseOrder(Comparator<T>?cmp)
����һ���Ƚ�������ǿ����תָ���Ƚ�����˳�����ָ���Ƚ���Ϊ null����˷�����ͬ�� reverseOrder()�����仰˵��������һ���Ƚ������ñȽ�����ǿ����תʵ���� Comparable �ӿڵĶ��� collection ����Ȼ˳�򣩡� 



*/



import java.util.*;
class  CollectionsDemo
{
	public static void main(String[] args) 
	{
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator2()));/*Collections.reverseOrder()*/
		ts.add("abcd");
		ts.add("aaa");
		ts.add("z");
		ts.add("kk");

		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			sop(it.next());
		}
	
		


		
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);

	}
}

	//��ʵ����ʵ�ַ���Ҳ�Ե��鷳����ΪCollections�����������Ӧ�ķ�������reveseOrder()
	class StrLenComparator1 implements Comparator<String>
	{
		public  int compare(String s1,String s2)
		{
			return s2.compareTo(s1);
		}
	}

	class StrLenComparator2 implements Comparator<String>
	{
		public  int compare(String s1,String s2)
		{
			if(s1.length()>s2.length())
				return 1;
			if(s1.length()<s2.length())
				return -1;
			return s1.compareTo(s2);
		}
	}

/*
ʹ���ڼ����д��ݲ���Collections.reverseOrder()�Ľ������������Ȼ˳����ת��ģ���
z
kk
abcd
aaa

ʹ�����صķ������ݺ�Ľ�����������Լ�ָ���ıȽ��������򣩣�

abcd
aaa
kk
z


*/

