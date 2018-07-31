package priv.rsl.object_oriented3;
/*
�ӿڣ�������⣬������һ������ĳ�����
���������еķ������ǳ���ģ���ô�������ͨ���ӿڵ���ʽ����ʾ
class���ڶ�����
interface���ڶ���ӿڡ�

�ӿڶ���ʱ����ʽ�ص㣺
1���ӿ��г����Ķ��壺���������󷽷���
2���ӿ��еĳ�Ա���й̶����η���
������public static final
������public abstract
��ס���ӿ��еĳ�Ա����public�ġ�

�ӿ��ǲ����Դ�������ģ���Ϊ�г��󷽷���
��Ҫ������ʵ�֣�����Խӿ��еĳ��󷽷�ȫ�����Ǻ�����ſ���ʵ������
����������һ�������ࡣ

�ӿڿ��Ա����ʵ�֣�Ҳ�ǶԶ�̳в�֧�ֵ�ת����ʽ��java֧�ֶ�ʵ�֡�
�ӿ���ӿ�֮���Ǽ̳й�ϵ���ҿ��Զ�̳У�

�ӿڵ���Ҫ��������չ���๦�ܣ�ͨ������ȥʵ�֡�

�������ܷ������У���������������߱��Ĺ��ܣ�����չ���ܷ��ڽӿ��У���Ҫʱ������ȥʵ�־Ϳ����ˡ�

*/

interface Inter {
    public static final int NUM = 3;

    public abstract void show();

}

interface InterA {

    public abstract void method();

}

class Demo {
    public void function() {
    }
}

class Test extends Demo implements Inter, InterA
/*
* �����ȼ̳��ٶ�ʵ��,����������չһ����Ĺ��ܡ�
* һ�������ʵ�ֶ���ӿڣ�������ֻ�ܵ��̳С���Ϊ�����������Զ�̳У�������ܺ�����ͬ�������� �����ڵ��õ�ʱ��֪��������һ��
* ����Խӿڿ��Զ�ʵ������Ϊ�ӿ��еķ������ǳ���ģ������󷽷���û������ ��Ҫ����ȥд�������壬�����������಻֪�������ĸ�����������
*/
{
    public void show() {
	System.out.println("��д�ӿڵķ���show");
    }/* �Խӿ�Inter��show�������и��� */

    public void method() {
	System.out.println("��д�ӿ�A�ķ���method");
    }/* �Խӿ�InterA��method�������и��� */
}

interface A {
    void methodA();
}

interface B // extends A
{
    void methodB();
}

interface C extends B, A/* �ӿ�֮����Զ�̳У���Ϊû�з����壬���ڷ�������ͬʱ�����뷵��ֵ������ͬ */
{
    void methodC();
}

class D implements C {
    /* Dʵ��C,��D����Ҫ��������������ע��ʵ�ֽӿ�һ��Ҫ��public */
    public void methodC() {
    }

    public void methodB() {
    }

    public void methodA() {
    }
}

class InterfaceDemo {
    public static void main(String[] args) {
	Test t = new Test();
	System.out.println(t.NUM);
	System.out.println(Test.NUM);
	System.out.println(Inter.NUM);
	t.method();
	t.show();

    }
}
