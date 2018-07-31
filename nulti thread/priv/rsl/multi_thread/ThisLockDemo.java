package priv.rsl.multi_thread;
/*
同步函数的锁是什么呢？
函数需要被对象调用。那么函数都有一个所属对象引用。就是this.
所以同步函数使用的锁是this.
*/

class Ticket2 implements Runnable {
    private int tick = 1000;

    // Object obj = new Object();
    public void run() {
	while (true) {
	    this.show();
	}

    }

    public synchronized void show()/* 同步函数的锁是什么呢？ */
    {
	if (tick > 0) {
	    try {
		Thread.sleep(10);
	    } catch (Exception e) {
	    } /*
	       * 注意，此语句是利用Thread中的静态sleep方法，强制睡眠10毫秒，并处理该方法抛出的中断异常。观察多线程在实际应用中容易出现的安全问题：
	       * 即在本例中卖出负号票。
	       */
	    System.out.println(Thread.currentThread().getName() + "sale :" + tick--);
	}
    }
}

class ThisLockDemo {
    public static void main(String[] args) {
		Ticket3 t = new Ticket3(); //创建了一个实现接口Runnable的类的对象。

		Thread t1 = new Thread(t);//创建了一个线程
		Thread t2 = new Thread(t);//创建了一个线程
		Thread t3 = new Thread(t);//创建了一个线程
		Thread t4 = new Thread(t);//创建了一个线程

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	

}
}
//部分运行结果：
/*
 * Thread-2sale :463 Thread-2sale :462 Thread-2sale :461 Thread-2sale :460
 * Thread-2sale :459 Thread-2sale :458 Thread-2sale :457 Thread-2sale :456
 * Thread-2sale :455 Thread-3sale :454 Thread-0sale :453 Thread-0sale :452
 * Thread-0sale :451 Thread-0sale :450 Thread-0sale :449 Thread-0sale :448
 * Thread-0sale :447 Thread-0sale :446 Thread-0sale :445 Thread-0sale :444
 * Thread-0sale :443 Thread-0sale :442 Thread-0sale :441 Thread-0sale :440
 * Thread-3sale :439 Thread-3sale :438 可以看到，线程0，1，2，3都跑起来了
 */
