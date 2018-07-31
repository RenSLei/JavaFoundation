package priv.rsl.collections;
/*
Arrays:���ڲ�������Ĺ����ࡣ
���涼�Ǿ�̬����,��binarySearch,toString,equals,fill,copyOf,copyOf
sort,asList(�ص�)��

*/


import java.util.*;
class  ArraysDemo
{
	public static void main(String[] args) 
	{
		//int [] arr = {2,4,5};
		//sop(Arrays.toString(arr));//�������飬����ַ�����


		String [] arr = {"fadc","dd","gg"};

		List<String> list = Arrays.asList(arr);

		//��������list������ʲô�ô���
		/*
		����ʹ�ü��ϵ�˼��ͷ��������������е�Ԫ�ء�
		
		ע�⣺�������ɼ��ϣ�������ʹ�ü��ϵ���ɾ������
		��Ϊ����ĳ����ǹ̶���
		����ʹ���磺
		contains
		get
		indexof()
		subList()
		
		�����ɾ����ô�ᷢ��UnsupportedOperationException

		*/
		sop("contains:"+list.contains("dd"));
		//list.add("kkk");//UnsupportedOperationException
		sop(list);

		Integer[] nums = {2,4,5};//int[] nums = {2,4,5};

		List<Integer> li = Arrays.asList(nums);
		
		/*
		��������е�Ԫ�ض��Ƕ�����ô��ɼ���ʱ�������е�Ԫ�ؾ�ֱ��ת�ɼ����е�Ԫ��
		��������е�Ԫ�ض��ǻ����������͡���ô�Ὣ������Ϊ�����е�Ԫ�ش��ڡ�

		*/
		sop(li);

	}


	



	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}

	
