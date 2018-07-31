
package priv.rsl.regular_expression;
/*
网页爬虫(蜘蛛)：
可以爬各种信息，用正则去获取我们想要的信息
*/

import java.util.regex.*;
import java.io.*;
import java.net.*;

class RegexTest3 {
    public static void main(String[] args) throws Exception {
	getMails_2();
    }

    // 从网页上爬邮箱
    /*
     * 先自己写一个网页，里面包含邮箱地址，放在tomcat服务器里，通过程序做一个客户端访问该服务器 开启该服务器 然后从里面爬取邮箱
     * 也可以直接直接联网获取信息
     */
    /** 
    * @Title: getMails_2 
    * @Description: TODO 网页爬虫
    * 将网址封装成一个URL对象--->  获取URLConnection--->获取InputStream(获得服务器返回的数据)--->正则
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
    * @Description: TODO 从一个文件中爬取信息:
    * 正则封装成Pqttern对象(Pattern.compile())--->str获取匹配器(p.matcher(str))--->匹配器的find()以及group()方法 
    * @param  
    * @return void
    * @throws Exception
    */
    public static void getMails_1() throws Exception {
	// 演示爬已有文件中的邮件地址
	BufferedReader bufr = new BufferedReader(new FileReader("mail.txt"));
	// 读取一行，然后对每一行进行获取
	String line = null;

	// 建立规则
	String mail_reg = "\\w+@\\w+(\\.\\w+)+";// 精确匹配"[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3})+";
	// 将正则封装成Pattern对象
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
