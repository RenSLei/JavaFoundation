package priv.rsl.diy.file.tool;

import java.util.Scanner;

/**
 * @author rsl
 * @Description TODO 获取键盘输入的工具类，通过构造函数来初始化this对象的函数调用参数
 *
 */
class GetScannerStr {
    
    private String mesg;
    
    public GetScannerStr(String mesg) {
	this.mesg = mesg;
    }

    /**   
     * @Title getScanner   
     * @Description TODO 获取键盘输入的信息，以字符串的形式返回 
     * @return  返回键盘的输入信息    
     * @Return String  键盘输入的字符串    
     */
    public String getScanner() {
	Scanner in=null;
	String s=null;
	System.out.println(mesg);
	in= new Scanner(System.in);
		    
	s=in.nextLine();
	
	return s;
	
    }
}
