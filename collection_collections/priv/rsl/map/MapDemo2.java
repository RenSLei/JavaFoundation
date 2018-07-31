package priv.rsl.map;
/*
��ν����еļ���ֵȫ��ȡ������

map���ϵ�����ȡ����ʽ��
1��Set<k> KeySet:��map�����еļ����뵽Set�����С���Ϊset�߱���������
	�����õ����ķ�ʽȡ�����еļ����ٸ���get������ȡÿһ������Ӧ��ֵ��
	
	Map���ϵ�ȡ��ԭ����map����ת��set���ϡ���ͨ��������ȡ����

2��Set<Map.Entry<K,V>> entrySet����map�����е�ӳ���ϵ���뵽��set�����У�
			�������ϵ���������;��ǣ�map.Entry����ʵ��һ���ӿڣ�

*/
import java.util.*;
class MapDemo2
{
	public static void main(String[] args) 
	{
		Map<String,String>map = new HashMap<String,String>();
		
		map.put("02","zhangsan2");
		map.put("01","zhangsan1");
		map.put("03","zhangsan3");
		map.put("04","zhangsan4");
		//==========ʹ�÷�������ʹ��entrySet();=====
		//��map�����е�ӳ���ϵȡ�������뵽Set�����С�
		Set<Map.Entry<String,String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String,String>> it = entrySet.iterator();

		while(it.hasNext())
		{
			Map.Entry<String,String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}


		/*

		=======ʹ�÷���һ����KeySet();=======
		//�Ȼ�ȡmap���ϵ����м���Set���ϣ���KeySet();
		Set<String> keySet = map.keySet();

		//�����浽��set�������棬�Ϳ��Ի�ȡ�������
		Iterator<String> it = keySet.iterator();

		while(it.hasNext())
		{
			String key = it.next();
			String value = map.get(key);
			System.out.println("key:"+key+",value:"+value);
		}
		*/
	}
}
/*
����һ���н����
key:01,value:zhangsan1
key:02,value:zhangsan2
key:03,value:zhangsan3
key:04,value:zhangsan4

���������н����
01:zhangsan1
02:zhangsan2
03:zhangsan3
04:zhangsan4

*/
