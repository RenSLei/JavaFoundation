package priv.rsl.object_oriented6;
/*
�쳣���Ӹ��า���е����֣�
1�������ڸ��Ǹ���ʱ���������ķ����׳��쳣����ô����ĸ��Ƿ�����ֻ��
�׳�������쳣���߸��쳣�����ࡣ

2��������෽���׳�����쳣����ô�����ڸ��Ǹ÷���ʱ��ֻ���׳������쳣���Ӽ���

3�����������߽ӿڵķ�����û���쳣�׳�����ô�����ڸ��Ƿ���ʱ��Ҳ�������׳��쳣��
	������෽���������쳣���ͱ������ڲ�����try�������Բ����ס�
*/


//����1�Ĵ���˵����
class AException extends Exception
{

}

class BException extends AException
{

}

class CException extends Exception
{

}
/*
Exception 
	|--AException
		|--BException
	|--CException

*/

class Fu
{
	void show()throws AException
	{

	}
}

class Zi extends Fu
{
	void show()throws BException//��AException,��������CException
	{

	}
}



class ExceptionDemo6
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
