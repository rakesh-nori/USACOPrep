import java.util.Arrays;
import java.util.Scanner;

public class escape 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++)
			w[i] = sc.nextInt();
		int max = 0;
		for (int b = 0; b < Math.pow(2, n); b++)
		{
			boolean [] use = new boolean[n];
			int amnt = 0;
			for (int j = 0; j < n; j++)
			{
				int num = b & (1 << j);
				if (num == 0)
				{
					use[j] = true;
					amnt++;
				}
			}
			int [] using = new int[amnt];
			int index = 0;
			for (int i = 0; i < n; i++)
			{
				if (use[i])
				{
					using[index] = w[i];
					index++;
				}
			}
			Arrays.sort(using);
			boolean working = true;
			while (working)
			{
				int num = 0;
				int count = 0;
				for (int i = 0; i < amnt; i++)
				{
					if (using[i] > 0)
					{
						num += using[i] % 10;
					}
					else
						count++;
				}
				if (count == amnt)
					break;
				if (num >= 10)
					working = false;
				else
				{
					for (int i = 0; i < amnt; i++)
						using[i] /= 10;
				}
			}
			if (working)
				if (amnt > max)
					max = amnt;
		}
		System.out.println(max);
	}
}
