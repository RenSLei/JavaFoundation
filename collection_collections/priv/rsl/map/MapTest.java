package priv.rsl.map;

/*
Map练习： 
本篇练习使用Map集合（键和值成对的存入方式），将学生作为键，将地址作为值存入。然后使用两种取出Map集合元素的方法：keySet和entrySet
1,描述学生这个类（---说明1---）。
2，定义map容器。将学生作为键，地址作为值存入。//键不要重复，值可以重复，这就要求保证唯一性复写HashCode方法和equals
3，获取map集合中的元素。


*/
import java.util.*;
class Student2 implements Comparable<Student>/*让类自身具备一个可比性，防止该类存于二叉树中*/
{
	private String name;
	private int age;
	Student2(String name,int age)
	{
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student2 s)
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}

	public int hashCode()
	{
		return name.hashCode()+age*34;
	}

	public boolean eauals(Object obj)
	{
		if(!(obj instanceof Student2))
			throw new ClassCastException("类型不匹配");

		Student2 s = (Student2)obj;

		return this.name.equals(s.name) && this.age==s.age;

	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return name+":"+age;
	}

	@Override
	public int compareTo(Student o) {
	    // TODO Auto-generated method stub
	    return 0;
	}
}

/*---以上养成习惯：当描述一个类的时候：1，要实现比较接口Comparable<泛型>接口，让类自身具备比较属性。
                                       2，要复写HashCode()和equals()方法*/
class  MapTest
{
	public static void main(String[] args) 
	{
		HashMap<Student2,String> hm = new HashMap<Student2,String>();

		hm.put(new Student2("lisi",21),"beijing");
		hm.put(new Student2("lisi",25),"shanghai");
		hm.put(new Student2("lisi",23),"nanjing");
		hm.put(new Student2("lisi",24),"chengdu");

		//第一种取出方式 keySet
		Set<Student2> keySet = hm.keySet();
		Iterator<Student2> it = keySet.iterator();

		while (it.hasNext())
		{
			Student2 stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu.getName()+":"+stu.getAge()+":"+addr);
		}

		//第二中取出方式 entrySet
		Set<Map.Entry<Student2,String>> entrySet = hm.entrySet();

		Iterator<Map.Entry<Student2,String>> iter = entrySet.iterator();

		while (iter.hasNext())
		{
			Map.Entry<Student2,String> me = iter.next();
			Student2 stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu+":"+addr);
		}

	}
}
