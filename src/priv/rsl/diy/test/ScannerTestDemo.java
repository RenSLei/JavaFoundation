package priv.rsl.diy.test;

import java.util.Scanner;

public class ScannerTestDemo {

    public static void main(String[] args) {
	Scanner in =null;
	
	for (int i = 0; i < 2; i++) {
	    
	System.out.println("�����룺"); //�����룺123456�س�
	
	in= new Scanner(System.in);
	
	System.out.println(in.nextLine());
	}
	if(in!=null)
	    in.close();//�ر�ɨ����
    }
}
