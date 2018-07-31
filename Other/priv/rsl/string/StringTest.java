package priv.rsl.string;

class StringTest 
{
	public static void sop(String str)
	{
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		String s = "   abc df   ";
		sop("ԭ�ַ�����("+s+")");
		String s1 = myTrim(s);
		String s2 = reverseString(s,3,5);//����ͷ������β
		String s3 = reverseString(s);
		sop("ȥ�ո���ַ�����("+s1+")");	
		sop("���ַ�ת���ַ�����("+s2+")");	
		sop("ȫ����ת���ַ�����("+s3+")");	
	}

	//��ϰһ�����ַ������˵Ŀո�ȥ��
	public static String myTrim(String s)
	{
		int sta = 0,end = s.length()-1;
		while(sta<=end && s.charAt(sta)==' ')
		sta++;
		while(sta<=end && s.charAt(end)==' ')
		end--;
		return s.substring(sta,end+1);
	}

	//��ϰ������ת�ַ���
	public static String reverseString(String s,int x,int y)
	{
		//���ַ���ת������
		char[] str = s.toCharArray();
		//�����鷴ת
		reverse(str,x,y);
		//������ת���ַ���
		return new String(str);
	}

	public static String reverseString(String s)
	{
		return reverseString(s,0,s.length());
	}

	private static void reverse(char[] arr,int x,int y)
	{
		for(int sta = x,end = y-1;sta<end;sta++,end--)
		{
			swap(arr,sta,end);
		}
	}

	private static void swap(char[] arr ,int x, int y)
	{
		char temp = arr[x];
		arr[x]=arr[y];
		arr[y]= temp;
	}
}

/*
���н����

ԭ�ַ�����(   abc df   )
ȥ�ո���ַ�����(abc df)
���ַ�ת���ַ�����(   bac df   )
ȫ����ת���ַ�����(   fd cba   )


*/
