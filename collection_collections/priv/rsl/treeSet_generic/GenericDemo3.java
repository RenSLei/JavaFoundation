package priv.rsl.treeSet_generic;


//��һ����
class Worker
{

}

//��һ����
class Student
{
	
}

/*
��һ�����ߣ��������������࣬Ϊ�����ͨ����,
���ڻ�û�з��͵�ʱ����ͨ������Object�������չ��
*/
class Tool1
{
	private Object obj;
	public void setObject(Object obj)
	{
		this.obj = obj;
	}

	public Object getObject()
	{
		return obj;
	}
}

/*
�����˷��ͺ󣬾�������������
*/
class Tool2<QQ>//ʹ�������������������������
{
	private QQ q;
	public void setObject(QQ q)
	{
		this.q = q;
	}

	public QQ getObject()
	{
		return q;
	}
}

class GenericDemo3 
{
	public static void main(String[] args) 
	{
		//��ʾ����ʹ��Object�����չ���ֵ����⣺
		//Tool1 t = new Tool1();
		//t.setObject(new Student());//���봫�����Worker���󣬽���������Student
		//Worker W = (Worker)t.getObject();//��Ϊ��Worker��������ת��Worker����
		//���н��1

		//��ʾ���÷��ͺ�ĺô�
		Tool2<Worker> t = new Tool2<Worker>();

		t.setObject(new Worker());//���˴�������new Student(),�����ʧ��
		Worker w = t.getObject();//����ǿת��
		//���н��2
	}
}
/*
���н��1��
E:\Step1\day15_���Ͽ��\08-������>javac GenericDemo3.java

E:\Step1\day15_���Ͽ��\08-������>java GenericDemo3
Exception in thread "main" java.lang.ClassCastException: Student cannot be cast to Worker
        at GenericDemo3.main(GenericDemo3.java:42)

������������Student���ʱ���ֽ���ת��ΪWorker�࣬���Ա���ʱ����������г�����������


���н��2��
E:\Step1\day15_���Ͽ��\08-������>javac GenericDemo3.java

E:\Step1\day15_���Ͽ��\08-������>java GenericDemo3

��������������κ�����

������ʲôʱ��ʹ�÷��ͣ�
������Ҫ�����������������Ͳ�ȷ����ʱ��
���ڶ���Object�������չ
���ڶ��巺���������չ



*/
