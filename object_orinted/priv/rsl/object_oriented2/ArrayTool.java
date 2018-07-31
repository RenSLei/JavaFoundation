package priv.rsl.object_oriented2;
/*
��ArrayTool.class�ļ����������ˣ�������ֻҪ�����ļ����õ�classpath·���£�
�Ϳ���ʹ�øù������ˣ����Ǹù������ж����˶��ٷ������Է�����֪������Ϊ����û��
ʹ��˵���顣
��ʼ���������˵���顣java��˵����ͨ���ĵ�ע������ɡ�
*/
/**
����һ�����Զ�������в����Ĺ����࣬�������ṩ�ˣ���ȡ��ֵ������ȹ��ܡ�
@author Ren shilei
@version V1.1
*/
public class ArrayTool //���Ȩ��Ҫ�㹻��ſ�������˵���ĵ���ʹ��public����Ȩ��
{
	/**
	�ղ����������캯��
	*/
	private ArrayTool(){};
	/**
	��ȡһ�����������е����ֵ
	@param arr ����һ��int���͵�����
	@return �᷵��һ���������е����ֵ
	*/
	public static int getMax(int[] arr) //��ȡ���ֵ����
	{
		int max = 0;
		for(int x=1;x<arr.length;x++)
		{
			if(arr[x]>arr[max])
				max=x;
		}
		return arr[max];
	} 
	/**
	��ȡһ�����������е���Сֵ
	@param arr ����һ��int���͵�����
	@return �᷵��һ���������е���Сֵ
	*/
	public static int getMin(int[] arr)//��ȡ��Сֵ����
	{
		int min = 0;
		for(int x=1;x<arr.length;x++)
		{
			if(arr[x]<arr[min])
				min=x;
		}
		return arr[min];
	}
	/**
	��int�������ѡ������
	@param arr ����һ��int���͵�����
	*/
	public static void selectSort(int[] arr)//��С����_ѡ�����򷽷�
	{
		for (int x=0;x<arr.length-1 ;x++ )
		{
			for (int y=x+1;y<arr.length ;y++ )
			{
				if (arr[x]>arr[y])
				{
					swap(arr,x,y);
				}
			}
		}
	}
	/**
	��int�������ð������
	@param arr ����һ��int���͵�����
	*/
	public static void bubbleSort(int[] arr)//�Ӵ�С_ð�����򷽷�
	{
		for (int x=0;x<arr.length-1 ;x++ )
		{
			for (int y=0;y<arr.length-1-x ;y++ )
			{
				if (arr[y]<arr[y+1])
				{
					swap(arr,y,y+1);
				}
			}
		}
	}
	/**
	�������е�Ԫ�ؽ���λ���û�
	@param arr ����һ��int���͵�����
	@param a Ҫ�û���λ��
	@param b Ҫ�û���λ��
	*/
	private static void swap(int[] arr,int a,int b)//��Ϊ�˺���ֻ���ڲ�ʹ�ã�����private
	{
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	/**
	���ڴ�ӡ�����е�Ԫ�أ���ӡ��ʽ�ǣ�[element1, element2, ...] 
	*/
	public static void printArray(int[] arr)//��ӡ����
	{
		System.out.print("[");
		for (int x=0;x<arr.length ;x++ )
		{
			if (x!=arr.length-1)
				System.out.print(arr[x]+",");
				else
				System.out.print(arr[x]+"]");
		}

	}

}
/*
һ��������û�����ù��캯��������Ĭ�Ϲ��캯���������η���������һ�£�
��Ĭ�Ϲ��캯���ǰ�����ı仯���仯�ģ�
ע����νĬ�ϣ���ϵͳ��Ĭ�ϣ���û���ֶ����õĹ��캯����
*/
