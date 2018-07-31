package priv.rsl.other_object;
/*
����util���߰��е�Date�ࣺ
����API����֪�������췽��ֻ������public Date()��public Date(long date)

*/



import static java.lang.System.*;//����һ�¾�̬����
import java.util.Date;//Date�����ڹ����࣬����Ҫ����˰�
import java.text.*;//ע�����ڸ�ʽ��ʱ�����������text��
class DateDemo 
{
	public static void main(String[] args) 
	{
		//������ʾ����Date���󲢴�ӡ��ǰʱ��
		Date d = new Date();
		System.out.println(d);//���ִ�ӡ���ǣ�Thu Oct 19 10:19:20 CST 2017

		/*
		��ô��εõ�������Ҫ��ʱ���ʽ�أ�����API֪����
		Date���������һ��DateFormat extends Format�����Ƿ��ִ����ǳ���ģ���һ�����ࣺ
		SimpleDateFormat ʹ�ÿ���ѡ���κ��û����������-ʱ���ʽ��ģʽ��
		���ǣ���Ȼ����ͨ�� DateFormat �е� getTimeInstance��getDateInstance �� getDateTimeInstance ����������-ʱ���ʽ����
		����ͨ�����캯�� SimpleDateFormat(�Զ���ʱ���ʽ)��ʵ�֣�

		*/

		//����SimpleDateFormat����,���Զ���ģʽ��װ��SimpleDateFormat������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��E hh:mm:ss");

		//ʹ��format������ģʽ��ʽ��ָ��Date����
		String time = sdf.format(d);

		out.println("time="+time);

	}
}
/*
Thu Oct 19 11:27:40 CST 2017
time=2017��10��19�������� 11:27:40
*/
