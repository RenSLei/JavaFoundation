package priv.rsl.diy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufrTest {

    public static void main(String[] args) {
	BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("���������ݣ�");
	// ��ȡ����
	String line = null;
	    try {
		line = bufr.readLine();
		System.out.println(line);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    	System.out.println("123");
	    }
    }