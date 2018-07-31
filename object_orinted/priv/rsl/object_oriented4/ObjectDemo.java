package priv.rsl.object_oriented4;
/*
Object:�����ж����ֱ�Ӻ��߼�Ӹ��ࡣ
�����ж���Ŀ϶������ж��󶼾߱��Ĺ���,��Object�е����з������඼���á�
��Object��������Щ�����أ�-------�˳�����ܣ�equals(Object obj)ע���Ƕ�̬��
/*�еĴ�����˵��equals�����ıȽ�ԭ���ܱȽ������ഴ�������ж������κ����������Ƿ����
Ϊʲô����Ϊequals�����˶�̬equals(Object obj);
*/

/*
����Զ�������Ҳ�бȽ���ͬ�Ĺ��ܣ�û�б�Ҫ���¶��塣
ֻҪ��Ϯ�����еĹ��ܣ������Լ����бȽ����ݼ��ɣ���ʹ�ø��Ǹ����е�equals����

*/

class Demo // extends Object
{
    private int num;

    /*
     * Demo() { //super();���κ�����Ĺ��캯�����һ��Ĭ����super(); }
     */
    Demo(int num) {
	this.num = num;
    }

    // ����Զ�������Ҳ�бȽ���ͬ�Ĺ��ܣ�û�б�Ҫ���¶��塣
    // ֻҪ��Ϯ�����еĹ��ܣ������Լ����бȽ����ݼ��ɣ���ʹ�ø��Ǹ����е�equals����
    public boolean equals(Object obj)// Object obj = new Demo();
    {
	if (!(obj instanceof Demo))// �ж�һ���Ƿ���ͬһ��
	    return false;
	Demo d = (Demo) obj;// ����ת��
	return this.num == d.num;
    }
}

class ObjectDemo {
    public static void main(String[] args) {

	Demo d1 = new Demo(4);
	Demo d2 = new Demo(5);
	System.out.println(d1.equals(d2));
	/*
	 * Demo d1 = new Demo(); Demo d2 = new Demo(); Demo d3 = d1;
	 * 
	 * System.out.println(d1.equals(d3)); System.out.println(d1==d3);//ʵ���ǱȽϵĵ�ַ�Ƿ����
	 * System.out.println(d1==d2);
	 */
    }
}
