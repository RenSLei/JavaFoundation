/**   
* @Title: RegexDemo.java 
* @Package priv.rsl.basal.day25 
* @Description: TODO 演示正则表达式的特点：简单
* @author rsl
* @date 2018年1月27日 下午12:45:58 
* @version V1.0   
*/
package priv.rsl.regular_expression;

/**
 * @ClassName: RegexDemo
 * @Description: TODO 用正则表达式校验一个数字串
 * @author rsl
 * @date 2018年1月27日 下午12:45:58
 * 
 */

/*
 * 正则表达式： 符合一定规则的表达式。 作用：用于专门操作字符串 好处：可以简化对字符串的复杂操作。
 */
public class RegexDemo1 {

    /**
     * @Title: main @Description: TODO 校验
     * @param args main函数参数 
     * @return void 
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
	/* 需求：对数组串进行校验：不能以0开头，长度5-15位，不能包含字母 */
	String s = "32974983";
	String regex = "[1-9][0-9]{4,14}";

	boolean flag = s.matches(regex);

	if (flag)
	    System.out.println(s + " is ok");
	else
	    System.out.println(s + "不合法");
    }

}
