package priv.rsl.object_oriented5;
/*
�ڲ��ඨ���ھֲ�ʱ��
1�������Ա���Ա���η�����
2������ֱ�ӷ����ⲿ���еĳ�Ա����Ϊ�������ⲿ���е����á�
   ���ǲ����Է��������ڵľֲ��еı�����ֻ�ܷ��ʱ�final���εľֲ�������
*/

class Outer3 {
    int x = 3;

    void method(final int a) {
	final int y = 4;// ֻ�ܷ��ʱ�final���εľֲ�����
	class Inner// �����Ա���Ա���η�����
	{
	    void function() {
		System.out.println(a);
	    }
	}
	new Inner().function();
    }
}

class InnerClassDemo3 {
    public static void main(String[] args) {
	new Outer3().method(7);
    }
}
