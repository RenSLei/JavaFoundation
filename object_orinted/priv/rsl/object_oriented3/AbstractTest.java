package priv.rsl.object_oriented3;

/*
����һ��ϵͳ��Ҫ�Թ�˾Ա�����н�ģ ��Ա��������ͨԱ���;���
Ա���Ĺ�ͬ�����ǣ�1������2������3�����ʡ����⾭����һ���������ԡ�
��ʹ�ü̳е�˼����Ƴ�Ա����;����ࡣҪ�������ṩ��Ҫ�ķ����������Եķ��ʡ�

������
����Ա���ಢ������

������ͨԱ����̳�Ա���ಢ��д����

����������̳�Ա���ಢ��д����
*/

abstract class Employee
{
	private String name;

	private String id;

	private double pay;

	Employee(String name, String id, double pay)
	{
		this.name = name;
		this.id = id;
		this.pay = pay;
	}

	String getName()
	{
		return name;
	}
	String getId()
	{
		return id;
	}

	double getPay()
	{
		return pay;
	}

	public abstract void work();

	public abstract int getBonus();

}

class Pro extends Employee
{
	Pro(String name, String id, double pay)
	{
		super(name, id, pay);/*���ø���Ĺ��캯��*/
	}

	public void work()/*��д����*/
	{
		System.out.println("��ͨԱ����");
	}

	public int getBonus()
	{
		return 0;
	}

}

class Manager extends Employee
{
	private int bonus;
	Manager(String name, String id, double pay,int bonus)
	{

		super(name, id, pay);
		this.bonus = bonus;
	}

	public void work()
	{
		System.out.println("����");
	}
	public int getBonus()
	{
		return bonus;
	}
}

class AbstractTest 
{
	public static void main(String[] args) 
	{
		Pro p1 = new Pro("����","������001",5000);/*�½�һ����ͨԱ������*/
		p1.work();
		System.out.println("������"+p1.getName()+"   ��ţ�"+p1.getId()+"   ���ʣ�"+p1.getPay());
	
		Manager p2 = new Manager("����","��Ŀ������001",9000,1000);/*�½�һ����ͨԱ������*/
		p2.work();
		System.out.println("������"+p2.getName()+"   ��ţ�"+p2.getId()+"   ���ʣ�"+p2.getPay()+"   ����"+p2.getBonus());
	}
}
