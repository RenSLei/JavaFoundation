package priv.rsl.regular_expression;

/*
----------��������----------

���󣺶��ʼ���ַ����У��

*/

/**
 * @ClassName: RegexTest2
 * @Description: TODO У�������ַ
 * @author rsl
 * @date 2018��1��27�� ����5:25:29
 * 
 */
class RegexTest2 {
    public static void main(String[] args) throws Exception {
	String mail = "abc12@sina.com";

	String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3})+";// ��Ϊ��ȷ��ƥ��

	reg = "\\w+@\\w+(\\.\\w+)+";// ��Բ�̫��ȷ��ƥ��

	System.out.println(mail.matches(reg));

    }

}
