/**   
* @Title: RegexDemo.java 
* @Package priv.rsl.basal.day25 
* @Description: TODO ��ʾ������ʽ���ص㣺��
* @author rsl
* @date 2018��1��27�� ����12:45:58 
* @version V1.0   
*/
package priv.rsl.regular_expression;

/**
 * @ClassName: RegexDemo
 * @Description: TODO ��������ʽУ��һ�����ִ�
 * @author rsl
 * @date 2018��1��27�� ����12:45:58
 * 
 */

/*
 * ������ʽ�� ����һ������ı��ʽ�� ���ã�����ר�Ų����ַ��� �ô������Լ򻯶��ַ����ĸ��Ӳ�����
 */
public class RegexDemo1 {

    /**
     * @Title: main @Description: TODO У��
     * @param args main�������� 
     * @return void 
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
	/* ���󣺶����鴮����У�飺������0��ͷ������5-15λ�����ܰ�����ĸ */
	String s = "32974983";
	String regex = "[1-9][0-9]{4,14}";

	boolean flag = s.matches(regex);

	if (flag)
	    System.out.println(s + " is ok");
	else
	    System.out.println(s + "���Ϸ�");
    }

}
