package priv.rsl.IO_0;

/*
将一个文件的内容复制到另外一个文件中：

步骤：
1，创建目标文件
2，定义读取流和将要复制的文件相关联
3，通过不断的读写完成数据的存储。
4，关闭资源

*/
import java.io.*;

class CopyText {
    public static void main(String[] args) throws IOException {
	//
	copy_2();
    }

    // 方法一：一个一个的读和写
    public static void copy_1() throws IOException {
	// 创建目的地
	FileWriter fw = new FileWriter("RuntimeDemo_copy.txt");

	// 与已经有得文件相关联
	FileReader fr = new FileReader("RuntimeDemo.java");

	int ch = 0;

	while ((ch = fr.read()) != -1) {
	    fw.write(ch);
	}

	fw.close();
	fr.close();
    }

    // 方法二：读到字符数组中,有异常处理动作
    public static void copy_2() {
	// 在外部建立引用
	FileWriter fw = null;
	FileReader fr = null;
	try {
	    fw = new FileWriter("SystemDemo_copy.txt");
	    fr = new FileReader("SystemDemo.java");

	    // 定义数组
	    char[] buf = new char[1024];

	    int len = 0;

	    while ((len = fr.read(buf)) != -1) {
		fw.write(buf, 0, len);
	    }
	} catch (IOException e) {
	    throw new RuntimeException("读写失败！");
	}

	finally {
	    if (fr != null)
		try {
		    fr.close();
		} catch (IOException e) {
		    System.out.println(e.toString());
		}

	    if (fw != null)
		try {
		    fw.close();
		} catch (IOException e) {
		    System.out.println(e.toString());
		}
	}

    }
}
