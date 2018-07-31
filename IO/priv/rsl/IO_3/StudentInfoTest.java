package priv.rsl.IO_3;
/*
练习：

有五个学生，每个学生有3门课的成绩
从键盘输入以上数据（包括姓名，三门课程成绩）
输入的格式：如zhangsan ,20,40,60,计算出总成绩
并把学生的信息和计算出的总分数高低顺序存放在磁盘文件“stud.txt”中

1，描述学生对象
2，定义一个可以操作学生对象的工具类

思想：
1，通过键盘录入的获取一行数据，并将该行中的信息取出封装成学生对象
2，存储学生对象，用到集合，而且需要排序，所以用TreeSet集合
3，将集合的信息写入到一个文件中。


*/

import java.io.*;
import java.util.*;

class Student implements Comparable<Student>
{
	private String name;
	private int ma,cn,en;
	private int sum;

	Student(String name , int ma,int cn,int en)
	{
		this.name = name;
		this.ma = ma;
		this.cn = cn;
		this.en = en;
		sum = ma+cn+en;
	}
	
	//复写comparerTo方法实现自定义比较
	public int compareTo(Student s)
	{
		int num = new Integer(this.sum).compareTo(new Integer(s.sum));

		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}

	public String getName()
	{
		return name;
	}

	public int getSum()
	{
		return sum;
	}

	public int hashCode()
	{
		return name.hashCode()+sum*76;
	}

	//复写equals方法
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("类型不匹配");
		Student s = (Student)obj;
		return this.name.equals(s.name)&& this.sum==s.sum;
	}

	public String toString()
	{
		return "student["+name+","+ma+","+cn+","+en+"]";
	}
}

class StudentInfoTool
{
	//对外提供两个方法：一个按照总分的自然顺序（低到高）
	public static Set<Student> getStudents() throws IOException
	{
		return getStudents(null);
	}


	public static Set<Student> getStudents(Comparator<Student> comp) throws IOException
	{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));

		String line = null;
		Set<Student> stus =null; 

		if(comp==null)
			stus = new TreeSet<Student>();
		else stus = new TreeSet<Student>(comp);

		while((line = bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;

			String[] info = line.split(",");

			Student stu = new Student(info[0],Integer.parseInt(info[1]),
											Integer.parseInt(info[2]),
											Integer.parseInt(info[3]));

			stus.add(stu);
		}
		bufr.close();

		return stus;
	}

	public static void write2File(Set<Student> stus)throws IOException
	{
		BufferedWriter bufw = new BufferedWriter(new FileWriter("stuinfo.txt"));

		for(Student stu : stus)
		{
			bufw.write(stu.toString()+"\t");
			bufw.write(stu.getSum()+"");

			//换行
			bufw.newLine();
			bufw.flush();

		}
		bufw.close();

	}

}
class StudentInfoTest 
{
	public static void main(String[] args) throws IOException
	{
		Comparator<Student> comp = Collections.reverseOrder();

		Set<Student> stus = StudentInfoTool.getStudents(comp);

		StudentInfoTool.write2File(stus);
		
	}
}
