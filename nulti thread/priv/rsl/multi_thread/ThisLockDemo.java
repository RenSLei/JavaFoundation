package priv.rsl.multi_thread;
/*
ͬ������������ʲô�أ�
������Ҫ��������á���ô��������һ�������������á�����this.
����ͬ������ʹ�õ�����this.
*/

class Ticket2 implements Runnable {
    private int tick = 1000;

    // Object obj = new Object();
    public void run() {
	while (true) {
	    this.show();
	}

    }

    public synchronized void show()/* ͬ������������ʲô�أ� */
    {
	if (tick > 0) {
	    try {
		Thread.sleep(10);
	    } catch (Exception e) {
	    } /*
	       * ע�⣬�����������Thread�еľ�̬sleep������ǿ��˯��10���룬������÷����׳����ж��쳣���۲���߳���ʵ��Ӧ�������׳��ֵİ�ȫ���⣺
	       * ���ڱ�������������Ʊ��
	       */
	    System.out.println(Thread.currentThread().getName() + "sale :" + tick--);
	}
    }
}

class ThisLockDemo {
    public static void main(String[] args) {
		Ticket3 t = new Ticket3(); //������һ��ʵ�ֽӿ�Runnable����Ķ���

		Thread t1 = new Thread(t);//������һ���߳�
		Thread t2 = new Thread(t);//������һ���߳�
		Thread t3 = new Thread(t);//������һ���߳�
		Thread t4 = new Thread(t);//������һ���߳�

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	

}
}
//�������н����
/*
 * Thread-2sale :463 Thread-2sale :462 Thread-2sale :461 Thread-2sale :460
 * Thread-2sale :459 Thread-2sale :458 Thread-2sale :457 Thread-2sale :456
 * Thread-2sale :455 Thread-3sale :454 Thread-0sale :453 Thread-0sale :452
 * Thread-0sale :451 Thread-0sale :450 Thread-0sale :449 Thread-0sale :448
 * Thread-0sale :447 Thread-0sale :446 Thread-0sale :445 Thread-0sale :444
 * Thread-0sale :443 Thread-0sale :442 Thread-0sale :441 Thread-0sale :440
 * Thread-3sale :439 Thread-3sale :438 ���Կ������߳�0��1��2��3����������
 */
