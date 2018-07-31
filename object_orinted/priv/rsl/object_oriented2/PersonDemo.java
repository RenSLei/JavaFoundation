package priv.rsl.object_oriented2;

class Person {
    private String name = "haha";
    private int age;
    private static String country = "CN";

    Person(String name, int age) {
	this.name = name;
	this.age = age;
    }

    {
	System.out.println(name + "..." + age);
    }

    public void setName(String name) {
	this.name = name;
    }

    public void speak() {
	System.out.println(this.name + "..." + this.age);
    }

    public static void showCountry() {
	System.out.println("Country=" + country);
    }
}

class PersonDemo {
    public static void main(String[] args) {
	new Person("lisi", 25);
    }
}
/*
 * Person p = new Person("lisi");
 * 
 * �þ仰������ʲô��ִ��˳���ǣ� 1����Ϊnew�õ���Person.class�����Ի����ҵ�Person.class�ļ������ص��ڴ��С�
 * 2��ִ�и����е�static����飬����еĻ�����Person.class����г�ʼ���� 3���ڶ��ڴ��п��ٿռ䣬�����ڴ��ַ��
 * 4���ڶ��ڴ��н���������������ԣ�������Ĭ�ϳ�ʼ���� 5�������Խ�����ʾ��ʼ���� 6���Զ�����й��������ʼ����
 * 7���Զ�����ж�Ӧ�Ĺ��캯����ʼ����
 * 8�����ڴ��ַ����ջ�ڴ��е�P������
 */
