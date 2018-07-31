package priv.rsl.collection_list_set;
import java.util.*;
/*
���Զ��������ΪԪ�ش浽ArrayList�����У���ȥ���ظ�Ԫ�ء�

���磺���˶���ͬ����ͬ���䣬��Ϊͬһ���ˡ�Ϊ�ظ�Ԫ�ء�

˼·��
1�����˵������������ݷ�װ�������
2���������������˴��롣
3��ȡ����
*/

class Person
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}
//ʵ�ʿ��������У�ҪдsetName��setAge�����������ù��캯���Զ�����г�ʼ����
	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	//�ײ���˵������дObject��equals������ʹ�Ƚϸ��Ի�
	public boolean equals(Object obj)
	{
		//�ж�һ�´��������ǲ���Person����
		if(!(obj instanceof HashSetPerson))
			return false;

		//���ǣ�������ǿ��ת��
		Person p = (Person)obj;

		//��ӡһ�µ��õĹ��̣�
		System.out.println("�����ߣ�"+this.name+"��"+p.name+"�Ƚ�");

		if(this.name.equals(p.name) && this.age == p.age)
			System.out.println("�ҵ�Ŀ��Ԫ�أ�"+this.name+"..."+this.age+"\n");
		

		//�Ƚ�ĳһ��������������������
		return this.name.equals(p.name) && this.age == p.age; 
	}
	
}

class  ArrayListTest2
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
//ע�⣬add�����ǣ�al.add(Object obj);�൱��Object obj = new Person("lisi01",30));
//�����ܵ�Ԫ�����������;�Ҫ��Object��������
		al.add(new HashSetPerson("lisi01",31));
		al.add(new HashSetPerson("lisi02",32));
		al.add(new HashSetPerson("lisi01",31));
		al.add(new HashSetPerson("lisi03",33));
		al.add(new HashSetPerson("lisi02",32));
		al.add(new HashSetPerson("lisi04",34));

		al = singleElement(al);
		//sop("remove lisi04Ϊ���𣿣�"+al.remove(new Person("lisi04",34)));

		Iterator it = al.iterator();//ʹ�õ�����������al�е�Ԫ��

		sop("\nȥ���ظ���������");
		while(it.hasNext())
		{
			//ע��it�е�Ԫ����Person�Ķ��󣬶���addʱ�Ѿ�����ΪObject���ͣ�����Ҫǿת����
			HashSetPerson p = (HashSetPerson)it.next();
			sop(p.getName()+"::"+p.getAge());
		}
	}

//ʹ��ȥ�ظ�������ȥ����ͬ���˶���
	public static ArrayList singleElement(ArrayList al)
	{
		//����һ����ʱ����,��������޸ĺ�����ݣ�������
		ArrayList newAl = new ArrayList();
		
		//Ϊ�˱�����������������Ԫ�أ�ʹ�õ�����Iterator
		Iterator it = al.iterator();

		//ʹ��hasNext()��next������contatins����
		while (it.hasNext())
		{
			Object obj = it.next();

			if(!newAl.contains(obj))//��˵��
				newAl.add(obj);
		}
		return newAl;
	}
}
/*
ע��
û����дequals������ʱ���ǲ��ܴﵽȥ���ظ��˶����Ч���ġ�
��ΪsingleElement(ArrayList al)������ıȽϷ���������˵����contains������
��contains����ʵ�����ǵ��õ�equals������
boolean contains(Object o)
���ҽ����б�������� (o==null ? e==null : o.equals(e)) ��Ԫ�� e ʱ�ŷ��� true��
������֪��equals�������ڱȽ϶����ǱȽϵĵ�ַַ
���ԱȽ���������new Person���󶼻�Ϊ�١������ص�newAl��ԭ����һ����

��ʱ������Ҫ��дequals������ʵ������ıȽϹ��ܡ�

���н����
�����ߣ�lisi02��lisi01�Ƚ�
�����ߣ�lisi01��lisi01�Ƚ�
�ҵ�Ŀ��Ԫ�أ�lisi01...31

�����ߣ�lisi03��lisi01�Ƚ�
�����ߣ�lisi03��lisi02�Ƚ�
�����ߣ�lisi02��lisi01�Ƚ�
�����ߣ�lisi02��lisi02�Ƚ�
�ҵ�Ŀ��Ԫ�أ�lisi02...32

�����ߣ�lisi04��lisi01�Ƚ�
�����ߣ�lisi04��lisi02�Ƚ�
�����ߣ�lisi04��lisi03�Ƚ�

ȥ���ظ���������
lisi01::31
lisi02::32
lisi03::33
lisi04::34



���⣬����  al = singleElement(al);ע�͵�
����  sop("remove lisi04Ϊ���𣿣�"+al.remove(new Person("lisi04",34)));
���н����
�����ߣ�lisi04��lisi01�Ƚ�
�����ߣ�lisi04��lisi02�Ƚ�
�����ߣ�lisi04��lisi01�Ƚ�
�����ߣ�lisi04��lisi03�Ƚ�
�����ߣ�lisi04��lisi02�Ƚ�
�����ߣ�lisi04��lisi04�Ƚ�
�ҵ�Ŀ��Ԫ�أ�lisi04...34

remove lisi04Ϊ���𣿣�true

ȥ���ظ���������
lisi01::31
lisi02::32
lisi01::31
lisi03::33
lisi02::32

���Կ���remove Ҳ�ǵ��õ�equals����
*/
