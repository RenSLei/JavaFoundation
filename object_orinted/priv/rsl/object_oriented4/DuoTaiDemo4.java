package priv.rsl.object_oriented4;

class Fu
{
	int num = 5;
	void method1()
	{
		System.out.println("fu method_1");
	}
	void method2()
	{
		System.out.println("fu method_2");
	}
	static void method4()
	{
		System.out.println("fu method_4");
	}
}

class Zi extends Fu
{
	int num = 8;
	void method1()
	{
		System.out.println("zi method_1");
	}
	void method3()
	{
		System.out.println("zi method_3");
	}
	static void method4()
	{
		System.out.println("zi method_4");
	}
}

class  DuoTaiDemo4
{
	public static void main(String[] args) 
	{
		Fu f = new Zi();//ע���Ƕ�̬����ʽ����һ���new����ͬ

		f.method1();
		f.method2();
		//f.method3();//Ҫ����ʧ�ܣ���Ϊ������û��method3();
/*�ڶ�̬�У��Ǿ�̬��Ա�������ص㣺
  �ڱ���ʱ�ڣ����������ͱ���(ָ����ָ��������ʱ�ĸ���)�����������Ƿ��е��õķ���������У�����ͨ����
			  ���û�У�����ʧ�ܣ���Fu����û��method3��
  ������ʱ�ڣ����Ķ������������Ƿ��е��õķ�����
�ܽ᣺��Ա�����ڶ�̬����ʱ�����뿴��ߣ����п��ұߡ�


���⣺
�ڶ�̬�У���Ա�������ص㣺
���۱�������У����ο���ߣ������ͱ����������ࣩ��˳����int = 5��int = 8��

  */
		//���⣺
		Fu f1 = new Zi();
		f1.method4();//�ڶ�̬�У���̬��Ա�������ص㣺���۱�������ж��ο����

		//Zi z = new Zi();
		//z.method1();//��ӡzi method_1(��Ϊ��д)
		//z.method2();//��ӡfu method_2(��Ϊ�̳�)
		//z.method3();//��ӡzi method_3(��Ϊ��������)
		//System.out.println("Hello World!");
	}
}
