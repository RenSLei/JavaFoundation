package priv.rsl.other_object;
/*
讲解util工具包中的Date类：
查阅API可以知道，构造方法只有两个public Date()和public Date(long date)

*/



import static java.lang.System.*;//运用一下静态导入
import java.util.Date;//Date是属于工具类，所以要导入此包
import java.text.*;//注意用于格式化时间的类是属于text包
class DateDemo 
{
	public static void main(String[] args) 
	{
		//下面演示创建Date对象并打印当前时间
		Date d = new Date();
		System.out.println(d);//发现打印的是：Thu Oct 19 10:19:20 CST 2017

		/*
		那么如何得到我们想要的时间格式呢？查阅API知道：
		Date请参阅里有一个DateFormat extends Format，但是发现此类是抽象的，有一个子类：
		SimpleDateFormat 使得可以选择任何用户定义的日期-时间格式的模式。
		但是，仍然建议通过 DateFormat 中的 getTimeInstance、getDateInstance 或 getDateTimeInstance 来创建日期-时间格式器。
		可以通过构造函数 SimpleDateFormat(自定义时间格式)来实现：

		*/

		//建立SimpleDateFormat对象,将自定义模式封装到SimpleDateFormat对象中
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日E hh:mm:ss");

		//使用format方法让模式格式化指定Date对象
		String time = sdf.format(d);

		out.println("time="+time);

	}
}
/*
Thu Oct 19 11:27:40 CST 2017
time=2017年10月19日星期四 11:27:40
*/
