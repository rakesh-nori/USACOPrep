import java.util.Scanner;

public class Boost 
{
	private boolean use[];
	public void findA(int f, int m, int n, int [][]parts)
	{
		use = new boolean[n];
		double[] a = new double[(int)(Math.pow(2, n))];
		for (int b = 0; b < Math.pow(2, n); b++)
		{
			for (int j = 0; j < n; j++)
			{
				int num = b & (1 << j);
				if (num == 0)
				{
					use[j] = true;
				}
			}
			int addF = 0;
			int addM = 0;
			for (int num = 0; num < n; num++)
			{
				if (use[num])
				{
					addF += parts[num][0];
					addM += parts[num][1];
				}
			}
			a[b] = ((f + addF) * 1.00) / (m+addM);
			for (int index = 0; index < n; index++)
				use[index] = false;
		}
		int maxdex = 0;
		double maxA = 0;
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] > maxA)
			{
				maxA = a[i];
				maxdex = i;
			}
		}
		boolean none = true;
		for (int j = 0; j < n; j++)
		{
			int num = maxdex & (1 << j);
			
			if (num == 0)
			{
				none = false;
				System.out.println(j+1);
			}
		}
		if (none)
			System.out.println("NONE");
		
	}
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int [][] parts = new int[n][2];
		for (int i = 0; i < n; i++)
		{
			parts[i][0] = sc.nextInt();
			parts[i][1] = sc.nextInt();
		}
		sc.close();
		Boost ultra = new Boost();
		ultra.findA(f, m, n, parts);
		
	}
}
