package priv.rsl.treeSet_generic;
import java.util.*;
/*
|--Set:Ԫ�������򣨴����ȡ����˳��һ��һ�£���Ԫ�ز������ظ���
	|--HashSet:�ײ����ݽṹ�ǹ�ϣ���̷߳�ͬ���ġ�
			�ж�Ԫ�ص�HashCodeֵ�Ƿ���ͬ������ͬ���Ż��ж�equals�Ƿ�Ϊtrue
			���Ԫ�ص�HashCodeֵ��ͬ���������equals.

	|--TreeSet:���Զ�Set�����е�Ԫ�ؽ���������Ȼ˳��.

*/



class TreeSetDemo 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		
		ts.add("cba");
		ts.add("aaa");
		ts.add("bca");
		ts.add("abcd");

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			sop(it.next());
		}

	}
}
/*
���н����
aaa
abcd
bca
cba
-------------------------
���Կ���������Ĵ洢�ļ���
*/
