package priv.rsl.map;
/*
Map 扩展知识。
map集合被使用是因为具备映射关系

背景：一个学校有很多班级，每个班级对应很多学生
大的集合Map:<班名，班级<xuehao,xingming>>
小的Map集合：班级<xuehao,xingming>



*/


import java.util.*;
class  MapDemo3
{
	public static void main(String[] args) 
	{
		//创建大的Map集合，里面的值又是一个小的Map集合
		HashMap<String,HashMap<String,String>> czbk = new HashMap<String,HashMap<String,String>>();

		HashMap<String,String> yure = new HashMap<String,String>();

		HashMap<String,String> jiuye = new HashMap<String,String>();

		//建立学校和班级之间的映射关系
		czbk.put("yureban",yure);
		czbk.put("jiuyeban",jiuye);

		//往每个班里存学号和姓名
		yure.put("01","zhangsan");
		yure.put("02","lisi");

		jiuye.put("01","zhaoliu");
		jiuye.put("02","wangwu");

		//取出czbk所有的学生：遍历czbk集合，获取所有的教室（键）：
		Iterator<String> it = czbk.keySet().iterator();

		while(it.hasNext())
		{
			String roomName = it.next();
			HashMap<String,String> room = czbk.get(roomName);
			
			System.out.println(roomName);
			getStudentInfo(room);//相当于循环遍历
		}

	}

	//此方法：已知教室名称来打印该教室的学号和姓名
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
结果：
jiuyeban
01:zhaoliu
02:wangwu
yureban
01:zhangsan
02:lisi

*/
