package priv.rsl.collection_list_set;
/*
util���е�
�ӿ�Collection
	|--�ӽӿ�List:Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ��������
		|--ArrayList:�ײ�����ݽṹʹ�õ�������ṹ���ص㣺��ѯ�ٶȺܿ졣������ɾ�������̲߳�ͬ����
					 �ɱ䳤�ȵ����飺������Ĭ�ϳ���10 ʱ�ӳ�50%���ȡ�
		|--LinkedList:�ײ�ʹ�õ��������ݽṹ���ص㣺��ɾ�ٶȺܿ죬��ѯ������
		|--Vector:�Ѿ���̭���ײ�������ṹ���߳�ͬ������ArrayList����ˡ���Vector���ӳ���100%��

	|--�ӽӿ�Set: Ԫ��������ģ�Ԫ�ز������ظ���

List:
	���з��������ǿ��Բ����Ǳ�ķ������Ǹ���ϵ���еķ�����

��
add(index,element);
addAll(index,Collection);

ɾ
remove(index);

��
set(index,element);

��
get(index);��ȡԪ��λ��
subList(from,to);��ȡ���б�����ͷ����β
	listIterator();�ص㣬����

*/

//List��Collection�ӿڵ��ӽӿ�
import java.util.*;
class ListDemo 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		List_method();
		sop("\nListIterator(�ص㲿��)��");
		method_ListIterator();
	}

	public static void List_method()
	{
		ArrayList al = new ArrayList();

		//���Ԫ��
		al.add("java01");
		al.add("java02");
		al.add("java03");

		sop("ԭ���ϣ�"+al);

		//��ָ��λ��(�����ǽǱ�Ϊ1��λ��)���Ԫ��("java09")
		al.add(1,"java09");
		sop("�ڽǱ�Ϊ1��λ�����Ԫ��java09��ļ��ϣ�"+al);

		//ɾ��ָ��λ��(����Ǳ�Ϊ2)��Ԫ��
		//al.remove(2);
		
		//�޸�ָ���Ǳ��Ԫ��
		al.set(2,"java007");
		sop("���Ǳ�Ϊ2��Ԫ���滻Ϊjava007��ļ��ϣ�"+al);
		
		//ע���������Ǽ򵥴�ӡ��ʵ�ʿ�������ȡ��Ԫ��ֵ���в���
		sop("ͨ���Ǳ��ȡԪ��get(1):"+al.get(1));
		
		sop("��ȡ����Ԫ��:");
		for (int x=0;x<al.size() ;x++ )
		{
			sop("al("+x+")="+al.get(x));
		}
		sop("ʹ�õ�������");
		Iterator it = al.iterator();

		while (it.hasNext())
		{
			sop("next:"+it.next());
		}

		//ͨ��indexOf��ȡ�����λ��
		sop("index of java03 is��"+al.indexOf("java03"));
		
		//ע�⣬���б��ص���Ȼ�����б�����ͷ������β
		List sub = al.subList(1,3);
		sop("���б��ǣ�"+sub);

	}
//----------------------------------------------------------------
	/*
	��ʾ���б�����������⣬�ص㣩
	�ӿ� ListIterator<E>
	public interface ListIterator<E> extends Iterator<E>

	���Կ�������Iterator�����࣬��List�������еĵ�������

	*/

	//����������Iterator���ڵľ����ԣ�	
	//public static void method_ListIterator()
	{
	//ע��ArrayList����û��iterator���������Ǵ���java.util.AbstractList �̳еķ���
		ArrayList al = new ArrayList();

		//���Ԫ��
		al.add("java01");
		al.add("java02");
		al.add("java03");

		
		Iterator it = al.iterator();//��ʱ������֪���˼���al������ЩԪ���ˡ�
//����������Ҫ�������ڵ�������Ԫ�صĹ����У��Լ������Ԫ�ؽ��в�����
		while (it.hasNext())
		{
			//ʹ�ö�̬����Ϊ��֪���������Ǵ�ŵ�ʲô���͵�Ԫ��
			Object obj = it.next();

			if (obj.equals("java02"))
				//al.add("java008");
/*��ʹ��al.add("java008");
�����������н����
obj=java01
obj=java02
Exception in thread "main" java.util.ConcurrentModificationException

˵����Ϊʲô���׳����쳣����Ϊ����Ԫ���ڱ�������������ʱ����ʹ�ü��Ϸ�������Ԫ��
���������ʼʱ��ֻ��3��Ԫ�صġ�����Ҫôȫ���õ�����������Ҫôȫ���ü��Ϸ�����

�������ǵ���Iterator�е�����������ͨ������API֪����ֻ������������
hasNext()��next()��remove();
*/
			//ʹ��remove()
			//it.remove();//��java02�����ôӼ�����ɾ��������obj��ʱ���ã������ڴ�ӡ��ʱ����ӡjava02
//���н����obj=java01  obj=java02  obj=java03������al���Ѿ�û��java02��
			
			sop("obj="+obj);
		}
	}

//��������ʾ�ӽӿ�ListIterator,�����ڵ���ʱ�и������Ԫ�صķ�����
	public static void method_ListIterator()
	{
		ArrayList al = new ArrayList();

		//���Ԫ��
		al.add("java01");
		al.add("java02");
		al.add("java03");

		sop("ԭ����"+al);

		ListIterator it = al.listIterator();

		sop("hasPrevious():"+it.hasPrevious());

		while (it.hasNext())
		{
			Object obj = it.next();

			if (obj.equals("java02"))
				//it.add("java009");
				it.set("java006");
		}
		sop("hasNext():"+it.hasNext());
		sop("hasPrevious():"+it.hasPrevious());


		sop("�޸ĺ�ļ���"+al);
	}
	
}
/*
���н����
ԭ���ϣ�[java01, java02, java03]
�ڽǱ�Ϊ1��λ�����Ԫ��java09��ļ��ϣ�[java01, java09, java02, java03]
���Ǳ�Ϊ2��Ԫ���滻Ϊjava007��ļ��ϣ�[java01, java09, java007, java03]
ͨ���Ǳ��ȡԪ��get(1):java09
��ȡ����Ԫ��:
al(0)=java01
al(1)=java09
al(2)=java007
al(3)=java03
ʹ�õ�������
next:java01
next:java09
next:java007
next:java03
index of java03 is��3
���б��ǣ�[java09, java007]

ListIterator(�ص㲿��)��
ԭ����[java01, java02, java03]
hasPrevious():false
hasNext():false
hasPrevious():true
�޸ĺ�ļ���[java01, java006, java03]

*/
