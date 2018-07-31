package priv.rsl.treeSet_generic;
import java.util.*;

/*
�����޶�

*/



/*�ȿ�ͨ���<?>����ȱ�㣺

class GenericDemo6
{
	public static void main(String[] args) 
	{
		//��������ArrayList���ϣ����Ƿֱ�������Ϸ�����ָ��������������
		ArrayList<String> al1 = new ArrayList<String>();

		al1.add("abc1");
		al1.add("abc2");

		ArrayList<Integer> al2 = new ArrayList<Integer>();

		al2.add(1);
		al2.add(3);
		al2.add(5);

		//���õ�����������������String���ArrayList
		printColl(al1);//������������ָ����String���͵�ʱ�򣬴���al2�ͻ�������
	}

	
	//˵��1
	public static void printColl(ArrayList<?> al)
	{
		Iterator<String> it = al.iterator();

		while (it.hasNext())
		{
			System.out.println(it.next());//
		}
	}
}

/*
˵��1��
printColl(ArrayList<?> al)

<?>:?����ͨ�����Ҳ�������Ϊռλ������˼�ǲ�֪�������洫�ݵ�����������ʲô��
�����ȿ��Դ���String��Ҳ���Դ���Integer��

���Ǿ��о����ԣ��磺����ʹ���������з�����
�磺System.out.println(it.next().length())��ΪInteger����û��length����
�����̬һ������Ȼ�������չ�ԣ����ǲ���Ԥ��ʹ���������з�����


*/

//���潲�ⷺ���޶���

class GenericDemo6
{
	public static void main(String[] args) 
	{
		//��������ArrayList���ϣ����Ƿֱ�������Ϸ�����ָ��������������
		ArrayList<Person> al1 = new ArrayList<Person>();

		al1.add(new Person("abc1"));
		al1.add(new Person("abc2"));
		al1.add(new Person("abc3"));

		ArrayList<Student6> al2 = new ArrayList<Student6>();
		
		al2.add(new Student6("abc--1"));
		al2.add(new Student6("abc--2"));
		al2.add(new Student6("abc--3"));
		
		//���õ�����������������String���ArrayList
		printColl(al2);//˵��2
	}

	

	public static void printColl(ArrayList<? extends Person> al)
	{
		Iterator<? extends Person> it = al.iterator();

		while (it.hasNext())
		{
			System.out.println(it.next());//
		}
	}
}

class Person
{
	private String name;
	Person(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}

class Student6 extends Person
{
	Student6(String name)
	{
		super(name);
	}
}




/*
˵��2��
�������ǣ�printColl(ArrayList<Person> al)
ʱ�������洫�ݵ���printColl(al2)�����ݵ���Student�࣬����ͻ����

�������printColl(ArrayList<?> al)�Ļ�������˼��ʲô���Ͷ����Դ��ݣ�����ʱ
���ǵ�������ֻ�����Person���Լ������࣬����ô�죿
������������˷����޶�����printColl(ArrayList<? extends Person> al)

<? super Student>Ҳ����

�����޶���
? extends E:���Խ���E�����Լ��������͡�����
? super E:���Խ���E�����Լ��丸���͡�����





�����޶�2��
��ʹ��terrSet���ϵ�ʱ���Զ���Ƚ���ʵ��comparator�ӿڵ�ʱ��
ʹ����classs myComp implements Comparator<����> �ĺô��ǿ����ô˱Ƚ���������
���༰�����࣬��ǰ���ǱȽ���������õ��Ǹ���ķ�����
*/
