package priv.rsl.IO_1;
/*
װ�����ģʽ��
����Ҫ�����еĶ�����й��ܵ���ǿʱ��
���Զ������ཫ���еĶ�����(ͨ��ͨ�����췽������)��
�������еĹ��ܲ��ṩ��ǿ���ܣ��Զ�������Ϊװ����


*/
//дһ��������˵����
class Function
{
	//ԭʼ�Ĺ���ֻ��һ��
	public void function()
	{
		System.out.println("OriginalFunction");
	}
	
}

//����װ���ࣺ
class superFunction
{
	//����Ҫװ�εĶ��󴫽��������캯����
	private Function f;
	superFunction(Function f)
	{
		this.f = f;
	}

	public void newfunction()
	{
		f.function();
		System.out.println("newFunction1");
		System.out.println("newFunction2");
	}
}


class FunctionDemo 
{
	public static void main(String[] args) 
	{
		//��������
		Function f = new Function();
		
		//ԭʼ����
		//f.function();

		//��ǿ���ܣ�
		superFunction sf = new superFunction(f);
		sf.newfunction();

	}
}
/*
OriginalFunction
newFunction1
newFunction2
*/
