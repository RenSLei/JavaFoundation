package priv.rsl.treeSet_generic;
/*
��ϰ�������ַ������Ƚ�������

˼�����ַ���������û�бȽ��ԣ��У����ǱȽϵĹ����ǰ����ַ����Ĵ�С˳�����Ƚϵġ�
���ǵ������ǰ����ַ����ĳ��Ƚ��бȽϣ����Ե���չ�ȽϹ���
��ʱ�Ϳ��Դ�������ʵ��Comparator�ӿڣ���дcompare��������

*/

import java.util.*;
class  TreeSetTest
{
	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet(new StrLenComp());

		//��TreeSet�������Ų�ͬ���ȵ��ַ���
		ts.add("fdddfh");
		ts.add("dsg");
		ts.add("fd");
		ts.add("fsdgg");
		ts.add("s");
		ts.add("gdhhg");

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			System.out.println(it.next());
		}	
	}
}

//��������ʵ�ֽӿڹ���
class StrLenComp implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		String s1 = (String)o1;
		String s2 = (String)o2;

		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		
		if(num==0)//�ؼ����жϴ�Ҫ����
			return s1.compareTo(s2);//��ʱ��ֱ���ñȽ���Ȼ˳��ķ������ɡ�
		return num;
	}
}

/*
���н����
s
fd
dsg
fsdgg
gdhhg
fdddfh

*/
