package priv.rsl.object_oriented3;
/*
���󣺻�ȡһ�γ������е�ʱ�䡣
ԭ����ȡ����ʼ�ͽ�����ʱ�䲢������ɡ�

��ȡʱ�䣺System.currentTimeMillis();

����������Ż��󣬾Ϳ��Խ���������⡣

���ַ�ʽ��ģ�巽�����ģʽ��

ʲô��ģ�巽���أ�
�ڶ��幦��ʱ�����ܵ�һ������ȷ���ģ�������һ�����ǲ�ȷ����
��ȷ���Ĳ�����ʹ�ò�ȷ���Ĳ��֣���ô��ʱ��ͽ���ȷ���Ĳ���
��¶��ȥ���ɸ��������ȥ��ɡ�

*/

abstract class GetTime {
    public final void getTime() {
	long start = System.currentTimeMillis();
	runcode();
	long end = System.currentTimeMillis();
	System.out.println("���룺" + (end - start));
    }

    public abstract void runcode();
}

/* ���Ͼ��Ƿ�װ�õĴ��룬���ڶ�һ�δ�����в�������ʱ�� */
class SubTime extends GetTime {
    public void runcode()/* �������и�д�������壬�Ա��޸Ĵ������� */
    {
	for (int x = 0; x < 100; x++) {
	    System.out.print(x);
	}
    }
}

class GetTimeDemo {
    public static void main(String[] args) {
	SubTime t = new SubTime();
	t.getTime();
    }
}
