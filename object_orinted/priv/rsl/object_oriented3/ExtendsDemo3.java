package priv.rsl.object_oriented3;
/*
�Ӹ�����ֺ����Ա���ص㣺

���г�Ա��
1������
2������
3�����캯��

3���Ӹ����еĹ��캯��

�ڶ����������г�ʼ��ʱ������Ĺ��캯��Ҳ�����У�������Ϊ����Ĺ��캯��Ĭ�ϵ�һ����һ����ʽ�����super();
super();����ʸ����пղ����Ĺ��캯��������ÿһ�����������еĹ��캯��Ĭ�ϵ�һ�ж���һ����ʽ��super();

Ϊʲô����һ��Ҫ���ʸ���Ĺ��캯����
����Ϊ�����е������������ֱ�ӻ�ȡ�������Ӷ����ڽ���ʱ����Ҫ�Ȳ鿴��������ζ���Щ���ݽ��г�ʼ���ġ�
���Ҫ���ʸ�����ָ���Ĺ��캯��������ͨ���ֶ�����super���ķ�ʽ��ָ����

ע�⣺super���һ�����������๹�캯���ĵ�һ�С�


�����ʵ�������̣�

���ۣ���������еĹ��캯��Ĭ�϶�����ʸ����пղ����Ĺ��캯����
��Ϊ����ÿһ�����캯���ĵ�һ�ж���һ����ʽsuper();

��������û�пղ����Ĺ��캯��ʱ����������ֶ�ͨ��super�����ʽ��ָ��Ҫ���ʸ����еĹ��캯����
��Ȼ������Ĺ��캯����һ��Ҳ�����ֶ�ָ��this��������ʱ����еĹ��캯����
���������ٻ���һ�����캯������ʸ����еĹ��캯����


*/

class Fu3
{
	int num;

	Fu3(int x)
	{
		num=60;
		System.out.println("fu run"+x);
	}
}

class Zi3 extends Fu3/*Zi�̳�Fu��Zi����Fu��ȫ������*/
{
	Zi3()
	{
		//super();Ĭ����һ����ʽ����䣬���ø���ղ������캯������������û�пղ����Ĺ��캯����ô�죿
		super(4);//��ʱ�ͱ����ֶ�����һ��������֮��Ӧ�ĵ������,�������ʧ�ܣ�
		System.out.println("num="+num);//�������ʸ���Ĺ��캯�����������numΪ0
	}
	Zi3(int x)
	{
		//super();
		super(8);//ͬ��
		System.out.println("x="+x);
	}
}

class  ExtendsDemo3
{
	public static void main(String[] args) 
	{
		new Zi3();//������һ��������z����Զ����ʼ���Ĺ��캯����ִ��super();����ӡfu run���Ŵ�ӡzi run
		new Zi3(5);//������һ��������z1����Զ����ʼ���Ĺ��캯����ִ��super();����ӡfu run���Ŵ�ӡx=5
	}
}
