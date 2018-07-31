/*
��һ���ļ���װ��jar��������˫��������ִ�У���ͨ������������

1.���Ű����룺javac -d <���·��> ����.java
����һ���ļ���,��������������ɵ�class�ļ�
2.�л����ô��·����jar -cvf xxx.jar ����
����xxx.jar�ļ�
3.���˫�����jar����ִ������Ĵ��������������أ�
1)��ɾ�����xxx.jar������Ϊ����������Ϣ����
2)�½�һ��txt�ļ�����1.txtΪ�����������������
3)д�룺Main-Class: ����.����(��������������) �س�
4��jar -cvfm xxx.jar 1.txt ����
4.˫��xxx.jar�Ϳ������и�java�ļ���

*/

package priv.rsl.GUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MenuOpenDemo 
{
	//���Ƚ������������
	private Frame f; 
	private MenuBar bar; 
	private Menu menu;
	private MenuItem closeItem,openItem,saveItem;
	private TextArea ta;
	private FileDialog openDia,saveDia;

	//��file�ļ������ڳ�Ա�����Ա�ʹ��
	private File file;

	MenuOpenDemo()
	{
		init();
	}

	public void init()
	{
		//��ʼ��
		f = new Frame("���±�_rsl");
		f.setBounds(300,100,650,600);

		//ע�ⲻ��Ҫ��������ʽ����f.setLayout(new FlowLayout());
		//Ĭ���Ǳ߽粼�־���Ҫ��ӵ��齨�Զ���������
		ta = new TextArea();
		bar = new MenuBar();
		menu =new Menu("�ļ�");
		openItem = new MenuItem("��");
		saveItem = new MenuItem("����");
		closeItem = new MenuItem("�˳�");

		//��ʼ���򿪺ͱ���Ի���,����api
		openDia = new FileDialog(f,"���ļ�",FileDialog.LOAD);
		saveDia = new FileDialog(f,"�����ļ�",FileDialog.SAVE);

		//�˵���������Ӳ˵�
		bar.add(menu);

		//�˵�����Ӵ򿪱����˳���Ŀ
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(closeItem);
		
		/*
		Ч����
			�ļ�
			��
			����
			�˳�
		*/

		//���˵�����ӵ�������ȥ
		f.setMenuBar(bar);
		f.add(ta);

		myEvent();

		f.setVisible(true);

	}

	public void myEvent()
	{
		
		//������󣺵��"����Ŀ"�����ڲ˵���ť���¼�����  "�򿪴��ļ��ĶԻ���"�����ڶ�����
		//�����ɵò���menu�ļ���������������menuItem����Ӽ����ķ���
		openItem.addActionListener(new ActionListener()//Action���һ�㶼��һ������������û��Adapter
		{
			public void actionPerformed(ActionEvent e)
			{
				//���������ļ��Ի�����֣���������Ҫ����Ի������
				openDia.setVisible(true);

				//����ѡ��ĳһ���ļ�����򿪣��ļ������ݻ���ʾ��TextArea ����
				//����������FileDialog �����api���Ĺ��ܣ���λ�ȡѡ����ļ���
	//String getDirectory() ��ȡ���ļ��Ի����Ŀ¼��String	getFile() ��ȡ���ļ��Ի����ѡ���ļ���
				String dirPath = openDia.getDirectory();//��ȡ�ļ���Ŀ¼
				String fileName = openDia.getFile();//��ȡѡȡ���ļ���
				
				//���û��ѡ���ļ�����ʲô��������
				if(dirPath==null || fileName==null)
					return;
				//���ı�������ļ����
				ta.setText("");

				//���ļ���װ���ļ�����
				file = new File(dirPath,fileName);

				//�����ļ���Դ�ǻ�ȡ���ķ�װ�õ��ļ�����Ŀ����TextArea
				try
				{
					BufferedReader bufr = new BufferedReader(new FileReader(file));
					String line = null;
					while((line = bufr.readLine())!=null)
					{
						ta.append(line+"\r\n");
					}
					bufr.close();
				}
				catch (IOException ex)
				{
					throw new RuntimeException("��ȡ�ļ�ʧ�ܣ�");
				}
	
			}
		});


		//������󣺵�������޸ĺ���ļ��ᱣ��
		saveItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent exx)
			{

				//����Ĺ��ܣ�����д���ļ��������ļ���Ϊnull����Ҫ����ʱ������Dialog
				//���ļ����ڵ�ʱ�򣬲���Ҫnew �µ��ļ���ֱ�ӽ��ı����������д���ļ�
				if(file == null)
				{
					//����ļ������ھ��ñ���Ի������
					saveDia.setVisible(true);

					//��ѡ����ļ���װΪ����
					String dirPath = saveDia.getDirectory();//��ȡ�ļ���Ŀ¼
					String fileName = saveDia.getFile();//��ȡѡȡ���ļ���

					//���û��ѡ���ļ�·����Ҳû������Ҫ����Ϊʲô���ֵ��ļ�����ʲô��������
					if(dirPath==null || fileName==null)
					return;
					//���ļ���װ���ļ�����
					file = new File(dirPath,fileName);
				}

				//��ʼ��������
				try
				{
					//����������
					BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
					String text = ta.getText();
					bufw.write(text);

					bufw.close();
				}
				catch (IOException ee)
				{
					throw new RuntimeException("д���ļ�ʧ�ܣ�");
				}

			}
		});



		//���ڵ������ǵ�����˳���ʱ��������
		//��Ӽ���������api����MenuItem֧�ֻ����
		closeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		//��Ӵ��ڼ�����
		f.addWindowListener(new WindowAdapter()
		{
			
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
		});
	}
	public static void main(String[] args) 
	{
		new MenuOpenDemo();
	}

}

