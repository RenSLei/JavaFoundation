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
	��DuoTaiDemo3
6����̬�����е��ص㣨��̬��ʹ��ע�����
	��DuoTaiDemo4

*/

/*
���
è����

*/

abstract class Animal {
    public abstract void eat();

}

class Cat extends Animal {
    public void eat() {
	System.out.println("����");
    }

    public void catchMouse() {
	System.out.println("ץ����");
    }
}

class Dog extends Animal {
    public void eat() {
	System.out.println("�Թ�ͷ");
    }

    public void kanJia() {
	System.out.println("����");
    }
}

class Pig extends Animal {
    public void eat() {
	System.out.println("������");
    }

    public void gongDi() {
	System.out.println("����");
    }
}

// -----------------------------------------------------------���涨�����࣬�������

class DuoTaiDemo {
    public static void main(String[] args) {
	/*
	 * Cat c = new Cat(); function(c); Dog d = new Dog(); function(d); function(new
	 * Pig());
	 */
	// Animal c = new Cat();
	// c.eat();ע��Animal��Cat���ж���eat��������Ȼ��ִ�������е�eat(��Ϊ������)
	function(new Cat());
	function(new Dog());
	function(new Pig());
    }

    /*
     * public static void function(Cat c) { c.eat(); } public static void
     * function(Dog d) { d.eat(); } public static void function(Pig p) { p.eat(); }
     */
    public static void function(Animal a)// ע����Animal�൱��Animal a = new Cat();
    {
	a.eat();
    }
}
