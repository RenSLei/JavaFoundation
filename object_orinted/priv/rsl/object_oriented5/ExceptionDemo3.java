package priv.rsl.object_oriented5;
/*
3���Բ��񵽵��쳣������г�������������
String getMessage();��ȡ�쳣��Ϣ��

-----------------------------------------------------
�ں����������쳣��
������߰�ȫ�ԣ��õ����߽��д��������������ʧ�ܡ�
-----------------------------------------------------

�Զ��쳣�Ĵ���
1�������쳣ʱ������������Ϊ������쳣����������Ŀ��Ը����塣
2���Է������м����쳣����Ӧ�ö�Ӧ�м���catch��������������⣬��Ҫ��������catch��
   ������catch���е��쳣���ּ̳й�ϵ�������쳣catch����������档

3�������ڴ����쳣ʱ��catchҪд����Ĵ���ʽ����Ҫ�򵥶���һ�䣺e.printStackTrace();
   Ҳ��Ҫ�򵥵ľ���дһ�������䣻
   ����ʵ�ʿ���ʱ��catch�ǽ��쳣��¼��Ӳ����־�ļ��еģ��Ա����Ա���г�����ԡ�




*/

class Demo3 {
    int div(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException// �׳�������ܵĶ��쳣�����������쳣������Ǳ�Խ���쳣
    {
	int[] arr = new int[a];
	System.out.println(arr[4]);
	return a / b;
    }
}

class ExceptionDemo3 {
 // throws Exception��Ҳ����������ط��׳��쳣����������jvm����main������ֱ�ӽ�����������һ�㲻��������ʹ��try-catch����
    public static void main(String[] args){
	Demo3 c = new Demo3();
	try {
	    int x = c.div(3, 1);
	    System.out.println("x=" + x);
	} catch (ArithmeticException e)
/*
* ע�⣬����catchֻ��ִ��һ������Ϊ��catch�����쳣ִ�к󣬳���ͽ����� ��catchҪд����ԵĴ���Ҳ����ֱ��д��catch
* (Exception e){System.out.println(e.toString());} ���Ǵ˴������壬���ڶ�̬��catch��������
*/
	{
	    System.out.println("������ˣ���");
	    System.out.println(e.toString());
	} catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("�Ǳ�Խ�磡��");
	    System.out.println(e.toString());
	}

    }
}
