package priv.rsl.string;
/*
��ȡһ���ַ�������һ���ַ����г��ֵĴ���
˼·��
һ������������ȡ�Ӵ���һ�γ��ֵ�λ�á�ÿһ�λ�ȡ����ʣ�µĴ��м�����ȡ��ֱ����ȡʧ��Ϊֹ��
*/

class StringTest2 
{
	public static int getSubCount(String str,String s)
	{
		int i = 1;
		int count = 0;
		int index = 0;
		while((index=str.indexOf(s))!=-1)
		{
			sop("str"+(i++)+"="+str);
			str = str.substring(index+s.length());
			count++;
		}
		return count;
	}
/*
��ϰ��������

*/
	public static int getSubCount_2(String str,String s)
	{
		int count = 0;
		int index = 0;
		while((index=str.indexOf(s,index))!=-1)
			{	
				sop("index="+index+"    count="+count);
				index= index+s.length();
			}
		return count;
	}
	public static void main(String[] args) 
	{
		String s = "dakkdsgskkfsgkkfskkasfkafkk";
		sop("��һ��");
		sop("count="+getSubCount(s,"kk"));
		sop("������");
		sop("count="+getSubCount_2(s,"kk"));
	}
	public static void sop(String str)
	{
		System.out.println(str);
	}
}
/*
���н����
��һ��
str1=dakkdsgskkfsgkkfskkasfkafkk
str2=dsgskkfsgkkfskkasfkafkk
str3=fsgkkfskkasfkafkk
str4=fskkasfkafkk
str5=asfkafkk
count=5
������
index=2    count=0
index=8    count=0
index=13    count=0
index=17    count=0
index=25    count=0
count=0

*/
