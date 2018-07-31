package priv.rsl.map;

/*
需求1：对学生对象的年龄进行升学排序。
将这个.java文件放在含Student类的一个文件夹下，就可以用到这个Student.class文件了。
为什么可以让输出的数据是按学生年龄排序？就是因为学生类自身具备比较性，即按照年龄来排序。

所以在描述一个类的时候要考虑到他的对象是存入的什么类型的集合:
存在hash表中就要复写hashCode以及equals方法，存到二叉树中就要实现Comparable接口,以防止出现异常。


因为数据是以键值对形式存在的。
所以要使用可以排序的Map集合。TreeMap。


需求2：对学生对象的姓名进行比较排序，取出来。
分析：Studentl类自身的比较性是按照年龄的顺序来排序的，所以得重新定义一个比较器类来实现Comparator
然后将该类的对象传给TreeMap

*/

import java.util.*;
//重新定义一个比较器类来实现Comparator然后将该类的对象传给TreeMap

class StuNameComparator implements Comparator<Student2>
{
	public int compare(Student2 s1,Student2 s2)
	{
		int num = s1.getName().compareTo(s2.getName());
		if (num==0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		return num;
	}
}
class  MapTest2
{
	public static void main(String[] args) 
	{
		//如果不传new StuNameComparator()，则TreeMap还是按照原来的Student自身的比较属性来排序的
		TreeMap<Student2,String> tm = new TreeMap<Student2,String>(new StuNameComparator());

		tm.put(new Student2("lisi2",21),"beijing");
		tm.put(new Student2("blisi",26),"shanghai");
		tm.put(new Student2("lisi",24),"nanjing");
		tm.put(new Student2("alisi",25),"chengdu");

		Set<Map.Entry<Student2,String>> entrySet = tm.entrySet();

		Iterator<Map.Entry<Student2,String>> it = entrySet.iterator();

		while(it.hasNext())
		{
			Map.Entry<Student2,String> me = it.next();
			Student2 stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu+"..."+addr);
		}
	}
}
