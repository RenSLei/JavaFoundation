
package priv.rsl.regular_expression;

/**
 * @ClassName: RegexDemo4
 * @Description: TODO 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串
 * @author rsl
 * @date 2018年1月27日 下午4:20:50
 * 
 */
public class RegexDemo4 {

    public static void main(String[] args) {

	// 将字符串的连续5个数字以上替换成#。
	// String str = "fsjdkghkjs49354396743nkgkdagh35345kjh5";
	// replaceAllDemo(str,"\\d{5,}","#");

	// 将叠词替换成单个字符。
	String str1 = "dfkkkgdsgllasdhh";
	// $1第一个匹配分组内的内容，正则表达式中第一对圆括号中的表达式匹配到的内容
	replaceAllDemo(str1, "(.)\\1+", "$1");
	// 结果：dfkgdsglasdh

    }

    /** 
    * @Title: replaceAllDemo 
    * @Description: TODO  
    * @param @param str 原字符串
    * @param @param reg 规则
    * @param @param newStr 匹配到的字符
    * @return void
    * @throws 
    */
    public static void replaceAllDemo(String str, String reg, String newStr) {
	// 将字符串中符合reg规则的子串用newStr去替换
	str = str.replaceAll(reg, newStr);
	System.out.println(str);
    }

}
