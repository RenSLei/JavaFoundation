package priv.rsl.string;
/*
String:
public final class Stringextends Objectimplements Serializable, Comparable<String>, CharSequenceString ������ַ�����
Java �����е������ַ�������ֵ���� "abc" ������Ϊ�����ʵ��ʵ�֡�


*/


class StringDemo 
{
	public static void main(String[] args) 
	{
		String s1 = "abc";
		/*
		s1��һ�������ͱ�������abc����һ������
		�ַ��������ص㣺
		һ������ʼ���Ͳ����Ա��ı䣺��˼�ǳ���"abc"���ڴ���һ�����ھͲ��ܱ��ı䣬ֻ�ǿ�˭ȥָ���������⡣
		��String s1 = "abc";����s1ָ��"abc".

		*/
		String s2 = new String("abc");

		/*
		s1 ��s2��ʲô����
		s1���ڴ�����һ������s2���ڴ�������������
		*/
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));//String �ิд��Object����equals����,�Ƚϵ����ַ����ĵ�ַ���÷��������ж��ַ����Ƿ���ͬ��
	}
}
/*
���н����
false
true
*/
