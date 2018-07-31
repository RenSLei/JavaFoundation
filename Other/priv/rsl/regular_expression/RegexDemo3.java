package priv.rsl.regular_expression;

/*
正则表达式的弊端：
符号定义越多，正则越长，阅读性越差
*/

/**
 * @ClassName: RegexDemo3
 * @Description: TODO 用规则切割字符串
 * @author rsl
 * @date 2018年1月27日 下午3:27:30
 * 
 */
class RegexDemo3 {
    public static void main(String[] args) throws Exception {
	// splitDemo("zhangsan lisi wangwu"," +");//String reg = " +";按照多个空格来进行切割
	// splitDemo("c:\\abc\\a.txt","\\\\");//一个\\表示正则表达式里的一个\所以要用\\去切必须\\\\

	// 特殊：特殊组合：捕获组用()，引用用\,但是在字符串里\要写成\\
	// 要求：用叠词去切割，即只要是叠词就切
	splitDemo("fskkgdkkdfgjjgdiis", "(.)\\1+");
	/*
	 * (.)表示一个任意字符组，\1+表示引用第一个组的结果至少一次 这就是重用规则的结果，()表示一个组，组的出现有编号 1表示引用第一个组
	 */
    }

    public static void splitDemo(String str, String reg) {
	String[] arr = str.split(reg);// 表示将字符串str作用到用reg写的规则，
	for (String s : arr) {
	    System.out.println(s);
	}

    }
}
