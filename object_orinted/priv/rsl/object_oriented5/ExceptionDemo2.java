package priv.rsl.object_oriented5;
/*

�ں����������쳣��
������߰�ȫ�ԣ��õ����߽��д��������������ʧ�ܡ�

*/

class Demo2 {
    // �ڹ�����ͨ��throws�Ĺؼ��������˸ù����п��ܻ�������⡣
    int div(int a, int b) throws Exception {
	return a / b;
    }
}

class ExceptionDemo2 {
    public static void main(String[] args)// throws
					  // Exception��Ҳ����������ط��׳��쳣����������jvm����main������ֱ�ӽ�����������һ�㲻��������ʹ��try-catch����
    {
	Demo2 c = new Demo2();
	try {
	    int x = c.div(4, 0);
	    System.out.println("x=" + x);
	} catch (Exception e) {
	    e.printStackTrace();// �쳣���ƣ��쳣��Ϣ���쳣���ֵ�λ��
	    // ��ʵjvmĬ�ϵ��쳣������ƣ������ڵ���printStackTrace����
	    // ��ӡ�쳣�Ķ�ջ������Ϣ
	}
	System.out.println("over");
    }
}
