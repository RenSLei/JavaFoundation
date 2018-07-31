package priv.rsl.network_programing2;

/*


��ͼ�λ�������һ���򵥵������
��������ܹ�����tomcat������

*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class MyIEByGUI
{
	//���Ƚ������������
	private Frame f; 
	private TextField tf; 
	private Button but;
	private TextArea ta;

	//���캯��
	MyIEByGUI()
	{
		init();
	}
	//��ʼ������
	public void init()
	{
		f = new Frame("my window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());
		tf = new TextField(60);
		but = new Button("ת��");
		ta = new TextArea(25,70);

		//�������
		f.add(tf);
		f.add(but);
		f.add(ta);
		
		//�����¼�
		myEvent();

		//��ʾ����
		f.setVisible(true);

	}

	public void myEvent()
	{
		//ע�ᴰ�ڼ�����,�¼�Դ�Ǵ���
		f.addWindowListener(new WindowAdapter()
		{
			
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
		});

		//ע�ᰴť���������¼�Դ�ǰ�ť
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				//�Լ���ַǳ��鷳�����ҶԸ�ʽ�����Ժܴ�
				try
				{
					//�ɹ�һ�ξ͵���һ��
					ta.setText("");
					//�ڰ�ť�����������Ǽ��̣���ʱ�򣬲���ı����е���ַ:
					//����://192.168.43.53:8080/myWeb/Demo.html  
					
					//���Ȼ�ȡ��ַ
					String url = tf.getText();
					
					//��ֳ�ip����Դ·����
					int index1 = url.indexOf("//")+2;
					int index2 = url.indexOf("/",index1);

					String str = url.substring(index1,index2);
					String[] arr = str.split(":");
					String host = arr[0];
					int port = Integer.parseInt(arr[1]);
					
					String path = url.substring(index2);
					System.out.println(host+port+path);

					Socket s = new Socket(host,port);

					//����������������
					PrintWriter out = new PrintWriter(s.getOutputStream(),true);

					out.println("GET "+path+" HTTP/1.1");//��������
					out.println("Accept:*/*");
					out.println("Accept-Language:zh-cn");
					out.println("Host:"+host+":"+port);
					out.println("Connection: closed");
					
					//******һ��Ҫд����******
					out.println();
					out.println();
					
					//��ȡ���������ص����ݣ���ʵ����tomcat���������Զ����myWeb/Demo.html�ļ�����
					BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

					String line = null;

					while((line=bufr.readLine())!=null)
					{
						ta.append(line+"\r\n");
					}

					s.close();
				}
				catch (Exception ex)
				{
					 throw new RuntimeException("�쳣");
				}
				
				
			}
		});

	}        
	
	
	public static void main(String[] args) 
	{
		new MyIEByGUI();
	}

}
