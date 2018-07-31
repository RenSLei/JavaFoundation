package priv.rsl.map;
/*
Map ��չ֪ʶ��
map���ϱ�ʹ������Ϊ�߱�ӳ���ϵ

������һ��ѧУ�кܶ�༶��ÿ���༶��Ӧ�ܶ�ѧ��
��ļ���Map:<�������༶<xuehao,xingming>>
С��Map���ϣ��༶<xuehao,xingming>



*/


import java.util.*;
class  MapDemo3
{
	public static void main(String[] args) 
	{
		//�������Map���ϣ������ֵ����һ��С��Map����
		HashMap<String,HashMap<String,String>> czbk = new HashMap<String,HashMap<String,String>>();

		HashMap<String,String> yure = new HashMap<String,String>();

		HashMap<String,String> jiuye = new HashMap<String,String>();

		//����ѧУ�Ͱ༶֮���ӳ���ϵ
		czbk.put("yureban",yure);
		czbk.put("jiuyeban",jiuye);

		//��ÿ�������ѧ�ź�����
		yure.put("01","zhangsan");
		yure.put("02","lisi");

		jiuye.put("01","zhaoliu");
		jiuye.put("02","wangwu");

		//ȡ��czbk���е�ѧ��������czbk���ϣ���ȡ���еĽ��ң�������
		Iterator<String> it = czbk.keySet().iterator();

		while(it.hasNext())
		{
			String roomName = it.next();
			HashMap<String,String> room = czbk.get(roomName);
			
			System.out.println(roomName);
			getStudentInfo(room);//�൱��ѭ������
		}

	}

	//�˷�������֪������������ӡ�ý��ҵ�ѧ�ź�����
	public static void getStudentInfo(HashMap<String,String> roomMap)
		{
			Iterator <String> it = roomMap.keySet().iterator();

			while(it.hasNext())
			{
				String  id = it.next();
				String name = roomMap.get(id);
				System.out.println(id+":"+name);
			}
		}

}
/*
�����
jiuyeban
01:zhaoliu
02:wangwu
yureban
01:zhangsan
02:lisi

*/
