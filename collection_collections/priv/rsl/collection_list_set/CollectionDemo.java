package priv.rsl.collection_list_set;
import java.util.*;
/*
1,add�����Ĳ���������Object���Ա��ڽ����������Ͷ���

2,,�����д洢�Ķ��Ƕ�������ã���ַ��

*/
class CollectionDemo 
{
	public static void main(String[] args) 
	{
		sop("base_method:{");
		base_method();
		sop("}\nmethod_2:{");
		method_2();
		sop("}\nmethod_get:{");
		method_get();
		sop("}");
		
	}

	public static void base_method()
	{
		//����һ������������ʹ��Collection�ӿڵ����࣬ArrayList
		ArrayList al = new ArrayList();

		//1,���Ԫ��
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");

		//��ӡ���ϡ�
		sop("ԭ���ϣ�"+al);

		//2����ȡ���������ϳ��ȡ�
		sop("ԭsize:"+al.size());

		//3,ɾ��Ԫ��
		al.remove("java02");

		//al.clear();//��ռ���
		
		//4,�ж�Ԫ��
		sop("java03�Ƿ���ڣ�"+al.contains("java03"));
		sop("����Ϊ���𣿣�"+al.isEmpty());

		//��ӡ�ı��ļ��ϣ�
		sop("�ı��ļ��ϣ�"+al);	
	}

	public static void method_2()
	{
		ArrayList al1 = new ArrayList();

		al1.add("java01");
		al1.add("java02");
		al1.add("java03");
		al1.add("java04");

		ArrayList al2 = new ArrayList();

		al2.add("java01");
		al2.add("java02");
		al2.add("java05");
		al2.add("java06");
		
		//ȡ������al1��ֻ�ᱣ����al2����ͬ��Ԫ�ء�
		al1.retainAll(al2);

		//ȥ����������ͬ��Ԫ�أ�����ԭ������al1�ļ������Ԫ�أ�
		//al1.removeAll(al2);

		sop("al1:"+al1);
		sop("al2:"+al2);
	}
/*
ʲô�ǵ�������
�Ǽ��ϵ�ȡ��Ԫ�صķ�ʽ��
*/
	public static void method_get()//������
	{
		ArrayList al = new ArrayList();

		//1,���Ԫ��
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");

		//��ȡ������ ������ȡ�������е�Ԫ��
		Iterator it = al.iterator();//�������iterator�������ص���һ���ӿڵ��������
//hasNext()��next()���ǽӿ���ķ�����һ�����жϻ���û��Ԫ�ص�����һ���Ƿ��ص�������һ��Ԫ��
		while(it.hasNext())
		{
			sop(it.next());
		}
		//sop(it.next());��ʱ���׳�NoSuchElementException�쳣����Ϊû����һ��Ԫ�ؿ��Ե���
		
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*
���н����
base_method:{
ԭ���ϣ�[java01, java02, java03, java04]
ԭsize:4
java03�Ƿ���ڣ�true
����Ϊ���𣿣�false
�ı��ļ��ϣ�[java01, java03, java04]
}
method_2:{
al1:[java01, java02]
al2:[java01, java02, java05, java06]
}
method_get:{
java01
java02
java03
java04
}
*/
