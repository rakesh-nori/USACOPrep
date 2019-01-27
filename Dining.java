import java.util.Arrays;
import java.util.Scanner;

public class Dining 
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] cows = new int[n];
		for (int i = 0; i < n; i++)
		{
			cows[i] = sc.nextInt();
		}
		int [] prefix = new int[n];//for the 2s
		if (cows[0] == 2)
			prefix[0]++;
		for (int i = 1; i < n; i++)
		{
			if (cows[i] == 2)
				prefix[i]++;
			prefix[i] += prefix[i-1];
		}
		int [] suffix = new int[n];//for the ones
		if (cows[n-1] == 1)
			suffix[n-1]++;
		for (int i = n-2; i >= 0; i--)
		{
			suffix[i] += suffix[i+1];
			if (cows[i]==1)
				suffix[i]++;
		}
		int [] arr = new int[n+1];
		for (int i = 0; i < n+1; i++)
		{
			if (i == 0)
				arr[i]+= suffix[i];
			else if (i == n)
				arr[i] += prefix[i-1];
			else
			{
				arr[i]+=suffix[i];
				arr[i]+=prefix[i-1];
			}
		}
		Arrays.sort(arr);
		System.out.println(arr[0]);
				
	}
	
}
