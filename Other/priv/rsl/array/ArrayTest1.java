package priv.rsl.array;
class ArrayTest1//���飨�Ż��Ľ���ת�����룩 
{
	public static void main(String[] args) 
	{
		System.out.print("6 to bin is ");
		toBin(6);
		System.out.println();
		System.out.print("6 to Ba is ");
		toBa(6);
		System.out.println();
		System.out.print("6 to Hex is ");
		toHex(6);

	}
	/*
	ʮ���ơ�->������
	*/
	public static void toBin(int num)
	{
		trans(num,1,1);
	}
	/*
	ʮ����-->�˽���
	*/
	public static void toBa(int num)
	{
		trans(num,7,3);
	}
	/*
	ʮ����-->ʮ������
	*/
	public static void toHex(int num)
	{
		trans(num,15,4);
	}	
	/*
	����һ������ת����������ת�����ơ����У���һ���ַ����������ɽ���Ԫ�ر�
	��һ���ַ����������Ŵ�Ž���Ԫ�أ��ٴ�ӡ��
	*/
	public static void trans(int num,int base,int offset)//num:��Ҫת��������base:������Ļ�����offset:��Ҫ�ƶ���λ����
	{
		char[] chs={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] arr=new char[32];//arr����������Ž���Ԫ�أ������32����������ƣ���
		int pos=arr.length;//posΪλ��ָ����������������ʼ��ţ�
		while(num!=0)//��num�ƶ������еĶ�����λ����0ʱ����num��ֵΪ0��������ִ������ѭ���壻
		{
			int temp = num & base;
			arr[--pos] =chs[temp];
			num=num>>>offset;
		}
		for (int x=pos;x<arr.length ;x++ )
		{
			System.out.print(arr[x]);
		}
	}
}
