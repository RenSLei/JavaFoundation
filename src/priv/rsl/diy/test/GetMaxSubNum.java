package priv.rsl.diy.test;

import java.util.Arrays;

/**
 * @author rsl
 * 失败---------------
 * 
 * 要求：找出最长的子串数
 */
public class GetMaxSubNum {

    public static void main(String[] args) {
	int[] arr= {0,2,0,9,3,13,6,4,6,5,6,43,23,1,543,6,7,78,534,2,5};//结果应为5
	System.out.println(dpp(arr));
    }

    public static int dpp(int[] arr) {
	int[] as = new int[arr.length];
	Arrays.fill(as, 1);
	for (int i = 1; i < arr.length; i++) {
	    for (int j = 0; j < i; j++) {
		if (arr[j] < arr[i] && as[j] >= as[i]) {
		    as[i] = as[j] + 1;
		    for(int k=0;k<arr.length;k++) {
			System.out.print(as[k]);
		    }
		    System.out.println();
		}
	    }
	}
	
	return Arrays.stream(as).parallel().max().orElse(1);
    }
    
    
    
    
    
    
   //我的解法（失败） 
   /* static int getMaxSubNum(int[] arr) {
	int num=0,max=0,n=1;
	for(int i=0;i<arr.length;i++) {
	    num=arr[i];
	    for(int j=i+1;j<arr.length;j++) {
		if(arr[j]>num) {
		    num=arr[j];
		    n++;
		}
		
	    }
	    if(n>max)
		max=n;
	    	n=1;
	}
	return max;
    }
*/
}
