package priv.rsl.string;
/*
��ȡ�����ַ����������ͬ�Ӵ�����һ�����������̵��Ǹ������г���һ�εݼ����Ӵ���ӡ��
"abcwerthelloyuiodef"
"cvhellobnm"
˼·��
	1�����̵��Ӵ����ճ��ȵݼ��ķ�����ȡ��
	2����ÿ��ȡ�����Ӵ�ȥ�������ж��Ƿ�������������Ѿ��ҵ���
*/

class StringTest4 
{
	/*��ϰ��*/
	public static String getMaxSubString(String s1,String s2)
	{
		String max = "",min = "";
		max = (s1.length()>s2.length())?s1:s2;

		min = (max==s1)?s2:s1;

		for (int x = 0;x<min.length() ;x++ )
		{
			for (int y= 0,z=min.length()-x;z!=min.length()+1 ;y++,z++ )
			{
				String temp = min.substring(y,z);
				if(max.contains(temp))
					return temp;
			}
		}
		return " ";
		//��������в������Ӵ��κ����ݣ�������ѭ����û���κη���ֵ����Ҫ����󷵻�һ�ַ���
	}
	public static void main(String[] args) 
	{
		String s1 = "abcwerthelloyuiodef";
		String s2 = "cvhellobnm";
		sop("����Ӵ��ǣ�"+getMaxSubString(s1,s2));
	}
	public static void sop(String str)
	{
		System.out.println(str);
	}
}
/*
���н���ǣ�
����Ӵ��ǣ�hello
*/
