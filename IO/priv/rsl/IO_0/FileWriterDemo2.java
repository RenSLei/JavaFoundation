package priv.rsl.IO_0;
/*
IO异常处理的方式：
对于IOException的处理肯定要try catch

*/

import java.io.*;

class FileWriterDemo2 {
    public static void main(String[] args) {
	// 注意点一：try外面创建引用，内部初始化，目的是让变量在整个函数内都有效，否则在其他地方则没有定义
	FileWriter fw = null;
	try {
	    // 初始化变量fw,并创建流资源以及创建文件
	    fw = new FileWriter("demo.txt");

	    // write也要抛异常，所以也要try
	    fw.write("abcdef");
	} catch (IOException e) {
	    System.out.println("catch：" + e.toString());
	}

	// 当创建流资源没有异常时，而是当写文件的时候出现异常时，这时候就要关闭流资源
	// 所以关闭流资源的动作必须要做，所以放在finally中
	finally {
	    // 关闭流资源也要处理异常：
	    try {
		// 当创建流对象失败后，就没有初始化fw,此处也要出问题，所以要先判断
		if (fw != null)
		    fw.close();
	    } catch (IOException e) {
		System.out.println(e.toString());
	    }

	}
    }
}
