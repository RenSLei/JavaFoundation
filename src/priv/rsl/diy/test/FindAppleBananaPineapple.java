package priv.rsl.diy.test;

public class FindAppleBananaPineapple {

    /**找出解符合条件的解
     * 事实证明，本计算机是无法解出这道题的解，
     * 答案是：
     * x=154476802108746166441951315019919837485664325669565431700026634898253202035277999
     * y=36875131794129999827197811565225474825492979968971970996283137471637224634055579
     * z=4373612677928697257861252602371390152816537558161613618621437993378423467772036
     * 
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
//	int x;
//	int y;
//	int z;
	long st= (long)System.currentTimeMillis();
	long n=(long)0;
	long m=(long)0;
	//System.out.println(1632L*7136*8512*4);
	for (int x = 1; x <=1000; x++) {
	    for(int y = 1;y <=1000; y++) {
		for(int z = 1;z <=1000; z++) {
		    long q =(long)(x*(x+y)*(x+z)+z*(y+z)*(x+z)+y*(y+z)*(x+y));
		    long h = (long)(y+z)*(x+y)*(x+z);
			if (q == 4*h && q>0) {
			    System.out.println("q="+q+"\n"+"4h="+4*h);
			    System.out.println("苹果="+x+",香蕉="+y+",菠萝="+z);
			    m++;
			    break;
		    }
		    n++; 
		}
	    }
	}
	
	System.out.println("总共计算次数："+n+"次");
	System.out.println("共"+m+"种符合条件的情况");
	long end=(long)System.currentTimeMillis();
	
	System.out.println("运行时间："+(end-st)+"毫秒");
    }
}
