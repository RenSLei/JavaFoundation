package priv.rsl.diy.test;

import java.util.Scanner;

public class ScannerTestDemo {

    public static void main(String[] args) {
	Scanner in =null;
	
	for (int i = 0; i < 2; i++) {
	    
	System.out.println("请输入："); //如输入：123456回车
	
	in= new Scanner(System.in);
	
	System.out.println(in.nextLine());
	}
	if(in!=null)
	    in.close();//关闭扫描器
    }
}
