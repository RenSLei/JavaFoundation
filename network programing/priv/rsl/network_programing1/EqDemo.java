package priv.rsl.network_programing1;
/*

*/

import java.io.*;

class EqDemo 
{
	public static void main(String[] args) throws IOException
	{
		byte[] buf = new byte[100];

		int len = System.in.read(buf);//�������룺over

		System.out.println("len="+len);//ΪʲôΪ6?
		
		String s = new String(buf,0,len);

		System.out.print("s="+s+"eee");
		/*
		���н����
		over
		len=6
		s=over
		eee

		*/

		
	}

}
