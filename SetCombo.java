import java.util.Scanner;

public class SetCombo
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
		combo(0, 0);
	}
	public void combo(int e, int picked)
	{
		if (e == numbers.length)
		{
			if (picked == digits)
				process();
			return;
		}
		elements[e] =1;
		combo(e+1, picked+1);
		elements[e] = 0;
		combo(e+1, picked);
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
		SetCombo set = new SetCombo();
		set.giveCombos(nums, n);
	}
	

}
