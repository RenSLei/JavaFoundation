package priv.rsl.collections;
/*
ѧϰ���ϱ�����
ʹ��Collection�ӿ��е�toArray������
*/


import java.util.*;
class CollectionToArrayDemo 
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		/*
		
		1,ָ�����͵����鵽��Ҫ����೤�أ�
		��ָ�����͵����鳤��С�ڼ��ϵ�size����ô�÷����ڲ��ᴴ��һ���µ����顣����Ϊ���ϵ�size
		��ָ�����͵����鳤�ȴ��ڼ��ϵ�size����ô�Ͳ��ᴴ��һ���µ����顣����ʹ�ô��ݽ���������
		���Դ���һ���ոպõ��������š�

		2��ΪʲôҪ�����ϱ�Ϊ���飿
		Ϊ���޶���Ԫ�صĲ���������Ҫ��ɾ������
		
		*/
		String [] arr = al.toArray(new String[al.size()]);
		sop(Arrays.toString(arr));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
