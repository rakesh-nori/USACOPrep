import java.util.Scanner;

public class BCount 
{
	private int pref[][];
	public void createPref(int[][] nums)
	{
		pref = new int[nums.length+1][3];
		pref[0][0]= 0;
		pref[0][1] = 0;
		pref[0][2] = 0;
		for (int i = 1; i < pref.length; i++)
		{
			pref[i][0] = pref[i-1][0] + nums[i-1][0];
			pref[i][1] = pref[i-1][1]+nums[i-1][1];
			pref[i][2] = pref[i-1][2] + nums[i-1][2];
		}
		
	}
	
	public void printPref(int a, int b)
	{
		int hol = pref[b][0] - pref[a-1][0]; 
		int gue = pref[b][1] - pref[a-1][1]; 
		int jer = pref[b][2] - pref[a-1][2]; 
		System.out.println(hol + " " + gue + " " + jer);
	}
	
	public void getBreeds(int [][]cows, int q, int[][]queries)
	{
		createPref(cows);
		for (int i = 0; i < q; i++)
		{
			printPref(queries[i][0], queries[i][1]);
		}
		
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int [][] cows = new int[n][3];
		for (int i = 0; i < n; i++)
		{
			int num = sc.nextInt();
			if (num == 1)
				cows[i][0] = 1;
			else if (num == 2)
				cows[i][1] = 1;
			else if (num == 3)
				cows[i][2] = 1;
		}
		int [][] queries = new int[q][2];
		for (int i = 0; i < q; i++)
		{
			queries[i][0] = sc.nextInt();
			queries[i][1] = sc.nextInt();
		}
		BCount b = new BCount();
		b.getBreeds(cows, q, queries);
		
		
		
	}
	
	
	

}
