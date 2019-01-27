import java.util.*;
public class btwr2
{
	public static void solve()
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int [][] arr = new int[n][2];
		for (int i = 0; i < n; i++)
		{
			int w = sc.nextInt();
			int bo = sc.nextInt();
			arr[i][0]= w;
			arr[i][1] = bo;
			
		}
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
			int [][] using = new int[amnt][2];
			int index = 0;
			for (int e = 0; e < use.length; e++)
			{
				if (use[e])
				{
					using[index][0] = arr[e][0];
					using[index][1] = arr[e][1];
					index++;
					
				}
			}
			Arrays.sort(using, new cp());
			int count = 1;
			for (int a = 1; a < amnt; a++)
			{
				if (using[a][0] - using[a-1][0] < 0 && using[a][1] - using[a-1][1] < 0)
					count++;
				else
					count = -1000;
			}
			if (count > max)
				max = count;
		}
		System.out.println(max);
	}
	public static void main(String [] args)
	{
		solve();
	}
	static class cp implements Comparator <int[]>
	{
		public int compare(int[] a, int[] b)
		{
			if (b[0]-a[0] != 0)
				return b[0] - a[0];
			else
				return b[1] - a[1];
		}
	}
	
}
