package priv.rsl.object_oriented3;
/*
�Ӹ�����ֺ����Ա���ص㣺

���г�Ա��
1������
2������
3�����캯��

2���Ӹ����еĺ���
��������ֺ͸���һģһ���ĺ���ʱ��
�����������øú���ʱ�����������ຯ�������ݡ�
��ͬ����ĺ���������һ����

��������Ǻ�������һ�����ԣ���д�����ǣ�
���ø��ǵ��ص㣺������̳и��࣬��Ϯ�˸���Ĺ��ܵ������У�
����������߱��ù��ܣ����ǹ��ܵ�����ȴ�͸��಻һ�£�
��ʱ��û�б�Ҫ�����µĹ��ܣ�����ʹ�ø������⣬��������Ĺ��ܶ��壬
����д�������ݡ�

���ǣ�
���า�Ǹ��࣬���뱣֤����Ȩ�޴��ڵ��ڸ��࣬�ſ��Ը��ǣ��������ʧ�ܣ�
��ֻ̬�ܸ��Ǿ�̬

��ס��
���أ�ֻ��ͬ�������Ĳ����б�
��д���Ӹ��෽��Ҫһģһ������������ֵ����
*/

class Fu2
{
	/*private int num = 4;

	public void setNum(int num)
	{
		this.num=num;
	}

	public int getNum()
	{
		return this.num;
	}*/

	void show()
	{
		System.out.println("fu show");
	}
	
	void speak()
	{
		System.out.println("vb");
	}

}

class Zi2 extends Fu2/*Zi�̳�Fu��Zi����Fu��ȫ������*/
{
	
	void show()/*�������ã������ڹ�����չ*/
	{
		System.out.println("zi show");
	}

	void speak()/*�������ã������ڹ�����չ*/
	{
		System.out.println("java");
	}
}

class  ExtendsDemo2
{
	public static void main(String[] args) 
	{
		Zi2 z = new Zi2();
		z.show();
		z.speak();
		NewTel n = new NewTel();
		n.show();
	}
}

class Tel
{
	void show()
	{
		System.out.println("15123027837");
	}
}

class NewTel extends Tel/*������������ֻ����ܣ���Ҫ��ʾ����������Լ�ͷ�������ø�������
							������ʹ�������չ�Ա��*/
{
	void show()
	{
		System.out.printf("������ʾ����ǰ:\n");
		super.show();
		System.out.printf("������ʾ������:\n");
		super.show();/*�����������ø����е�ĳЩ���ܣ�
						�Ͳ�����д��System.out.println("number");*/
		System.out.println("ren shilei");/*�¼ӵĹ���*/
		System.out.println("pic");
	}
}
