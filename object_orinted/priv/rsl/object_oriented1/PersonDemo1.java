package priv.rsl.object_oriented1;
/*

*/

class Person1
{
	private String name;//��������һ
	private int age;//�������Զ�
/*
���湹�����飺

���ã���������г�ʼ����
����һ���������У����������ڹ��캯��ִ�С�

�͹��캯�������𣺹��������Ǹ����ж������ͳһ��ʼ����
�����캯���Ǹ���Ӧ�Ķ����ʼ����
*/
	{
		System.out.println("person code run");
		cry();/*�����ж���Ĺ��Եĳ�ʼ�����ڹ��������У�
		        ������ÿ���¶�������ʱ����������һ��������������е����ݣ�*/
	}

	//���涨�幹�캯��
	Person1()//���캯��һ
	{
		System.out.println("A:name="+name+",,age="+age+",,");
		//cry();
	}
	Person1(String n)//���캯���������أ�
	{
		name = n;
		System.out.println("B:name="+name+",,age="+age+",,");
		//cry();
	}

	Person1(String n,int a)//���캯���������أ�
	{
		name=n;
		age=a;
		System.out.println("C:name="+name+",,age="+age+",,");
		//cry();
	}
	//���Կ���һ�����п��Զ��������󣬶�ÿ����������в�ͬ�ĳ�ʼ��ֵ��
	/*
	���ں�����Ҫ�ı�����г�Ա�ĳ�ʼ��ֵ��ʱ����ô�죿�ѵ�new Person("����")�����У�������½���һ��������Ķ���
	��θı�ԭ����ĳ�Աֵ�������ǣ�setName�����ڸ�ֵ��getName������ȡֵ��
	*/
	public void setName(String n)
	{
		name=n;
	}
	public String getName()
	{
		return name;
	}
	//���붨�����һ�㷽��ʱ�������ڶ��巽��������ֱ�ӱ��������ã�δ��װ��
	public void cry()//һ�㺯����
	{
        System.out.println("cry......");
	}
}




class PersonDemo1 
{
	public static void main(String[] args) 
	{
		new Person1();
		new Person1("����");
		new Person1("����",10);//����������ֻ����һ�ι��캯������
		//p3.age=0;//�����������Ϊʲô����Ϊage�������з�װȨ�޵ģ�ֻ��ͨ�����캯���ı䡣
		//p1.cry();//���������ԣ���Ϊcry��public�͡�
		//p3.setName("����");//���¸�p3�����г�Ա����
		//System.out.println(p3.getName());//��ȡ�ı���ֵ����ӡ
	}
}
