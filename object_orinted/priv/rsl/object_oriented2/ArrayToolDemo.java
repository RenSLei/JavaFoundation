package priv.rsl.object_oriented2;
class ArrayToolDemo 
{
	public static void main(String[] args) 
	{
		int[] arr ={2,45,3,64,5,6,54,67,45,46};
//通过类名直接调用方法
		System.out.println("max="+ArrayTool.getMax(arr));
		System.out.println("min="+ArrayTool.getMin(arr));
		ArrayTool.selectSort(arr);
		System.out.print("select from small to big:");
		ArrayTool.printArray(arr);
		System.out.println();
		System.out.print("bubble from big to small:");
		ArrayTool.bubbleSort(arr);
		ArrayTool.printArray(arr);
	}
}
