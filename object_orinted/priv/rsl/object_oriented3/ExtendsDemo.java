package priv.rsl.object_oriented3;
/*
�Ӹ�����ֺ����Ա���ص㣺

���г�Ա��
1������
2������
3�����캯��

1������
��������г��ַ�˽�е�ͬ����Ա����ʱ��
����Ҫ���ʱ���������á�
super������Ǹ����������á�
*/

class Fu
{
	int num = 4;
}

class Zi extends Fu/*Zi�̳�Fu��Zi����Fu��ȫ������*/
{
	int num = 5;
	void show()
	{
		System.out.println(this.num);/*��������е����ã���ӡ5*/
		System.out.println(super.num);/*��������е����ã���ӡ4*/
	}
}

class  ExtendsDemo
{
	public static void main(String[] args) 
	{
		Zi z = new Zi();
		z.show();
	}
}
