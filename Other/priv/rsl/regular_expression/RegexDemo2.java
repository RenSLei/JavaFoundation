/**   
* @Title: RegexDemo2.java 
* @Package priv.rsl.basal.day25 
* @Description: TODO ������ʽ
* @author rsl
* @date 2018��1��27�� ����2:06:11 
* @version V1.0   
*/
package priv.rsl.regular_expression;

/** 
* @ClassName: RegexDemo2 
* @Description: TODO  ���򡪡�ƥ��matches
* @author rsl
* @date 2018��1��27�� ����2:06:11 
*  
*/
public class RegexDemo2 {

    /** 
    * @Title: main 
    * @Description: TODO ����matchesDemo����  
    * @param args
    * @return void
    * @throws Exception
    */
    public static void main(String[] args) throws Exception{
//	ƥ��һ���绰���룬��������1��ͷ���ڶ�λ��3��5��9.
	System.out.println(matchesDemo("15123027845", "1[359]\\d{9}"));
    }
    
    /** 
    * @Title: matchesDemo 
    * @Description: TODO  �ù���regeƥ���ַ���s
    * @param s ��Ҫƥ����ַ���
    * @param rege �������
    * @return boolean
    * @throws 
    */
    public static boolean matchesDemo(String s,String rege) {
	return s.matches(rege);
    }
    
    


}





