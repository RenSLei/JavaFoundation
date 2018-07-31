package priv.rsl.object_oriented5;
/*
��Ϊ��Ŀ�л�������е�����
����Щ���Ⲣδ��java����������װ����
���Զ�����Щ���е�������԰���java�Ķ������װ��˼�룬
�����е����⣬�����Զ�����쳣��װ��

�Զ����쳣��

�����ڱ������У����ڳ����Ǹ�����Ҳ��Ϊ�Ǵ���ģ����޷����������
��ô����Ҫ�������������Զ����������

���ں����ڲ�������throw�׳��쳣������ô�ͱ���Ҫ����Ӧ�Ĵ�����
Ҫô���ڲ�try catch ����
Ҫô�ں����������õ����ߴ���

һ������£������ڳ����쳣����������Ҫ������

�����Զ����쳣��Ϣ���������Ѿ����쳣��Ϣ�Ĳ���������ˡ�
	��������ֻҪ�ڹ���ʱ���쳣��Ϣ���ݸ�����ͨ��super���
	�Ϳ���ֱ��ͨ��getMessage������ȡ�Զ�����쳣��Ϣ��

�Զ����쳣���������Զ�����̳�Exception

Ϊʲô�̳�Exception��
�쳣��ϵ��һ���ص㣺��Ϊ�쳣����쳣���󶼱��׳������Ƕ��߱������ԣ����������
��Throwale�ж����ص�

ֻ�������ϵ�е���Ͷ���ſ��Ա�throw��throws�׳���

throws��throws������
1��	throwsʹ���ں�����
	throwʹ���ں�����

2��	throws����������쳣�࣬���Ը�������ö��Ÿ�����
	throw��������쳣����


*/

class FuShuException extends Exception {
    /*
     * private String msg; FuShuException(String msg) { this.msg = msg; } public
     * String getMessage() { return msg; } ̫�鷳
     */
    // �����ô˷�������Զ����쳣��
    private int num;

    FuShuException(String msg, int num) {
	super(msg);
	this.num = num;
    }

    public int getFuShu() {
	return num;
    }

    FuShuException() {
	super();
    }

}

class Demo4 {
    int div(int a, int b) throws FuShuException// �������Ѿ�throw�ˣ���ô�����Ͼ�Ҫ������
    { // �ֶ�ͨ��throw�ؼ����׳�һ���Զ����쳣����
	if (b < 0)
	    throw new FuShuException("���ָ���", b);
	return a / b;
    }
}

public class ExceptionDemo4 {
    public static void main(String[] args) {
	Demo4 c = new Demo4();
	try {
	    int x = c.div(4, -1);
	    System.out.println("x=" + x);
	} catch (FuShuException e) {
	    System.out.println(e.toString());
	    System.out.println("����ĸ����ǣ�" + e.getFuShu());
	}
	System.out.println("over");
    }
}
