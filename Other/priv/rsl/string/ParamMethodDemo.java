package priv.rsl.string;
/*
JDK 1.5�汾���ֵ�������

�����Ŀɱ����
��ʹ��ʱ��ע�⣺�ɱ����һ��Ҫ�����ڲ����б������

*/




class  ParamMethodDemo
{
	public static void main(String[] args) 
	{
		
		//��Ҫ���ݵ����ݲ���������ȷ��ʱ�����纯��д�ɣ�public static void show(int[] arr)
		//��ÿ�ζ�Ҫ����һ�����顣��Ϊʵ�ʵĲ�����
		/*
		int [] arr ={1,2};
		show(arr);

		int [] arr1 ={1,2,4,5,6};
		show(arr1);
		*/
		/*
		���潲��ɱ������
		��ʵ������һ����������ļ�д��ʽ
		����ÿ�ζ��ֶ��Ľ����������
		ֻҪ��Ҫ������Ԫ����Ϊ�������ݼ���
		��ʽ����Щ������װ��������

		
		*/
		//show(1,2);
		show("haha",2,4,65,7);//�����ͼ򻯶���
	}

	public static void show(String s, int... arr)
	{
		System.out.println(arr[0]+s);
	}
}
