package priv.rsl.object_oriented5;
/*
�����ڲ��ࣺ
1�������ڲ�����ʵ�����ڲ���ļ�д��ʽ��
2�����������ڲ���ǰ�᣺
	�ڲ������̳�һ���࣬����ʵ�ֽӿڡ�
3�������ڲ���ĸ�ʽ��new ������߽ӿ�(){�������������}
4����ʵ�����ڲ������һ������������󣬽�������ͽ��������װΪһ�塣������������е��֡�
   Ҳ�������Ϊ�����ݵĶ���
5�������ڲ����ж���ķ�����ò�Ҫ����3��


*/

abstract class AbsDemo
{
	 abstract void show();
}

class Outer4
{
	int x = 3;
	/*
	class Inner extends AbsDemo
	{
		void show()
		{
			System.out.println("show:"+x);
		}
	}
	*/

	public void function()
	{
		//new Inner().show();
		/*����ʹ�������ڲ��ཫ����ע�͵Ĳ���ͬʱ���*/
		/*ע�⣬AbsDemo�ǳ����࣬�����ǲ��ܽ�������ġ�ԭ����������ȫ�ǳ��󷽷���
		�����ǰѳ��󷽷����ǵ����Ϳ��Խ��������ˣ�����ʱ�Ķ���ͽ���AbsDemo����������������������
		Ϊʲô�����ࣿ��Ϊ����֪����ֻ��������ܸ�д�����еĳ����ܡ�
		*/
		new AbsDemo()
		{
			void show()
			{
				System.out.println("x="+x);
			}
			void abc()
			{
				System.out.println("�������й���");
			}
		}.show();
		/*
		new AbsDemo()
		{
			void show()
			{
				System.out.println("x="+x);
			}
			void abc()
			{
				System.out.println("�������й���");
			}
		}��һ�����壬��һ��������������൱��new Inner()
		.show();�ǵ��ó�Ա��


	���ޣ������ڲ���ֻ�ܵ��ø�д���෽�����Ǹ���������ʹ�������ڲ����������֣�
			������������ʱ����ʧ��
			�磺
			AbsDemo d = new AbsDemo()
		{
			void show()
			{
				System.out.println("x="+x);
			}
			void abc()
			{
				System.out.println("�������й���");
			}
		};
		d.show();�˱���ɹ�
		d.abc();�˱���ʧ��

		*/

	}
} 

class InnerClassDemo4 
{
	public static void main(String[] args) 
	{
		new Outer4().function();
	}
}
