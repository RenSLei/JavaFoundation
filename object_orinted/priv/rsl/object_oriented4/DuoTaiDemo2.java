package priv.rsl.object_oriented4;
/*
��̬���������Ϊ������ڵĶ���������̬��

���è������
���� x = new è();

1����̬������
   ���������ָ���Լ����������
   ���������Ҳ���Խ����Լ����������

2����̬��ǰ��
   ������������֮���й�ϵ��Ҫô�Ǽ̳У�Ҫô��ʵ�֡�
   ͨ������һ��ǰ�᣺���ڸ���

3����̬�ĺô�
   ��̬�ĳ��ִ�������˳������չ�ԡ�

4����̬�ı׶ˣ�
   �������չ�ԣ�����ֻ��ʹ�ø�������÷��ʸ����еĳ�Ա��

5����̬��Ӧ��

*/

/*
���
è����

*/
/*���࣬����*/
abstract class Animal2
{
	public abstract void eat();//���幦��

}
/*����Cat��Dog��Pig���̳�Animal��������д���๦�ܣ��Ҷ����Լ��Ĺ���*/
class Cat2 extends Animal2
{
	public void eat()
	{
		System.out.println("chiyu");
	}

	public void catchMouse()
	{
		System.out.println("zhualaoshu");
	}
}

class Dog2 extends Animal2
{
	public void eat()
	{
		System.out.println("chigutou");
	}

	public void kanJia()
	{
		System.out.println("kanjia");
	}
}

class Pig2 extends Animal2
{
	public void eat()
	{
		System.out.println("chisiliao");
	}

	public void gongDi()
	{
		System.out.println("gongdi");
	}
}

//-----------------------------------------------------------���涨�����࣬�������

class DuoTaiDemo2
{
	public static void main(String[] args) 
	{
		Animal2 a = new Cat2();//��������������ת�͡�
		a.eat();
		//�����Ҫ����è�����з���ʱ����β�����
		
		Cat2 c = (Cat2)a;//ǿ�ƽ����������ת��������,����ת�ͣ�������
		c.catchMouse();
		/*ע�����֣�������ת���������ͣ���ת�����Ǹ���ָ�����Լ����Ӷ���ʱ
		��Ӧ�ÿ��Ա�������Ҳ���Ա�ǿ��ת����
		��̬��ʼ���ն���������������ű仯.*/
		//Animal a = new Animal();
		//Cat c = (Cat)a;��������;
		function(new Cat2());
        function(new Dog2());
        function(new Pig2());

	}
	
	public static void function(Animal2 a)//ע����Animal�൱��Animal a = new Cat();
	{
		a.eat();/*ע�⣺����������Ҫʹ�ô˹��ܣ���˺����൱��Animal a = new Cat();
				  ���Ҫʹ��ԭ������������й��ܣ���è�е�catchMouse��,���������ת��
				  */
	    //һ�㲻�����ã���Ϊ�������ܶ�ͺ��鷳
		if(a instanceof Cat2)
		{
			Cat2 c = (Cat2)a;//��Ҫ��������ת�ͣ�����һ���Ǵ���è����?�����Ҫ��ǰ�ж�
			c.catchMouse();
		}
		else if(a instanceof Dog2)
		{
			Dog2 c = (Dog2)a;
			c.kanJia();
		}
		else if(a instanceof Pig2)
		{
			Pig2 c = (Pig2)a;
			c.gongDi();
		}

	}
}
