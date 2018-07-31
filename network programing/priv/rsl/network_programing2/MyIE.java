package priv.rsl.network_programing2;

/*
дһ���Լ���������ͻ���:


*/

import java.net.*;
import java.io.*;

class MyIE {
    public static void main(String[] args) throws Exception {
	Socket s = new Socket("10.187.77.28", 8080);

	// ����������������
	PrintWriter out = new PrintWriter(s.getOutputStream(), true);

	out.println("GET /myWeb/Demo.html HTTP/1.1");// ��������
	out.println("Accept:*/*");
	out.println("Accept-Language:zh-cn");
	out.println("Host:10.187.77.28:8080");
	out.println("Connection:close");

	// ******һ��Ҫд����******
	out.println();
	out.println();

	// ��ȡ���������ص����ݣ���ʵ����tomcat���������Զ����myWeb/Demo.html�ļ�����
	BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

	String line = null;

	while ((line = bufr.readLine()) != null) {
	    System.out.println(line);
	}

	s.close();
    }

}

/*
 * 
 * ���Ƿ�������Ӧ����ͷ��
 * 
 * HTTP/1.1 200 (���ӳɹ�) Accept-Ranges: bytes () ETag: W/"228-1515384175199" ()
 * Last-Modified: Mon, 08 Jan 2018 04:02:55 GMT (�޸�ʱ��) Content-Type: text/html
 * (���͵��ļ�����) Content-Length: 228 Date: Mon, 08 Jan 2018 06:10:07 GMT
 * 
 * <html> <body> <h1>�����ҵ���ҳ</h1> <font size=5 color=read>��ӭ����</font> <div> һ��ʫ
 * һ��ʫ</br> һ��ʫ һ��ʫ</br> һ��ʫ һ��ʫ</br> һ��ʫ һ��ʫ</br> -----rsl <div> </body>
 * </html>
 * 
 * 
 */
