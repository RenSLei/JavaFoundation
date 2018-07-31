package priv.rsl.object_oriented4;

/*


************************************�ص�***************************************


����
��������ʵ��
�������л������塣



*/
/*��Ϊ�Ƚϴ��룺
class MainBoard
{
	public void run()
	{
		System.out.println("mainboard run");
	}
	public void useNetCard(NetCard c)//��ʵ����MainBoard��useNetCard������Էǳ�ǿ�������ڳ������չ
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
//�Ż���ʹ�ýӿڣ��ӿ�ʹ������ķ�������û�з�����ķ������ø�����չ����ȥʵ�־��С�Ȼ����MainBoard��ʹ�ýӿھ��С�
//�������ʵ�֣��Ǹ���������¡�

interface PCI {
    public void open();

    public void close();
}

// -------------------------------------------
class MainBoard {
    public void run() {
	System.out.println("mainboare run");
    }

    public void usePCI(PCI p)// ��̬��Ӧ��PCI p = new NetCard()�ӿ�������ָ���Լ����������,����˳�����չ��
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
