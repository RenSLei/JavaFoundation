package priv.rsl.IO_0;
/*
演示对已有文件的数据续写。
*/

import java.io.*;

class FileWriterDemo3 {
    public static void main(String[] args) {

	FileWriter fw = null;

	try {
	    // 传递一个true参数，代表不覆盖已有的文件，并在已有文件的末尾添加数据
	    fw = new FileWriter("demo.txt", true);

	    // 演示如何打出换行符：
	    fw.write("\r\n123");

	} catch (IOException e) {
	    System.out.println(e.toString());
	}

	finally {
	    try {
		if (fw != null)
		    fw.close();
	    } catch (IOException e) {
		System.out.println(e.toString());
	    }

	}
    }
}
