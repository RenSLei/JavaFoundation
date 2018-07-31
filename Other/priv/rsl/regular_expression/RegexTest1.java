package priv.rsl.regular_expression;

/*
练习
*/
import java.util.TreeSet;

class RegexTest1 {
    public static void main(String[] args) throws Exception {
	ipSort();
	//test_1();
    }

    /*
     * 需求：将下列字符串转成：我要学编程
     * 
     * 思路：
     * 1、字符串的正确与错误----用匹配
     * 2、已有字符串----->另一个字符串----用替换
     * 3、按照自己的方式将字符串变成多个字符串-----切割(获取规则以外的) 
     * 4、拿到符合规则的字符串-----获取，获取符合规则的子串
     * 
     */
    
    
    /** 
    * @Title: test_1 
    * @Description: TODO 去掉字符串的.以及重复字符
    * @param 
    * @return void
    * @throws 
    */
    public static void test_1() {
	// 有一个字符串：
	String str = "我我...我我...我要...要要..要要..学学学..学学..编编编..编程.程程..程程.....程";
	/*
	 * ------替换 1，将.去掉 2，再去重复
	 */

	// 1，将.去掉
	str = str.replaceAll("\\.+", "");
	// 2，再去重复
	str = str.replaceAll("(.)\\1+", "$1");

	System.out.println(str);
    }

    /*
     *将ip地址：  192.89.3.234 102.49.23.13 10.10.10.10 2.2.2.2 8.32.52.64 进行地址段顺序的排序
     * 
     * 按照字符串自然顺序，只要让它们每一段都是3位即可
     * 1，每个ip的每一段最少是一位数字。那么给每段都加两个0，保证了每一段至少都是三位数，方便排序
     * 2，将每一段只保留3位
     * 
     */

    /** 
    * @Title: ipSort 
    * @Description: TODO 排序，替换，切割的综合应用 
    * @param 
    * @return void
    * @throws 
    */
    public static void ipSort() {
	String ip = "192.89.3.234  102.49.23.13  10.10.10.10  2.2.2.2  8.32.52.64";

	// 使用替换replaceAll()
	// 将每一段前面加两个0
	ip = ip.replaceAll("(\\d+)", "00$1");

	// 将有三位有效数字的段前面的0去掉
	ip = ip.replaceAll("0*(\\d{3})", "$1");

	// 用空格去切
	String[] s = ip.split(" +");

	TreeSet<String> ts = new TreeSet<String>();

	// 遍历s添加到集合中,并排序：
	for (String str : s) {
	    ts.add(str);
	}

	for (String ip_s : ts) {
	    System.out.println(ip_s.replaceAll("0*(\\d+)", "$1"));
	}
    }
}