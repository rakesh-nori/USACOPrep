import java.util.Scanner;

public class SetPerm 
{
	private int [] used ;
	private int[] numbers;
	private int digits;
	private int [] sequence;
	
	public void process()
	{
		for (int i = 0; i < digits; i++)
		{
			System.out.print(numbers[sequence[i]]);
		}		
		System.out.println();
	}
	
	public void givePerm(int [] nums, int n)
	{
		numbers = nums;
		used = new int[nums.length];
		digits = n;
		sequence = new int[nums.length];
		perm(0);
	}
	public void perm(int current)
	{
		if (current == numbers.length || current == digits)
		{
			process();
			return;
		}
		for (int i = 0; i < numbers.length; i++)
		{
			if (used[i] == 0)
			{
				sequence[current] = i;
				used[i] = 1;
				perm(current+1);
				used[i] = 0;
			}
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
		SetPerm set = new SetPerm();
		set.givePerm(nums, n);
	}
}
