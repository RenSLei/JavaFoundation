
package priv.rsl.regular_expression;

/**
 * @ClassName: RegexDemo4
 * @Description: TODO ʹ�ø����� replacement �滻���ַ�������ƥ�������������ʽ�����ַ���
 * @author rsl
 * @date 2018��1��27�� ����4:20:50
 * 
 */
public class RegexDemo4 {

    public static void main(String[] args) {

	// ���ַ���������5�����������滻��#��
	// String str = "fsjdkghkjs49354396743nkgkdagh35345kjh5";
	// replaceAllDemo(str,"\\d{5,}","#");

	// �������滻�ɵ����ַ���
	String str1 = "dfkkkgdsgllasdhh";
	// $1��һ��ƥ������ڵ����ݣ�������ʽ�е�һ��Բ�����еı��ʽƥ�䵽������
	replaceAllDemo(str1, "(.)\\1+", "$1");
	// �����dfkgdsglasdh

    }

    /** 
    * @Title: replaceAllDemo 
    * @Description: TODO  
    * @param @param str ԭ�ַ���
    * @param @param reg ����
    * @param @param newStr ƥ�䵽���ַ�
    * @return void
    * @throws 
    */
    public static void replaceAllDemo(String str, String reg, String newStr) {
	// ���ַ����з���reg������Ӵ���newStrȥ�滻
	str = str.replaceAll(reg, newStr);
	System.out.println(str);
    }

}
