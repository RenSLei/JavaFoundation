package priv.rsl.collections;
/*
�߼�forѭ��:
JDK1.5�汾���ֵ������ԣ����˴������д������˳���Ч��
�����ʽ�͹��ܣ�
for(�������� ������ ����Ҫ�����ļ��ϣ�collection����������)
{

}

���ǹ��ܾ��о����ԣ�
�߼�forֻ�ܶ�ȡԪ�أ����ܲ��������е�Ԫ�أ����ǵ������Ϳ���remove�����е�Ԫ��
���ʹ��ListIterator,�����Զ�Ԫ�ؽ�����ɾ�Ĳ鶯����

��ͳfor�͸߼�for��ʲô����

�߼�for��һ�������ԣ������б�������Ŀ��
�����ڱ��������ʱ�򣬻���ϣ�����ô�ͳfor.��Ϊ��ͳfor���Զ���Ǳꡣ

*/

import java.util.*;
class ForEachDemo
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		/*
		ArrayListȡ��Ԫ�������ַ�ʽ������(��Ϊ������)�͵�����iterator��
		������ʾ��ͨ��ʹ�õ���������ȡ��Ԫ�أ�
	
		Iterator<String> it = al.iterator();
		
		while(it.hasNext())
		{
			sop(it.next());
		}
	
		/*
		���ַ���Ҳ�Դ����Ӳ�����д��JDK����˴˷����������:����ǿforѭ��
		*/
		for(String s : al)
		{
			sop(s);
		}


	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
