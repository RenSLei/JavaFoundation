package priv.rsl.collection_list_set;
import java.util.*;
/*
ȥ����������ظ�Ԫ��

*/

class ArrayListTest 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();

		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java03");

		//����һ��Сϸ��
		/*
		�ڵ���ʱѭ����next����һ�Σ���ҪhasNext�ж�һ��
		
		Iterator it = al.iterator();

		while(it.hasNext())
		{
			sop(it.next()+"...."+it.next());
		}
		ע�⣬��al�е�Ԫ��ʱ����ʱ���ͻ��ų��쳣��

		*/
		sop("ԭ���ϣ�"+al);
		sop("ȥ�ظ���ļ��ϣ�"+singleElement(al));
	}

	public static ArrayList singleElement(ArrayList al)
	{
		//����һ����ʱ����,��������޸ĺ�����ݣ�������
		ArrayList newAl = new ArrayList();
		
		//Ϊ�˱�����������������Ԫ�أ�ʹ�õ�����Iterator
		Iterator it = al.iterator();

		//ʹ��hasNext()��nest������contatins����
		while (it.hasNext())
		{
			Object obj = it.next();

			if(!newAl.contains(obj))
				newAl.add(obj);
		}
		return newAl;
	}
}
/*
���н����
ԭ���ϣ�[java01, java02, java01, java02, java01, java03]
ȥ�ظ���ļ��ϣ�[java01, java02, java03]
*/
