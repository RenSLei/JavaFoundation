package priv.rsl.object_oriented5;
/*
Exception ����һ������������쳣��RuntimeException ����ʱ�쳣

����ں������׳����쳣�������Ͽ��Բ�������������һ��ͨ��
����ں����������˸��쳣�������߿��Բ��ý��д�������һ��ͨ��

֮���Բ����ٺ���������������Ϊ����Ҫ�õ����ߴ���
�����쳣������ϣ������ֹͣ����Ϊ������ʱ���������޷�������������
ϣ��ֹͣ����󣬶Դ������������  

�Զ����쳣ʱ������쳣�ķ����޷��ټ�����������Ļ��������Զ����쳣�̳�RuntimeException
�ô��ǣ�������ݵĲ������ǺϷ��ģ����ó���ͣ�������ȴ��޸Ĵ��룬ֱ��������ȷ��


�����쳣�����֣�
1������ʱ�������쳣
(1)�Ǻ����ڲ��׳��˳�RuntimeException�쳣����������Exception����������û������
(2)�������ˣ���������δ�������׳����ߴ�����

2������ʱ���������쳣������ʱ�쳣��RuntimeException�Լ������ࣩ
*/

class FuShuException5 extends RuntimeException {
    public FuShuException5(String msg) {
	super(msg);
    }
}

class Demo5 {
    int div(int a, int b)// ע�⣬FuShuException�̳���RuntimeException���������׳��Զ����쳣���Ͳ����ں���������throws
			 // ArithmeticException������
    {
	if (b < 0)
	    throw new FuShuException5("����Ϊ�����ˣ�");
	if (b == 0)
	    throw new FuShuException5("����Ϊ���ˣ�");
	return a / b;
	// throw new ArithmeticException("�������")
    }
}

class ExceptionDemo5 {
    public static void main(String[] args) {
	Demo5 d = new Demo5();
	int x = d.div(4, -3);
	System.out.println("x=" + x);

	System.out.println("over");
    }
}
