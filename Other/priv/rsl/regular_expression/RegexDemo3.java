package priv.rsl.regular_expression;

/*
������ʽ�ı׶ˣ�
���Ŷ���Խ�࣬����Խ�����Ķ���Խ��
*/

/**
 * @ClassName: RegexDemo3
 * @Description: TODO �ù����и��ַ���
 * @author rsl
 * @date 2018��1��27�� ����3:27:30
 * 
 */
class RegexDemo3 {
    public static void main(String[] args) throws Exception {
	// splitDemo("zhangsan lisi wangwu"," +");//String reg = " +";���ն���ո��������и�
	// splitDemo("c:\\abc\\a.txt","\\\\");//һ��\\��ʾ������ʽ���һ��\����Ҫ��\\ȥ�б���\\\\

	// ���⣺������ϣ���������()��������\,�������ַ�����\Ҫд��\\
	// Ҫ���õ���ȥ�и��ֻҪ�ǵ��ʾ���
	splitDemo("fskkgdkkdfgjjgdiis", "(.)\\1+");
	/*
	 * (.)��ʾһ�������ַ��飬\1+��ʾ���õ�һ����Ľ������һ�� ��������ù���Ľ����()��ʾһ���飬��ĳ����б�� 1��ʾ���õ�һ����
	 */
    }

    public static void splitDemo(String str, String reg) {
	String[] arr = str.split(reg);// ��ʾ���ַ���str���õ���regд�Ĺ���
	for (String s : arr) {
	    System.out.println(s);
	}

    }
}
