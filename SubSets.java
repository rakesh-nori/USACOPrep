import java.util.Scanner;

public class SubSets 
{
	private int [] elements ;
	private int[] numbers;
	private int digits;
	public void process()
	{
		for (int i = 0; i < elements.length; i++)
		{
			if (elements[i] == 1)
			{
				System.out.print(numbers[i]);
			}
		}
		System.out.println();
	}
	public void giveCombos(int [] nums, int n)
	{
		numbers = nums;
		elements = new int[nums.length];
		digits = n;
	    for (int i = 1; i < digits; i++)
	    {
	    	combo(0,0,i);
	    }
	}
	
	public void combo(int e, int picked, int numDig)
	{
		if (e == numbers.length)
		{
			if (picked == numDig)
				process();
			return;
		}
		elements[e] =1;
		combo(e+1, picked+1, numDig);
		elements[e] = 0;
		combo(e+1, picked, numDig);
	}
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int nums [] = new int[m];
		for (int i = 0; i < m; i++)
			nums[i] = sc.nextInt();
		SubSets set = new SubSets();
		set.giveCombos(nums, nums.length+1);
		sc.close();
	}
}
