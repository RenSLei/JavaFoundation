package priv.rsl.map;
 /*
Map���ϣ��ü��ϴ洢��ֵ�ԡ�һ��һ��������档����Ҫ��֤����Ψһ�ԡ�

1�����
	put(K key , V value)��ָ����ֵ���ӳ���е�ָ������������ѡ��������

2,ɾ��
	clear()�Ӵ�ӳ�����Ƴ�����ӳ���ϵ����ѡ��������
	remove(Object key) �������һ������ӳ���ϵ������Ӵ�ӳ�����Ƴ�����ѡ��������

3���ж�
	containsKey(Object key)�����ӳ�����ָ������ӳ���ϵ���򷵻� true��
	containsValue(Object value)�����ӳ�佫һ��������ӳ�䵽ָ��ֵ���򷵻� true��
	isEmpty()�����ӳ��δ������-ֵӳ���ϵ���򷵻� true��

4����ȡ��
	get(Object key) ����ָ������ӳ���ֵ�������ӳ�䲻�����ü���ӳ���ϵ���򷵻� null��
	size() ���ش�ӳ���еļ�-ֵӳ���ϵ����
	values() ���ش�ӳ���а�����ֵ�� Collection ��ͼ��

--------
�ص����ݣ�
	entrySet() 
          ���ش�ӳ���а�����ӳ���ϵ�� Set ��ͼ��
	keySet() 
          ���ش�ӳ���а����ļ��� Set ��ͼ��

Map
	|--Hashtable���ײ��ǹ�ϣ�����ݽṹ�������Դ���null��nullֵ���ü������߳�ͬ���ġ�JDK1.0Ч�ʵ�
	|--HashMap���ײ��ǹ�ϣ�����ݽṹ������ʹ��nullֵ��null�����ü����ǲ�ͬ���ġ�JDK1.2Ч�ʸ�
	|--TreeMap:�ײ��Ƕ��������ݽṹ���̲߳�ͬ�����������ڸ�Map�����еļ���������

��Set����
��ʵ��Set�ײ����ʹ����Map���ϡ�


*/



import java.util.*;
class  MapDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		Map<String,String> map = new HashMap<String,String>();

		//���Ԫ��
		map.put("01","zhangsan1");
		sop(map.put("01","wangwu"));//������������ͬ�ļ�������ӵ�ֵ�Ḳ��ԭ�м���Ӧ��ֵ�����᷵��ԭ�б��滻��ֵ���ؼ���һ�㣬ע�⣩
		map.put("02","zhangsan2");
		map.put("03","zhangsan3");

		sop("containsKey:"+map.containsKey("022"));//�ж�	
		//sop("remove:"+map.remove("02"));//ɾ��
		

		sop("get:"+map.get("03"));

		//HashMap�ǿ�����null������ֵ���ڵ�
		map.put("04",null);
		sop(map.get("04"));
		
		//��ȡmap���������е�ֵ
		Collection<String> coll = map.values();
		sop(coll);
		sop(map);//��ӡmap



	
	}
}
/*
zhangsan1
containsKey:false
get:zhangsan3
null
[wangwu, zhangsan2, zhangsan3, null]
{01=wangwu, 02=zhangsan2, 03=zhangsan3, 04=null}

*/
