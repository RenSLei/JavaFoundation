package priv.rsl.object_oriented5;
/*
�ڲ���ķ��ʹ���:
1���ڲ������ֱ�ӷ����ⲿ���еĳ�Ա������˽�С�
֮���Կ���ֱ�ӷ����ⲿ���еĳ�Ա������Ϊ�ڲ����г�����һ���ⲿ�������
��ʽ���ⲿ����.this
2���ⲿ��Ҫ�����ڲ��࣬���뽨���ڲ������

���ʸ�ʽ��
1�����ڲ��ඨ�����ⲿ��ĳ�Աλ���ϣ����ҷ�˽�У��������ⲿ�������С�
����ֱ�ӽ����ڲ������
��ʽ ��  �ⲿ����.�ڲ�����  ������ = �ⲿ�����.�ڲ������;
   Outer.Inner in= new Outer().new Inner();
2�����ڲ����ڳ�Աλ����ʱ���Ϳ��Ա���Ա���η������Ρ�
���磬private:���ڲ������ⲿ���н��з�װ��
static:�ڲ���;߱�Static�����ԡ�
���ڲ��౻��̬�����κ�ֻ��ֱ�ӷ����ⲿ���е�static��Ա�������˷��ʾ��ޡ�

���ⲿ�������У����ֱ�ӷ���static�ڲ���ķǾ�̬��Ա�أ�
new Outer.Inner().function();

���ⲿ�������У����ֱ�ӷ���static�ڲ���ľ�̬��Ա�أ�
Outer.Inner.function();

ע�⣺���ڲ����ж����˾�̬��Ա�����ڲ�������Ǿ�̬��
	  ���ڲ����еľ�̬���������ڲ���ʱ���ڲ���Ҳ������static�ģ�42-53��

����������ʱ��������ڲ�����������������ڲ�����������
��Ϊ�ڲ�������ʹ���ⲿ��������ݡ����������ڲ���˽�л������ṩ�������ʡ�

*/

class Outer2 {
    private static int x = 8;

    // ��̬�ڲ���
    static class Inner {
	//�����г�Ա�Ǿ�̬�ģ���һ���Ǿ�̬��
	static void function() {
	    System.out.println("inner:" + x);
	}
    }

    static class Inner2 {
	void show() {
	    System.out.println("inner2 show");
	}
    }

    public static void method() {
	new Inner2().show();// Inner2��Outer���ڲ��У����Ǿ�̬�ģ�ֱ���½�Inner2����������show����
	// Inner.function();�ڲ�����ʾ�̬��Աֱ������������
    }
}

class InnerClassDemo2 {
    public static void main(String[] args) {
	Outer2.method();
	Outer2.Inner.function();// ֱ�ӷ���static�ڲ���ľ�̬��Ա
	// new Outer.Inner().show();���ⲿ��������ֱ�����þ�̬�ڲ���ķǾ�̬���ܵķ���
//	new Outer.Inner()��һ�����壬��Ϊshow()�ǷǾ�̬�ģ�����Ҫ��������������

    }
}
