package priv.rsl.map;
/*
��MapDemo3�Ĳ���֪ʶ��

������һ��ѧУ�кܶ�༶��ÿ���༶��Ӧ�ܶ�ѧ��
��ļ���Map:<�������༶<xuehao,xingming>>
С��Map���ϣ��༶<xuehao,xingming>

���󼯺��е�ֵ�����ң���list���ϴ��棬�����Ƿ�װ�õ�ѧ�������





*/


import java.util.*;

class Student
{
	private String id;
	private String name;
	Student(String id,String name)
	{
		this.id = id;
		this.name = name;
	}

	public String toString()
	{
		return id+"::"+name;
	}
}
class  MapDemo4
{
	public static void main(String[] args) 
	{
		HashMap<String,List<Student>> czbk = new HashMap<String,List<Student>>();
		
		List<Student> yure = new ArrayList<Student>();
		List<Student> jiuye = new ArrayList<Student>();

		czbk.put("yureban",yure);
		czbk.put("jiuyeban",jiuye);

		yure.add(new Student("01","zhangsan"));
		yure.add(new Student("02","lisi"));
		jiuye.add(new Student("01","wangwu"));
		jiuye.add(new Student("02","zhaoliu"));


		//ȡ��czbk���е�ѧ��������czbk���ϣ���ȡ���еĽ��ң�������
		Iterator<String> it = czbk.keySet().iterator();

		while(it.hasNext())
		{
			String roomName = it.next();
			List<Student> room = czbk.get(roomName);
			
			System.out.println(roomName);
			getStudentInfo(room);//�൱��ѭ������
		}

	}

	//�˷�������֪������������ӡ�ý��ҵ�ѧ�ź�����
	public static void getStudentInfo(List<Student> list)
		{
			Iterator <Student> it = list.iterator();

			while(it.hasNext())
			{
				Student s = it.next();
				System.out.println(s);
			}
		}

}

/*
�����
jiuyeban
01::wangwu
02::zhaoliu
yureban
01::zhangsan
02::lisi

*/
