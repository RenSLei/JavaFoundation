package priv.rsl.treeSet_generic;
import java.util.*;

/*
���ͣ�JDK1.5�汾�Ժ���������ԡ����ڽ����ȫ���⣬��һ����ȫ���ơ�

�ô���
1.������ʱ�ڳ�������ClassCastException,ת�Ƶ��˱���ʱ�ڡ�
	�������Ա������⡣������ʱ��������٣���ȫ��
2.������ǿ��ת�����鷳��

���͸�ʽ��
ͨ��<>������Ҫ������������������

��ʹ��java�ṩ�Ķ���ʱ��ʲôʱ��д�����أ�
ͨ���ڼ��Ͽ���кܳ�����ֻҪ����<>��Ҫ���巺�͡�

��ʵ<>��˵�����������͵�
��ʹ�ü���ʱ����������Ҫ�洢������������Ϊ�������ݵ�<>�м��ɡ�
*/





class GenericDemo 
{
	public static void main(String[] args) 
	{
		//������<String>������ͣ�������ڱ���ʱ��ͨ������������ʱ�ڳ����쳣���û��޷�����
		ArrayList<String>al = new ArrayList<String>();

		al.add("abc01");
		al.add("abc0091");
		al.add("abc04");

	//˳��˵һ�㣬add������ֻ�ܴ����ģ�����1.5�汾�����Ժ󣬶��ڻ��������������Զ�װ�书��
	//���Կ���ֱ�Ӵ�4������ͨ����
		//al.add(4);//�൱��al.add(new Integer(4));���˷��ͺ󣬴�����ڱ���ʱ�ھ�ͨ������

		//ʹ�õ�����,������ҲҪ��ȷ��ʲô���͵�����
		Iterator<String> it = al.iterator();

		while (it.hasNext())
		{
			//ǿת���ͣ���Ϊ��Ҫ��ӡ�ַ������Ⱦ�Ҫ��length���������˷�����String����
			//String s = (String)it.next();���˷��;Ͳ�����ǿ��ת���ˡ�
			String s = it.next();
			System.out.println(s+":"+s.length());

		}

	}
}
/*

abc01:5
abc0091:7
abc04:5

*/
