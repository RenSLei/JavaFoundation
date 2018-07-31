package priv.rsl.network_programing1;
/*
Udp���ܶˣ�

���󣬶���һ������udpЭ�鴫�������Ӧ�ó���

˼·��
1������udpsocket���񣬼�DatagramSocket����,ͨ�������һ���˿ڣ����Ǹ����Ӧ�ó�����һ���˿ڱ�ʶ
2�����������ݰ������ڴ�Ž��յ������ݣ���ΪDatagramPacket���ݰ����������зḻ����ȡ���ݵķ���
3,����udpsocket�����receive()�������ݲ��������ݰ�������
4�����ö������й�����ȡ��Ϣ����ӡ�ڿ���̨��
5���ر���Դ

*/


import java.net.*;

class UdpRece2
{
	public static void main(String[] args) throws Exception
	{
		//����udp����,ָ���˿ں�
		DatagramSocket ds = new DatagramSocket(1000);
		
		while(true)
		{

			//���ݰ�
			byte[]  buf= new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);

			//receive
			ds.receive(dp);//����ʽ����,������while(true)������ѭ��

			//��ȡ��ӡ
			String ip = dp.getAddress().getHostAddress();

			String data = new String(dp.getData(),0,dp.getLength());
			System.out.println("���Ͷ˶˿ںţ�"+dp.getPort()+"IP:"+ip+"data:"+data);
		}
	}

}

