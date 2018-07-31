package priv.rsl.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @ClassName: RegexDemo5 
* @Description: TODO ��ȡ�����ַ����еķ��Ϲ�����Ӵ�ȡ��  
* @author rsl
* @date 2018��1��27�� ����4:47:50 
*  
*/

/* 
 * �������裺
1����������ʽ��װ�ɶ���Pattern p = Pattern.compile(reg);

2������������Ҫ�������ַ������:

3�������󣬻�ȡ����ƥ������:

4��ͨ������Է��Ϲ�����Ӵ����в���������ȡ��
*/
public class RegexDemo5 {

    public static void main(String[] args) {
	//��һ���ַ�����
	String str = "ming tian jiu yao fang jia le ,kai xin";
	//�������ֻȡ��������ĸ��ɵĵ���
	String reg = "\\b[a-zA-Z]{3}\\b";
	/*
	\b�ǵ��ʱ߽�ƥ������
	*/

	//1����װ��Pattern����
	Pattern p = Pattern.compile(reg);
	/*
	ע�⣺Pattern��û�й��췽���������о�̬�������ҷ��ر������
        public static Pattern compile(String regex)
	��������������ʽ���뵽ģʽ�С�
	*/

	//2�����ַ����������������������ȡƥ����
	Matcher m = p.matcher(str);
	/*
        public Matcher matcher(CharSequence input)
	����ƥ������������ģʽ��ƥ������
	���أ���ģʽ����ƥ����
	 */

	//3����ȡ
	while (m.find()) {
	    System.out.println(m.group());
	    // ����ÿ�β��Һ󷵻�ƥ�䵽�����ַ������������һ���ַ������ַ����е�����λ��.
	    System.out.println(m.start() + "..." + m.end());
	}
	/*
	1��find()
	public boolean find()���Բ������ģʽƥ����������е���һ�������С�  
	�˷�����ƥ��������Ŀ�ͷ��ʼ������÷�����ǰһ�ε��óɹ��˲��Ҵ���ʱ��ʼƥ����û�б����ã�
	�����ǰƥ�����û��ƥ��ĵ�һ���ַ���ʼ��  

	2��group()
	matcher.group()����ƥ�䵽�����ַ��� 

	ע�⣺ƥ���������matches()��ȫ��ƥ�䣬�ǽ��������봮��ģʽƥ�䣬
	���Ҫ��֤һ������������Ƿ�Ϊ�������ͻ��������ͣ�һ��Ҫ��matches()��
		
	��String���е�matches()�����õ�Pattern��Matcher��������ɵ�
	ֻ������Stringd�ķ�����װ�ˣ���������Ϊ�򵥣����ǹ��ܵ�һ
	*/
    }

}
