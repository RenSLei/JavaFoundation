package priv.rsl.string;
/*
JDK1.5�汾�Ժ���ֵ������ԡ�
*/



class IntegerDemo1 
{
	public static void sop(String str)
	{
		System.out.println(str);
	}

	public static void main(String[] args) 
	{
		//Integer x = new Integer("123");
		//�����ԣ�
		Integer x =123;//�Զ�װ�䡣//new Integer(123);
		//ע�⣬����д֮����Խ�null����x�ˡ����оͻ�����׳�RuntimeException
		x = x+2;//x=123:�������Զ����䡣�����int���͡���2���мӷ�����
				//�ٽ��ͽ���װ�丳��x. 

		Integer m = 128;//����byte��Χ���ݣ������¿ռ�
		Integer n = 128;
		sop("m==n��"+(m==n));//���Ϊfalse

		Integer a = 127;
		Integer b = 127;
		sop("a==b��"+(a==b));//���Ϊtrue.
	}
}
 //��Ϊa��bָ����ͬһ������
 //��Ϊ����ֵ��byte��Χ���ݣ����������ԣ��������ֵ�Ѿ����ڣ��򲻻��ڿ����µĿռ䡣
	
/*ԭ��д�������鷳
	public static void method()
	{
		Integer x = new Integer("123");
		Integer y = new Integer(123);
		sop("x==y:"+(x==y));
		sop("x.equals(y):"+x.equals(y));
	}
}
*/

/*
���н����
m==n��false
a==b��true
*/

