import java.util.Arrays;
import java.util.Scanner;

public class MilkTemp 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		int [][] cows = new int[n][2];
		int [] Ltemps = new int[n];
		int [] Rtemps = new int[n];
		for (int i = 0; i < n; i++)
		{
			int num = sc.nextInt();
			Ltemps[i] = num;
			cows[i][0] = num;
			int other = sc.nextInt();
			Rtemps[i] = other;
			cows[i][1] = other;
		}
		int max = 0;
		Arrays.sort(Ltemps);
		Arrays.sort(Rtemps);
		int findex = 0;
		int sindex = 0;
		int temp = n * x;
		while (findex < n && sindex < n)
		{
			if(Ltemps[findex] <= Rtemps[sindex])
			{
				temp += y-x;
				findex++;
			}
			else if (Ltemps[findex] > Rtemps[sindex])
			{
				temp += z-y;
				sindex++;
			}

			if(temp > max)
			{
				max = temp;
			}
		}
		System.out.println(max);
	}
}
