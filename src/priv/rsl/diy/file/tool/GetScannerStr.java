package priv.rsl.diy.file.tool;

import java.util.Scanner;

/**
 * @author rsl
 * @Description TODO ��ȡ��������Ĺ����࣬ͨ�����캯������ʼ��this����ĺ������ò���
 *
 */
class GetScannerStr {
    
    private String mesg;
    
    public GetScannerStr(String mesg) {
	this.mesg = mesg;
    }

    /**   
     * @Title getScanner   
     * @Description TODO ��ȡ�����������Ϣ�����ַ�������ʽ���� 
     * @return  ���ؼ��̵�������Ϣ    
     * @Return String  ����������ַ���    
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
