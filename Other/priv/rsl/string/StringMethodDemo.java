package priv.rsl.string;
/*
String�������������ַ��������ô�����ṩ�˶���������ַ������в�����

�����Ĳ�������Щ��
"abcd"

1����ȡ(��Ҫ)
	1.1�ַ����а������ַ��������ַ����ĳ���
		int length();��ȡ���ȡ�
	1.2����λ�û�ȡλ����ĳ���ַ���
		char charAt(int index);
	1.3�����ַ���ȡ���ַ����ַ�����λ�á�
		int indexOf(int ch);���ص���ch ���ַ����е�һ�γ��ֵ�λ�á�
		int indexOf(int ch, int fromIndex)�����ڴ��ַ����е�һ�γ���ch��λ�ã���fromIndexָ����λ�ÿ�ʼ������

		int indexOf(String str);���ص���str���ַ����е�һ�γ��ֵ�λ�á�
		int indexOf(String str, int fromIndex)�����ڴ��ַ����е�һ�γ���str��λ�ã���fromIndexָ����λ�ÿ�ʼ������

		int lastIndexOf(int ch) ����ָ���ַ��ڴ��ַ��������һ�γ��ִ���λ�á� 
2���ж�
	2.1�ַ������Ƿ����ĳһ���Ӵ���
		boolean contains(str): 
		����֮����indexOf(str):��������str��һ�γ��ֵ�λ�ã��������ֵΪ-1����ʾ��str���ڴ��С�
		���ԣ����ڶ�ָ�����ж��Ƿ����Ҳ�ǿ��Եġ�
		��if(str.indexOf("abfs")!=-1)��Ϊ�ǿա�

		���Ҹ÷����ȿ����жϣ��ֿ��Ի�ȡ���ֵ�λ�á�

	2.2�ַ����Ƿ������ݡ�
		boolean isEmpty():�жϳ����Ƿ�Ϊ�㡣
	2.3�ַ����Ƿ���ָ�����ݿ�ͷ��
		boolean startsWith(str);
	2.4�ַ����Ƿ���ָ�����ݽ�β��
		boolean endsWith(str);
	2.5�ж��ַ��������Ƿ���ͬ����д��Object�е�equals������
		boolean equals(str);
	2.6�ж������Ƿ���ͬ�������Դ�Сд��
		boolean equalsIgnoreCase(str);
3��ת��
	3.1���ַ�����ת���ַ���
		���캯����	String(char[] value)
					String(char[] value, int offset, int count)����һ���µ� String��������ȡ���ֽ��������һ����������ַ���
		��̬������	static String copyValueOf(char[] value)
					static String copyValueOf(char[] value, int offset, int count)

					static String copyValueOf(char[] value):
				
	3.2���ַ���ת���ַ�����
		char[] toCharArray();

	3.3���ֽ�����ת���ַ���
		String(byte[] value)
		String(byte[] value, int offset, int count)����һ���µ� String��������ȡ���ַ��������һ����������ַ���

	3.4���ַ���ת���ֽ�����
		byte[] getBytes();
	3.5��������������ת�����ַ���
		static String ValueOf(int):
		static String ValueOf(double):
		
		���⣺�ַ������ֽ�������ת�������У��ǿ���ָ�������ġ�
4���滻
	String replace(oldchar,newchar);
	
5���и�
	String[] split(regex);
6���Ӵ�����ȡ�ַ����е�һ���֡�
	String substring(begin);
	String substring(begin,end);
7��ת����ȥ���ո񣬱Ƚ�
	7.1���ַ���ת�ɴ�д����Сд
		String toUpperCase()
		String toLowerCase()
	7.2���ַ������˵Ķ���ո�ȥ��
		String trim()
	7.3�������ַ���������Ȼ˳��ıȽ�
		int compareTo(String)
	
		
*/

class StringMethodDemo 
{
	public static void method_7()
	{
		String s = "    Hello Java    ";
		sop("ת����Сд��"+s.toLowerCase());
		sop("ת���ɴ�д��"+s.toUpperCase());
		sop("ȥ���ո�"+s.trim());//����,ȥ�����ߵ��ַ�

		String s1 = "acc";
		String s2 = "aac";
		
		/*�����ֵ�˳��Ƚϣ�����С��ͬ���ַ�������
		���ص��Ǵ�����λ�õĶ�Ӧ�ַ���ֵ�Ĳ�ֵ
		ԭ���Ȳ���������ĸ�����򷵻���������Ϊ��*/
		sop("�Ƚ������ַ�����"+s1.compareTo(s2));//����Ϊ��ֵ��2
	}

	public static void method_sub()
	{
		String s = "abcdef";

		sop(s.substring(2));//��ָ��λ�õ���β������Ǳ겻���ڣ�������ַ����Ǳ�Խ���쳣��
		sop(s.substring(2,4));//����ͷ��������β��s.substring(0.s.length());
	}

	public static void method_split()
	{
		String s = "zhangsan,lisi,wangwu";

		String[] arr = s.split(",");
		for (int x=0;x<arr.length;x++)
		{
			sop(arr[x]);
		}
	}

	public static void method_replace()
	{
		String s = "hello java";
		String s1 = s.replace('a','n');//���Ҫ�滻���ַ������ڣ����صĻ���ԭ����
		String s2 = s.replace("java","world");

		sop("ԭ�ַ���s:"+s);
		sop("�滻�ַ�����ַ���s1��"+s1);
		sop("�滻�ַ�������ַ���s2��"+s2);
	}

	public static void method_trans()
	{
		sop("ת��������");
		char[] arr = {'a','b','c','d','e','f'};
		String s = new String(arr);
		String s1 = new String(arr,2,3);//ע��2�Ǵ�����ʼ�Ǳ꣬3�Ǹ���
	
		sop("���ַ�����arr[]ת��Ϊ�ַ���s="+s);
		sop("���ַ�����arr[]������ת��Ϊ�ַ���s1="+s1);

		String s2 = "zxcvbnm";
		char[] chs = s2.toCharArray();
		sop("���ַ���ת��Ϊ���飺");
		for(int x=0;x<chs.length;x++)
		{
			
			sop("ch="+chs[x]);
		}




	}

	public static void method_is()
	{
		sop("�жϷ�����");
		String str = "ArrayDemo.java";
		//�ж��ļ������Ƿ���Array���ʿ�ͷ��
		
		sop("��Array���ʿ�ͷ?"+str.startsWith("Array"));

		//�ж��ļ������Ƿ���.java���ļ�
		sop("��.java���ļ�?"+str.endsWith(".java"));
	
		//�ж��ļ����Ƿ����Demo
		sop("����Demo?"+str.contains("Demo"));

	}

	public static void method_get()
	{
		sop("��ȡ������");
		String str = "abcdeakpf";

		//����
		sop("�ܳ���Ϊ��"+str.length());//��ӡ9

		//����������ȡ�ַ�
		sop("����λ�û���ַ���"+str.charAt(4));//�����ʵ��ַ����в����ڵĽǱ��ʱ��ᷢ��StringIndexOutOfBoundsException�쳣

		//�����ַ���ȡ����
		sop("�����ַ�����ָ��λ�ÿ�ʼ�����ַ�λ�ã�"+str.indexOf('a',3));//���û���ҵ������ص���-1.

		//��������һ���ַ����ֵ�λ��
		sop("��������һ���ַ����ֵ�λ��:"+str.lastIndexOf("a"));//���5�����ڶ���5�ĽǱꡣֻ�Ǵ�β����ʼ������

		//

	}

	public static void main(String[] args) 
	{
		sop("\n��Сдת����ȥ�ո�");
		method_7();
		sop("\n��ȡ�Ӵ���");
		method_sub();
		sop("\n�и");
		method_split();
		sop("\n�滻��");
		method_replace();
		sop("\nת����");
		method_trans();
		sop("\n�жϣ�");
		method_is();
		sop("\n��ȡ:");
		method_get();

		/*
		String s1 = "abc";
		String s2 = new String("abc");
		String s3 = "abc";
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		/*
		��ӡ�����false��true,����true��ԭ����Ϊ�ڳ��������Ѿ���"abc"��������ַ���
		������String s3 = "abc";��ʱ��s1��s3��ָ��"abc".��s1==s3.
		*/
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}

/*
���н����
��Сдת����ȥ�ո�
ת����Сд��    hello java
ת���ɴ�д��    HELLO JAVA
ȥ���ո�Hello Java
�Ƚ������ַ�����2

��ȡ�Ӵ���
cdef
cd

�и
zhangsan
lisi
wangwu

�滻��
ԭ�ַ���s:hello java
�滻�ַ�����ַ���s1��hello jnvn
�滻�ַ�������ַ���s2��hello world

ת����
ת��������
���ַ�����arr[]ת��Ϊ�ַ���s=abcdef
���ַ�����arr[]������ת��Ϊ�ַ���s1=cde
���ַ���ת��Ϊ���飺
ch=z
ch=x
ch=c
ch=v
ch=b
ch=n
ch=m

�жϣ�
�жϷ�����
��Array���ʿ�ͷ?true
��.java���ļ�?true
����Demo?true

��ȡ:
��ȡ������
�ܳ���Ϊ��9
����λ�û���ַ���e
�����ַ�����ָ��λ�ÿ�ʼ�����ַ�λ�ã�5
��������һ���ַ����ֵ�λ��:5

*/
