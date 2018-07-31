package priv.rsl.string;
/*
StringBuffer���ַ���������
��һ������
1�������ǿ��Ա仯��
2�������Լ����������������
3�����ջ�ͨ��toString��������ַ���

ע�⣺append������insert�����ȷ���������StringBuffer��

1���洢
StringBuffer append():��ָ��������Ϊ������ӵ��������ݽ�β����
StringBuffer insert(λ��,����)�����Խ����ݲ���ָ��λ�á�

2��ɾ��
	StringBuffer delete(start,end)ɾ���������е����ݣ�����start������end
	StringBuffer deleteCharAt(index):ɾ��ָ��λ�õ��ַ���

3����ȡ
	char charAt(int index) 
	int indexOf(String str) 
	int lastIndexOf(String str) 
	int length() 
	String substring(int start) 

4���޸�
	StringBuffer replace(int start, int end, String str)
	void setCharAt(int index, char ch)//ע�ⷵ��������void

5����ת
	StringBuffer reverse()

6��
	���ַ�����ָ��λ�õ��ַ����洢��ָ���ַ������С�
	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)

JDK1.5 �汾֮�������StringBuilder

StringBuffer���߳�ͬ�����������ڶ��̣߳��������ж�
StringBuilder���̲߳�ͬ������û�������жϣ������ڵ��̣߳�Ч�ʸ�

��������ʹ��String Builder

Java�����������أ�
1�����Ч��
2������д
3����߰�ȫ��

*/


class StringBufferDemo 
{
	public static void main(String[] args) 
	{
		method_getChars();
		method_reverse();
		method_update();
		method_del();
		method_add();
		
	}

	public static void method_getChars()
	{
		StringBuffer sb = new StringBuffer("abcdef");
		char[] str = new char[6];
		sb.getChars(1,4,str,1);
		for (int x=0;x<str.length;x++)
		{
			sop("str["+x+"]="+str[x]+';');
		}
	/*�����
		str[0]= ;
		str[1]=b;
		str[2]=c;
		str[3]=d;
		str[4]= ;
		str[5]= ;
	*/

	}

	public static void method_reverse()
	{
		StringBuffer sb = new StringBuffer("abcdef");
		sb.reverse();
		sop(sb.toString());	
		//�����fedcba
	}

	public static void method_update()
	{
		StringBuffer sb = new StringBuffer("abcdef");

		sb.replace(1,4,"java");//��1�Ǳ굽3�Ǳ���ַ����滻��java
		sb.setCharAt(2,'g');//��2�Ǳ��ַ���Ϊg������������void
		sop(sb.toString());	
		//�����ajgvaef
	}

	public static void method_del()
	{
		StringBuffer sb = new StringBuffer("abcdef");

		sb.delete(1,3);// ɾ��ָ��λ���ַ���
		sb.deleteCharAt(2);//ɾ��ָ��λ���ַ�
		sb.delete(0,sb.length());//�����������
		sop(sb.toString());	
		//�����������û������
	}


	public static void method_add()
	{
		StringBuffer sb = new StringBuffer();

		sb.append("abc").append(true).append(34);
		sop(sb.toString());
		/*ע�⣺append�������ص���������StringBuffer�������ǿ��Լ�������append ����*/
		//�����abctrue34
	}


	public static void sop(String str)
	{
		System.out.println(str);
	}

}
