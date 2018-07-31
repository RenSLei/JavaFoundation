package priv.rsl.regular_expression;

/*
----------必须掌握----------

需求：对邮件地址进行校验

*/

/**
 * @ClassName: RegexTest2
 * @Description: TODO 校验邮箱地址
 * @author rsl
 * @date 2018年1月27日 下午5:25:29
 * 
 */
class RegexTest2 {
    public static void main(String[] args) throws Exception {
	String mail = "abc12@sina.com";

	String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3})+";// 较为精确的匹配

	reg = "\\w+@\\w+(\\.\\w+)+";// 相对不太精确的匹配

	System.out.println(mail.matches(reg));

    }

}
