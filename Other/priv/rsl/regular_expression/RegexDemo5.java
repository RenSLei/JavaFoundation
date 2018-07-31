package priv.rsl.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @ClassName: RegexDemo5 
* @Description: TODO 获取：将字符串中的符合规则的子串取出  
* @author rsl
* @date 2018年1月27日 下午4:47:50 
*  
*/

/* 
 * 操作步骤：
1，将正则表达式封装成对象：Pattern p = Pattern.compile(reg);

2，让正则对象和要操作的字符相关联:

3，关联后，获取正则匹配引擎:

4，通过引擎对符合规则的子串进行操作，比如取出
*/
public class RegexDemo5 {

    public static void main(String[] args) {
	//有一个字符串：
	String str = "ming tian jiu yao fang jia le ,kai xin";
	//定义规则：只取出三个字母组成的单词
	String reg = "\\b[a-zA-Z]{3}\\b";
	/*
	\b是单词边界匹配器，
	*/

	//1、封装成Pattern对象：
	Pattern p = Pattern.compile(reg);
	/*
	注意：Pattern类没有构造方法，即他有静态方法而且返回本类对象
        public static Pattern compile(String regex)
	将给定的正则表达式编译到模式中。
	*/

	//2、将字符串和正则关联起来，即获取匹配器
	Matcher m = p.matcher(str);
	/*
        public Matcher matcher(CharSequence input)
	创建匹配给定输入与此模式的匹配器。
	返回：此模式的新匹配器
	 */

	//3、获取
	while (m.find()) {
	    System.out.println(m.group());
	    // 看看每次查找后返回匹配到的子字符串（或者左后一个字符）在字符串中的索引位置.
	    System.out.println(m.start() + "..." + m.end());
	}
	/*
	1、find()
	public boolean find()尝试查找与该模式匹配的输入序列的下一个子序列。  
	此方法从匹配器区域的开头开始，如果该方法的前一次调用成功了并且从那时开始匹配器没有被重置，
	则从以前匹配操作没有匹配的第一个字符开始。  

	2、group()
	matcher.group()返回匹配到的子字符串 

	注意：匹配器里面的matches()是全部匹配，是将整个输入串与模式匹配，
	如果要验证一个输入的数据是否为数字类型或其他类型，一般要用matches()。
		
	另：String类中的matches()就是用的Pattern和Matcher对象来完成的
	只不过被Stringd的方法封装了，用起来较为简单，但是功能单一
	*/
    }

}
