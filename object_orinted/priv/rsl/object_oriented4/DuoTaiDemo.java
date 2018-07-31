package priv.rsl.object_oriented4;
/*
多态：可以理解为事物存在的多种体现形态。

动物：猫，狗。
动物 x = new 猫();

1、多态的体现
   父类的引用指向自己的子类对象。
   父类的引用也可以接受自己的子类对象。

2、多态的前提
   必须是类与类之间有关系。要么是继承，要么是实现。
   通常还有一个前提：存在覆盖

3、多态的好处
   多态的出现大大地提高了程序的扩展性。

4、多态的弊端：
   提高了扩展性，但是只能使用父类的引用访问父类中的成员。

5、多态的应用
	见DuoTaiDemo3
6、多态代码中的特点（多态的使用注意事项）
	见DuoTaiDemo4

*/

/*
动物：
猫，狗

*/

abstract class Animal {
    public abstract void eat();

}

class Cat extends Animal {
    public void eat() {
	System.out.println("吃鱼");
    }

    public void catchMouse() {
	System.out.println("抓老鼠");
    }
}

class Dog extends Animal {
    public void eat() {
	System.out.println("吃骨头");
    }

    public void kanJia() {
	System.out.println("看家");
    }
}

class Pig extends Animal {
    public void eat() {
	System.out.println("吃饲料");
    }

    public void gongDi() {
	System.out.println("拱地");
    }
}

// -----------------------------------------------------------上面定义子类，下面调用

class DuoTaiDemo {
    public static void main(String[] args) {
	/*
	 * Cat c = new Cat(); function(c); Dog d = new Dog(); function(d); function(new
	 * Pig());
	 */
	// Animal c = new Cat();
	// c.eat();注意Animal和Cat类中都有eat方法，必然是执行子类中的eat(因为覆盖性)
	function(new Cat());
	function(new Dog());
	function(new Pig());
    }

    /*
     * public static void function(Cat c) { c.eat(); } public static void
     * function(Dog d) { d.eat(); } public static void function(Pig p) { p.eat(); }
     */
    public static void function(Animal a)// 注意是Animal相当于Animal a = new Cat();
    {
	a.eat();
    }
}
