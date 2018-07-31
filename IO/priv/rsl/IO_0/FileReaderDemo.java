package priv.rsl.IO_0;

import java.io.*;

/*
 * 
 * 
 * 
//文件的读取方式之二：
//
//通过字符数组进行读取：
//public int read(char[] cbuf)
//         throws IOException
//返回：
//读取的字符数，如果已到达流的末尾，则返回 -1
*/
class FileReaderDemo {
    public static void main(String[] args) throws IOException {
	// 创建一个文件读取流对象，和指定名称的文件相关联。
	FileReader fr = new FileReader("demo.txt");

	// 定义一个字符数组。用于存储读到字符
	// read(char[])：返回的是读到字符个数
	char[] buf = new char[1024];

	// 定义一个int型的变量用于记录read的返回数据
	int num = 0;

	// 写循环，条件是当返回的值不是-1时，说明没有到文件末尾
	// 注意一次就读一个数组长度那么长（如果有那么长的话）
	while ((num = fr.read(buf)) != -1) {
	    // 读一次打印一次，当字符数小于数组长度时，就打印0到num的字符，如果没读完，则下次循环继续读和打印
	    System.out.println(new String(buf, 0, num));
	}
	// 关闭流资源
	fr.close();
    }
}
