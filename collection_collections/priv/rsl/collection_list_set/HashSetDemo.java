package priv.rsl.collection_list_set;
import java.util.*;
/*
|--Set:Ԫ�������򣨴����ȡ����˳��һ��һ�£���Ԫ�ز������ظ���
	|--HashSet:�ײ����ݽṹ�ǹ�ϣ��
	|--TreeSet:
Set���ϵĹ��ܺ�Collection��һ�µġ�

*/

class HashSetDemo 
{
	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		HashSet hs =new HashSet();

		hs.add("java01");
		sop(hs.add("java02"));
		sop(hs.add("java02"));
		sop(hs.add("java03"));
		hs.add("java04");
		hs.add("java04");

		//��ȡԪ��Ҳֻ����Collectionһ���õ�����
		Iterator it = hs.iterator();

		while (it.hasNext())
		{
			sop(it.next());
		}
	}
}
/*
���н����
true      //��һ��addjava02�ɹ�
false     //�ڶ���addjava02ʧ�ܣ���Ϊ�ظ�
true      //������addjava03�ɹ�
java04
java03
java02
java01

*/
