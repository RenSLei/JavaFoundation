package priv.rsl.object_oriented5;
/*
˵һ��С���⣻���û�и�����߽ӿ��أ������ʹ����������ȥ����һ�������أ�

*/

class InnerTest {
    public static void main(String[] args) {
	// Object��������ĸ��ࣻ����ObjectΪ�����½���������
	new Object()// ע��:1�����ܸ��˶�������������show,��ΪObjectû��show����2��()��û�зֺ�
	{
	    public void show() {
		System.out.println("new Object(){}; run");
	    }
	}.show();
    }
}
