import java.util.Scanner;

public class SetAll 
{
	private int[] numbers;
	private int digits;
	private int [] sequence;
	
	public void giveAll(int [] nums, int n)
	{
		numbers = nums;
		digits = n;
		sequence = new int[digits];
		all(0);
		
	}
	
	public void process()
	{
		for (int i = 0; i < digits; i++)
		{
			System.out.print(numbers[sequence[i]]);
		}		
		System.out.println();
	}
	
	public void all(int current)
	{
		if (current == digits)
		{
			process();
			return;
		}
		for (int i = 0; i < numbers.length; i++)
		{
			sequence[current] = i;
			all(current+1);		
		}
	}
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int nums [] = new int[m];
		for (int i = 0; i < m; i++)
			nums[i] = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		SetAll set = new SetAll();
		set.giveAll(nums, n);
	}
}
