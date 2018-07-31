package priv.rsl.map;
/*
对MapDemo3的补充知识：

背景：一个学校有很多班级，每个班级对应很多学生
大的集合Map:<班名，班级<xuehao,xingming>>
小的Map集合：班级<xuehao,xingming>

将大集合中的值（教室）用list集合代替，参数是封装好的学生类对象





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


		//取出czbk所有的学生：遍历czbk集合，获取所有的教室（键）：
		Iterator<String> it = czbk.keySet().iterator();

		while(it.hasNext())
		{
			String roomName = it.next();
			List<Student> room = czbk.get(roomName);
			
			System.out.println(roomName);
			getStudentInfo(room);//相当于循环遍历
		}

	}

	//此方法：已知教室名称来打印该教室的学号和姓名
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
结果：
jiuyeban
01::wangwu
02::zhaoliu
yureban
01::zhangsan
02::lisi

*/
