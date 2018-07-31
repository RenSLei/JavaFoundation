package priv.rsl.IO_1;
/*
讲解缓冲区：
缓冲区的出现是为了提高流的操作效率而出现的。

所以在创建缓冲区之前，必须先有流对象。

该缓冲区提供了一个跨平台的换行符newLine()
注意用了 缓冲区对象 才能用newLine()
*/

import java.io.*;

class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
	// 创建一个字符写入流对象，注意此对是一new就会在默认目录创建一个名为String的文件
	FileWriter fw = new FileWriter("buf.txt");

	// 为了提高字符写入流的效率。加入了缓冲技术
	// 只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可。
	BufferedWriter bufw = new BufferedWriter(fw);

	for (int x = 1; x < 5; x++) {
	    // 调用父类的write(String s)方法写数据到缓冲区
	    bufw.write("abcd" + x);

	    // 该缓冲区提供了一个跨平台的换行符newLine()
	    bufw.newLine();

	    // 写入一次到缓冲区就刷新该流一次,记住用到缓冲区就要记得刷新
	    bufw.flush();
	}

	// 关闭缓冲区就是关闭了缓冲区对应的流对象。
	bufw.close();
    }
}

/*
 * abcd1 abcd2 abcd3 abcd4
 * 
 */
