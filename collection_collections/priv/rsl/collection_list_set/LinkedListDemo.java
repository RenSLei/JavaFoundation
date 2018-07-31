package priv.rsl.collection_list_set;
import java.util.*;
/*
LinkedList�ײ����������ݽṹ��
LinkedList:���з�����
addFirst();
addLast();

getFirst();
getLast();
���Ԫ�أ����ǲ�ɾ��Ԫ�ء�
���������û��Ԫ�ػ����NoSuchElementException�쳣

removeFirst();
removeLast();
���Ԫ�أ�����ɾ��Ԫ�ء�
���������û��Ԫ�ػ����NoSuchElementException�쳣


��JDK1.6���������������

offerFirst();
offerLast();

peekFirst();
peekLast();
���Ԫ�أ����ǲ�ɾ��Ԫ�ء����������û��Ԫ��,�᷵��null.

pollFirst();
pollLast();
���Ԫ�أ�����ɾ��Ԫ�ء����������û��Ԫ��,�᷵��null.

*/


class LinkedListDemo 
{
	public static void main(String[] args) 
	{
		LinkedList link = new LinkedList();

		link.add("java01");
		link.addFirst("java02");
		link.addLast("java03");
		link.add("java04");

		sop("��ʾaddFirst��addLast������"+link);//˼����ӡ���

		sop("get��Ԫ�أ�"+link.getFirst()+"\nget�󳤶ȣ�"+link.size());
		sop("removeĩԪ�أ�"+link.removeLast()+"\nremove�󳤶ȣ�"+link.size());

		while(!link.isEmpty())
		{
			sop(link.removeFirst());//ȡ���linkΪ��
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*
���н����
��ʾaddFirst��addLast������[java02, java01, java03, java04]
get��Ԫ�أ�java02
get�󳤶ȣ�4
removeĩԪ�أ�java04
remove�󳤶ȣ�3
java02
java01
java03
*/
