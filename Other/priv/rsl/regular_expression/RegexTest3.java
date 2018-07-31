
package priv.rsl.regular_expression;
/*
��ҳ����(֩��)��
������������Ϣ��������ȥ��ȡ������Ҫ����Ϣ
*/

import java.util.regex.*;
import java.io.*;
import java.net.*;

class RegexTest3 {
    public static void main(String[] args) throws Exception {
	getMails_2();
    }

    // ����ҳ��������
    /*
     * ���Լ�дһ����ҳ��������������ַ������tomcat�������ͨ��������һ���ͻ��˷��ʸ÷����� �����÷����� Ȼ���������ȡ����
     * Ҳ����ֱ��ֱ��������ȡ��Ϣ
     */
    /** 
    * @Title: getMails_2 
    * @Description: TODO ��ҳ����
    * ����ַ��װ��һ��URL����--->  ��ȡURLConnection--->��ȡInputStream(��÷��������ص�����)--->����
    * @param 
    * @return void
    * @throws Exception
    */
    public static void getMails_2() throws Exception {
	URL url = new URL("http://blog.sina.com.cn/s/blog_515617e60101e151.html");// http://192.168.43.53:8080/myWeb/mail.html
	URLConnection conn = url.openConnection();

	BufferedReader bufrIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	String line = null;
	String mail_reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3})+"; //pan.baidu.com/s\\S+
	Pattern p = Pattern.compile(mail_reg);

	while ((line = bufrIn.readLine()) != null) {
	    Matcher m = p.matcher(line);

	    while (m.find()) {
		System.out.println(m.group());
	    }

	}
    }

    
    /** 
    * @Title: getMails_1 
    * @Description: TODO ��һ���ļ�����ȡ��Ϣ:
    * �����װ��Pqttern����(Pattern.compile())--->str��ȡƥ����(p.matcher(str))--->ƥ������find()�Լ�group()���� 
    * @param  
    * @return void
    * @throws Exception
    */
    public static void getMails_1() throws Exception {
	// ��ʾ�������ļ��е��ʼ���ַ
	BufferedReader bufr = new BufferedReader(new FileReader("mail.txt"));
	// ��ȡһ�У�Ȼ���ÿһ�н��л�ȡ
	String line = null;

	// ��������
	String mail_reg = "\\w+@\\w+(\\.\\w+)+";// ��ȷƥ��"[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3})+";
	// �������װ��Pattern����
	Pattern p = Pattern.compile(mail_reg);

	while ((line = bufr.readLine()) != null) {
	    Matcher m = p.matcher(line);

	    while (m.find()) {
		System.out.println(m.group());
	    }
	}
	bufr.close();
    }

}
