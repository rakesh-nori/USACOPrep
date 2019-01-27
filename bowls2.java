import java.util.Scanner;

public class bowls2 
{
	public static void solve()
	{
		int n = 20;
		boolean [] bowls = new boolean[n];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++)
		{
			int num = sc.nextInt();
			boolean val = true;
			if (num == 1)
				val = false;
			bowls[i] = val;
		}
		int min = Integer.MAX_VALUE - 2;
		for (int i = 0; i < Math.pow(2, n); i++)
		{
			boolean [] curr = bowls;
			boolean [] use = new boolean[n];
			int amnt = 0;
			for (int j = 0; j < n; j++)
			{
				int num = i & (1 << j);
				if (num == 0)
				{
					use[j] = true;
					amnt++;
				}
			}
			int count = 0;
			for (int a = 0; a < n; a++)
			{
				if (use[a])
				{
					count++;
					curr[a] = !curr[a];
					if (a > 0)
						curr[a-1] = !curr[a-1];
					if (a < n-1)
						curr[a+1] = !curr[a+1];
				}
			}
			for (int c = 0; c < n; c++)
			{
				if (curr[c] == false)
				{
					count = Integer.MAX_VALUE;
					break;
				}
			}
			if (count < min)
				min = count;
		}
		System.out.println(min);
	}
	public static void main(String [] args)
	{
		solve();
	}
}
