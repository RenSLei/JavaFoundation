package priv.rsl.collections;
/*
���Ͽ�ܵĹ����ࡣ
Collections:
����binarySearch��
�۰���ң������Ƕ�����ļ��ϱ���������ģ���List


*/



import java.util.*;
class  CollectionsBinarySearch
{
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("z");
		list.add("zz");
		list.add("kkkk");
		list.add("qq");
		
		Collections.sort(list);//������Ȼ˳�����м���List
		sop(list);

		int index = Collections.binarySearch(list,"kkkk");//ʹ��Collections��ķ���binarySearch���ҽǱ�
	
		sop("index="+index);

		Collections.sort(list,new StrLenComparator());//�����Զ����˳�����м���List

		sop(list);

		int index2 = Collections.binarySearch(list,"kkkk",new StrLenComparator());//��"kkk"���Զ����˳���в��ң�ע��Ҫ��ӱȽ����������

		sop("index2="+index2);

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);

	}
}
	class StrLenComparator implements Comparator<String>
	{
		public  int compare(String s1,String s2)
		{
			if(s1.length()>s2.length())
				return 1;
			if(s1.length()<s2.length())
				return -1;
			return s1.compareTo(s2);
		}
	}

/*
�����

[aaa, abcd, kkkk, qq, z, zz]
index=2
[z, qq, zz, aaa, abcd, kkkk]
index2=5


*/
