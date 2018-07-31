package priv.rsl.collection_list_set;
import java.util.*;
/*
|--Set:Ԫ�������򣨴����ȡ����˳��һ��һ�£���Ԫ�ز������ظ���
	|--HashSet:�ײ����ݽṹ�ǹ�ϣ��
			**HashSet�ص�**(����1)HashSet����α�֤Ԫ�ص�Ψһ�Ե��أ�
			��ͨ��Ԫ�ص�����������hashCode()��equals()������������ɡ�
			�����Ԫ�ص�HashCodeֵ��ͬ���Ż��ж�equals�Ƿ�Ϊtrue
			���Ԫ�ص�HashCodeֵ��ͬ���������equals.

			ע�⣬�����ж�Ԫ���Ƿ���ڣ��Լ�ɾ���Ȳ����������ķ����ǣ�
			hashCode��equals������
			��ArrayList�жϡ�ɾ�����洢�ȷ���ֻ����equals��
			�����в�������Ϊ���ݽṹ��ͬ��

	|--TreeSet:
Set���ϵĹ��ܺ�Collection��һ�µġ�

*/

class  HashSetTest
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		HashSet hs = new HashSet();

		hs.add(new Person("a1",11));
		hs.add(new Person("a2",12));
		hs.add(new Person("a3",13));
		hs.add(new Person("a2",12));
		//hs.add(new Person("a4",14));
		
		Iterator it = hs.iterator();

		while(it.hasNext())
		{
			//ע��it�е�Ԫ����Person�Ķ��󣬶���addʱ�Ѿ�����ΪObject���ͣ�����Ҫǿת����
			Person p = (Person)it.next();
			sop(p.getName()+"::"+p.getAge());
		}
	}
	
}

class HashSetPerson
{
	private String name;
	private int age;
	HashSetPerson(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}
	
	//��ʵ�ʿ����У��漰�����࣬��Ҫ��дhashCode()��equals()����
	//��дhashCode������
	public int hashCode()
	{
		//д�����ֻ��Ϊ�˿���������hashCode����û��
		System.out.println(this.name+"...hashCode");
		
	//ע�⣬name��String�࣬Ҳ��hashCode������������ʹ��name�Լ���hashֵ��ageֵ//˵��(1)*
		return name.hashCode()+age;//Ҳ����ʹ��return �̶�Int��ֵ//˵��(2)**
	}

	//��дequals������
	public boolean equals(Object obj)
	{
		//�ж�һ�´��������ǲ���Person����
		if(!(obj instanceof Person))
			return false;

		//���ǣ�������ǿ��ת��
		HashSetPerson p = (HashSetPerson)obj;

		//��ӡһ�µ��õĹ��̣�
		System.out.println("�����ߣ�"+this.name+"��"+p.name+"�Ƚ�");

		if(this.name.equals(p.name) && this.age == p.age)
			System.out.println("�ҵ�Ŀ��Ԫ�أ�"+this.name+"..."+this.age+"\n");
		

		//�Ƚ�ĳһ��������������������
		return this.name.equals(p.name) && this.age == p.age; 
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
}

/*
˵��(1)*+˵��(2)**:
Ϊʲô����ʹ��return 60����������������
��Ϊ��Ҫ����**(����1)��
����֪������hashCode()���ع̶�������ֵ����ÿ�ζ�Ҫ����equals������Ч�ʾͺܵ�
���ԣ����ض������һЩ�Ƚ����Ե�HashCodeֵ���м�����ֵ�������Ч��
ֻ������������ͬ�ıȽ϶���ʱ�Ż����equals������


���н����

a1...hashCode
a2...hashCode
a3...hashCode
a2...hashCode
�����ߣ�a2��a2�Ƚ�
�ҵ�Ŀ��Ԫ�أ�a2...12

a1::11
a2::12
a3::13

���Կ�����������ʹ��return name.hashCode()+age;���ĺô����Ǳ�֤�˹�ϣֵ��Ψһ��
����ֻ��Ҫ�ȽϺ��ٴ�����
�����Կ�����HashSet���ص���ǵ���add������ʱ���õ�Ԫ�صĹ�ϣֵ��
�������ǿ��Կ��ƹ�ϣֵ�������Ƿ����equals��
��a2��ӽ�����ʱ�򣬻�ȡ���Ĺ�ϣֵ��֮ǰ��a2һ����������equals������
*/
