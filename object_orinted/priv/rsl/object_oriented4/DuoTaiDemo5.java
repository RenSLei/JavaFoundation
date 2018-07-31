package priv.rsl.object_oriented4;

/*


************************************重点***************************************


需求：
电脑运行实例
电脑运行基于主板。



*/
/*作为比较代码：
class MainBoard
{
	public void run()
	{
		System.out.println("mainboard run");
	}
	public void useNetCard(NetCard c)//其实这样MainBoard和useNetCard的耦合性非常强，不利于程序的扩展
	{
		c.open();
		c.close();
	}

} 

class NetCard
{
	public void open()
	{
		System.out.println("netcard open");
	}
	public void close()
	{
		System.out.println("netcard close");
	}

}


class DuoTaiDemo5 
{
	public static void main(String[] args) 
	{
		MainBoard mb = new MainBoard();
		mb.run();
		mb.useNetCard(new NetCard());
	}
}
*/
//优化：使用接口，接口使得里面的方法都是没有方法体的方法。让各种扩展功能去实现就行。然后在MainBoard中使用接口就行。
//至于如何实现，是各种子类的事。

interface PCI {
    public void open();

    public void close();
}

// -------------------------------------------
class MainBoard {
    public void run() {
	System.out.println("mainboare run");
    }

    public void usePCI(PCI p)// 多态的应用PCI p = new NetCard()接口型引用指向自己的子类对象,提高了程序扩展性
    {
	if (p != null) {
	    p.open();
	    p.close();
	}

    }
}

// -----------------------------------------------
class NetCard implements PCI {
    public void open() {
	System.out.println("netcard open");
    }

    public void close() {
	System.out.println("netcard close");
    }
}

class SoundCard implements PCI {
    public void open() {
	System.out.println("SoundCard open");
    }

    public void close() {
	System.out.println("SoundCard close");
    }
}

// -----------------------------------------------------------------------
class DuoTaiDemo5 {
    public static void main(String[] args) {
	MainBoard mb = new MainBoard();
	mb.run();
	mb.usePCI(null);
	mb.usePCI(new NetCard());
	mb.usePCI(new SoundCard());
    }
}
