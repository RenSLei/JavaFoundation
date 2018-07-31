package priv.rsl.IO_0;
/*
字节流与字符流：
	字节流是通用的，而字符流是针对文本文件并基于字节流
	字符流允许自定义文本查找的编码表（是UTF-8还是GBK）
IO流常用的四个抽象基类：
	字节流：输入流：InputStream		输出流：OutputStream
	字符流：输入流：Reader			输出流：Writer

且其子类都是以父类作为后缀名,而前缀名是该流的功能。

先学习字符流的特点：

IO是用于操作数据的，
而数据的最常见的体现形式是：文件。

则先以操作文件为主来演示。

需求：在硬盘上，创建一个文件并写入一些文字数据。

找到一个专门用于操作文件的Writer子类对象。FileWriter.

结构图：
java.lang.Object
  继承者 java.io.Writer（抽象父类）
      继承者 java.io.OutputStreamWriter（字符流与字节流的桥梁）
          继承者 java.io.FileWriter（只有构造方法，方法到Writer类中去找）
			
*/

import java.io.*;

class FileWriterDemo {
    public static void main(String[] args) throws IOException {
	// 查阅API文档可以知道，FileWriter类只有构造方法，而且没有空参数的构造方法
	// 所以，对象一被初始化就必须要明确被操作的文件。
	// 而且该文件被创建到指定目录下。如果该目录下已有同名文件，将被覆盖。
	// 其实该步就是在明确数据要存放的目的地。
	FileWriter fw = new FileWriter("demo.txt");// 此处若路径错，则抛出异常，所以要throws

	// 调用write方法，将字符串写入流中。
	fw.write("fesgdrg");

	// 刷新流对象中的缓冲中的数据。
	// 将数据刷到目的地文件中。
	fw.flush();// 此时文件中已经有数据了

	// 还可以继续写入流中，如：fw.write("haha");fw.flush();

	// 关闭流资源，关闭之前会刷新一次内部的缓冲区中的数据。
	// 将数据刷到目的地中
	// 区别：flush刷新后，流可以继续使用，close刷新后，会将流关闭。
	fw.close();// 关闭之后就不能再写了。

    }
}
