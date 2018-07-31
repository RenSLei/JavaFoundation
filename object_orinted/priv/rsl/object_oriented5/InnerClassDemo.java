package priv.rsl.object_oriented5;

/**
 * �ڲ���ķ��ʹ���: 1���ڲ������ֱ�ӷ����ⲿ���еĳ�Ա������˽�С� ֮���Կ���ֱ�ӷ����ⲿ���еĳ�Ա������Ϊ�ڲ����г�����һ���ⲿ�������
 * ��ʽ���ⲿ����.this 2���ⲿ��Ҫ�����ڲ��࣬���뽨���ڲ������
 * 
 * ���ʸ�ʽ�� 1�����ڲ��ඨ�����ⲿ��ĳ�Աλ���ϣ����ҷ�˽�У��������ⲿ�������С� ����ֱ�ӽ����ڲ������ ��ʽ �� �ⲿ����.�ڲ����� ������ =
 * �ⲿ�����.�ڲ������; Outer.Inner in= new Outer().new Inner();
 * 2�����ڲ����ڳ�Աλ����ʱ���Ϳ��Ա���Ա���η������Ρ� ���磬private:���ڲ������ⲿ���н��з�װ�� static:�ڲ���;߱�Static�����ԡ�
 * ���ڲ��౻��̬�����κ�ֻ��ֱ�ӷ����ⲿ���е�static��Ա�������˷��ʾ��ޡ�
 * 
 * ���ⲿ�������У����ֱ�ӷ���static�ڲ���ķǾ�̬�أ�
 * 
 * @author WinWin
 * @since 1.0
 */

class Outer {
    private int x = 8;

    class Inner// �����ڳ�Ա�����ϵ��ڲ���
    {
	int x = 5;
	void function() {
	    int x = 3;
	    System.out.println("inner:" + x);//�������ı���
	    System.out.println("inner:" + this.x);//����ĳ�Ա
	    System.out.println("inner:" + Outer.this.x);//Outer.this�����ⲿ�࣬�ڲ������ֱ�ӷ����ⲿ�ྲ̬
	}
    }

    void method() {
	Inner in = new Inner();// �ⲿ��Ҫ�����ڲ��࣬���뽨���ڲ�����
	in.function();
    }
}

/**
 * �����ڲ����ʹ��
 * 
 * @author WinWin
 *
 */
class InnerClassDemo {
    public static void main(String[] args) {
	Outer out = new Outer();
	out.method();

	// ֱ�ӷ����ڲ����еĳ�Ա��
	// Outer.Inner in = new Outer().new Inner();//һ�ָ�ʽ�������õý϶�
	// in.function();
    }
}
