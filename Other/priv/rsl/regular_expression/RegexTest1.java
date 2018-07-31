package priv.rsl.regular_expression;

/*
��ϰ
*/
import java.util.TreeSet;

class RegexTest1 {
    public static void main(String[] args) throws Exception {
	ipSort();
	//test_1();
    }

    /*
     * ���󣺽������ַ���ת�ɣ���Ҫѧ���
     * 
     * ˼·��
     * 1���ַ�������ȷ�����----��ƥ��
     * 2�������ַ���----->��һ���ַ���----���滻
     * 3�������Լ��ķ�ʽ���ַ�����ɶ���ַ���-----�и�(��ȡ���������) 
     * 4���õ����Ϲ�����ַ���-----��ȡ����ȡ���Ϲ�����Ӵ�
     * 
     */
    
    
    /** 
    * @Title: test_1 
    * @Description: TODO ȥ���ַ�����.�Լ��ظ��ַ�
    * @param 
    * @return void
    * @throws 
    */
    public static void test_1() {
	// ��һ���ַ�����
	String str = "����...����...��Ҫ...ҪҪ..ҪҪ..ѧѧѧ..ѧѧ..����..���.�̳�..�̳�.....��";
	/*
	 * ------�滻 1����.ȥ�� 2����ȥ�ظ�
	 */

	// 1����.ȥ��
	str = str.replaceAll("\\.+", "");
	// 2����ȥ�ظ�
	str = str.replaceAll("(.)\\1+", "$1");

	System.out.println(str);
    }

    /*
     *��ip��ַ��  192.89.3.234 102.49.23.13 10.10.10.10 2.2.2.2 8.32.52.64 ���е�ַ��˳�������
     * 
     * �����ַ�����Ȼ˳��ֻҪ������ÿһ�ζ���3λ����
     * 1��ÿ��ip��ÿһ��������һλ���֡���ô��ÿ�ζ�������0����֤��ÿһ�����ٶ�����λ������������
     * 2����ÿһ��ֻ����3λ
     * 
     */

    /** 
    * @Title: ipSort 
    * @Description: TODO �����滻���и���ۺ�Ӧ�� 
    * @param 
    * @return void
    * @throws 
    */
    public static void ipSort() {
	String ip = "192.89.3.234  102.49.23.13  10.10.10.10  2.2.2.2  8.32.52.64";

	// ʹ���滻replaceAll()
	// ��ÿһ��ǰ�������0
	ip = ip.replaceAll("(\\d+)", "00$1");

	// ������λ��Ч���ֵĶ�ǰ���0ȥ��
	ip = ip.replaceAll("0*(\\d{3})", "$1");

	// �ÿո�ȥ��
	String[] s = ip.split(" +");

	TreeSet<String> ts = new TreeSet<String>();

	// ����s��ӵ�������,������
	for (String str : s) {
	    ts.add(str);
	}

	for (String ip_s : ts) {
	    System.out.println(ip_s.replaceAll("0*(\\d+)", "$1"));
	}
    }
}