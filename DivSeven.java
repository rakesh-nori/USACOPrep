import java.util.Scanner;

public class DivSeven 
{
	private int pref[];
	public void createPref(int [] nums)
	{
		pref = new int[nums.length+1];
		pref[0] = 0;
		for (int i = 1; i < pref.length; i++)
		{
			pref[i] = pref[i-1] + nums[i-1];
		}
		for (int i = 1; i < pref.length; i++)
		{
			pref[i] = pref[i] % 7;
		}
	}
	
	public void findMods(int[]cows)
	{
		createPref(cows);
		int earliest = 0;
		int latest = 0;
		int [] results = new int[7];
		for (int k = 0; k < 7; k++)
		{
			earliest = 0;
			latest = 0;
			for (int i = 1; i < pref.length; i++)
			{
				if (pref[i] == k)
				{
					earliest = i;
					break;
				}
			}
			for (int i = pref.length-1; i >= 1; i--)
			{
				if (pref[i] == k)
				{
					latest = i;
					break;
				}
			}
			results[k] = latest-earliest;
		}
		int max = 0;
		for (int i = 0; i < results.length; i++)
		{
			if (max < results[i])
				max = results[i];
		}
		System.out.println(max);
		
	}
	
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] cows = new int[n];
		for (int i = 0; i < n; i++)
		{
			cows[i] = sc.nextInt();
		}
		DivSeven sev = new DivSeven();
		sev.findMods(cows);
	}
}
