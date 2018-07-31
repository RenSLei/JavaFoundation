package priv.rsl.map;
/*
��ϰ��
"sfsdhkghkdfjgldaj"��ȡ�ַ����е���ĸ���ֵĴ�����

ϣ����ӡ�Ľ���ǣ�a(1)b(3)c(����)...

ͨ��������֣�ÿһ����ĸ���ж�Ӧ�Ĵ�����
˵����ĸ�ʹ���֮�䶼��ӳ���ϵ��

ע�⣺��������ӳ���ϵʱ������ѡ��map���ϡ�
��ΪMap�����д�ŵľ���ӳ���ϵ��

ʲôʱ��ʹ��map�����أ�
������֮�������ӳ���ϵʱ����Ҫ���뵽map���ϡ�

˼·��
1�����ַ���ת�����ַ����顣��ΪҪ��ÿһ����ĸ���в�����
2������һ��map���ϣ���Ϊ��ӡ�������ĸ��˳������ʹ��treemap���ϡ�

3�������ַ����飺
	��ÿһ����ĸ��Ϊ��ȥ��map����
	�������null,������ĸ��1���뵽map������
	������Ƿ���null��˵������ĸ��map�������Ѿ����ڲ��ж�Ӧ�Ĵ���
	��ô�ͻ�ȡ�ô���������������Ȼ�󽫸���ĸ��������Ĵ������뵽map������
	���ǵ���ԭ����Ӧ��ֵ
4����map�����е����ݱ��ָ�����ַ�����ʽ���ء�
*/

import java.util.*;
class  MapTest3
{
	public static void main(String[] args) 
	{
		String str = charCount("ab,=fgsg+++=-abfdsjkfahaibdsb");
		System.out.println(str);
	}

	public static String charCount(String str)
	{
		char[] chs = str.toCharArray();

		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();

		int count = 0;
		for(int x=0;x<chs.length;x++)
		{
			//��������ĸʱ����ѭ������ִ��
			if(!(chs[x]>='a'&&chs[x]<='z'||chs[x]>='A'&&chs[x]<='Z'))
				continue;
			Integer vaule = tm.get(chs[x]);
			
			if(vaule!=null)
				count = vaule;
				count++;
				tm.put(chs[x],count);
				count = 0;
			
		}

//����øü���ȡ����Ԫ���ǰ��չ涨����ʽ��ӡ���أ�������ʾ��

		StringBuilder sb = new StringBuilder();//�û�����StringBuilder������Ҫ��ȡ���ַ�

		//Map�����ǳɶԴ���ģ�����Ҫ�Ѽ���ֵһ��ȡ������keySet��entrySetz���ַ�ʽ
		Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();

		while(it.hasNext())
		{
			Map.Entry<Character,Integer> me = it.next();
			Character chr = me.getKey();
			Integer value = me.getValue();
			sb.append(chr+"("+value+")");
		}

		//System.out.println(tm);
		return sb.toString();//�˺�����String���͵�
	}

	
}
