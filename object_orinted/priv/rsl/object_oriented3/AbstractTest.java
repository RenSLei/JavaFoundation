package priv.rsl.object_oriented3;

/*
开发一个系统需要对公司员工进行建模 。员工包含普通员工和经理。
员工的共同属性是：1、姓名2、工号3、工资。另外经理还有一个奖金属性。
请使用继承的思想设计出员工类和经理类。要求类中提供必要的方法进行属性的访问。

分析：
建立员工类并抽象功能

建立普通员工类继承员工类并重写功能

建立经理类继承员工类并重写功能
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
		super(name, id, pay);/*引用父类的构造函数*/
	}

	public void work()/*重写功能*/
	{
		System.out.println("普通员工：");
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
		System.out.println("经理：");
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
		Pro p1 = new Pro("张三","技术部001",5000);/*新建一个普通员工对象*/
		p1.work();
		System.out.println("姓名："+p1.getName()+"   编号："+p1.getId()+"   工资："+p1.getPay());
	
		Manager p2 = new Manager("李四","项目部经理001",9000,1000);/*新建一个普通员工对象*/
		p2.work();
		System.out.println("姓名："+p2.getName()+"   编号："+p2.getId()+"   工资："+p2.getPay()+"   奖金："+p2.getBonus());
	}
}
