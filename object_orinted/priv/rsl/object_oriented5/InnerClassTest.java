package priv.rsl.object_oriented5;

interface Inter {
    void method();
}

class Test {

    // ��ͨ�������ڲ�����ʵ�֣�
    static class Inner implements Inter {
	public void method() {
	    System.out.println("��̬�ڲ���static class Inner run");
	}
    }

    static Inter function1() {
	return new Inner();
    }

    // ������롣ͨ�������ڲ�����ʵ�֣�
    static Inter function2()/*
			     * û��������������Inter�����档 Test.function2()��.��һ����������Ȼ�Ƕ��� ������һ��Inter����
			     */
    {
	return new Inter()// return{���涼��һ�����弴һ��������������︴д�˽ӿ��еķ���}
	{
	    public void method() {
		System.out.println("�����ڲ���static Inter run");
	    }

	};// �൱��return ����
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
	System.out.printf("\n");
	Test.function1().method();// һ�㷽������̬�ڲ���
	System.out.printf("\n");
	Test.function2().method();// �����ڲ��෽��
	System.out.printf("\n");
	Inter in = Test.function2();// �����ڲ��෽��
	in.method();
	System.out.printf("\n");

	// ��ε���show�����أ�������Inter�ͽӿ��࣬����¶���һ����ȥ������������鷳
	// ��ʱ����Կ��ǽ�����ֱ���������ڲ���ȥ���ݣ��������£�
	show(new Inter() {
	    // ��д�ӿ��е�method����
	    public void method() {
		System.out.println("show method run");
	    }
	});

    }

    public static void show(Inter in) {
	in.method();
    }
}
