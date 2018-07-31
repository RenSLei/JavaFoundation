/**   
* @Title: RegexDemo2.java 
* @Package priv.rsl.basal.day25 
* @Description: TODO 正则表达式
* @author rsl
* @date 2018年1月27日 下午2:06:11 
* @version V1.0   
*/
package priv.rsl.regular_expression;

/** 
* @ClassName: RegexDemo2 
* @Description: TODO  正则——匹配matches
* @author rsl
* @date 2018年1月27日 下午2:06:11 
*  
*/
public class RegexDemo2 {

    /** 
    * @Title: main 
    * @Description: TODO 调用matchesDemo方法  
    * @param args
    * @return void
    * @throws Exception
    */
    public static void main(String[] args) throws Exception{
//	匹配一个电话号码，需求是以1开头，第二位是3或5或9.
	System.out.println(matchesDemo("15123027845", "1[359]\\d{9}"));
    }
    
    /** 
    * @Title: matchesDemo 
    * @Description: TODO  用规则rege匹配字符串s
    * @param s 需要匹配的字符串
    * @param rege 正则规则
    * @return boolean
    * @throws 
    */
    public static boolean matchesDemo(String s,String rege) {
	return s.matches(rege);
    }
    
    


}





