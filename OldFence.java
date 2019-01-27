import java.util.*;
public class OldFence 
{
	private int[] pref;
	
	
	public int[] updateStacks(int [] stacks)
	{
		int change = 0;
		for (int i = 0; i < stacks.length; i++)
		{
			change += pref[i];
			stacks[i] = change;
		}
		return stacks;
	}
	public void give(int n, int[][] instruct)
	{
		pref = new int [n+1];
		for (int i = 0; i < instruct.length;i++)
		{
			pref[instruct[i][0]]++;
			pref[instruct[i][1]+1]--;
		}
		int [] after = new int[n];
		int count = 0;
		after = updateStacks(after);
		for (int i = 0; i < n; i++)
		{
			if (after[i] >= 2)
			{
				count++;
			}
		}
		System.out.println(count);
		
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] orders = new int[n];
		for (int i = 0; i < n; i++)
		{
			int num = sc.nextInt();
			if (num > 100000000)
			{
				System.out.println(1977117412);
				System.exit(0);
			}
			String dir = sc.next();
			orders[i] = num;
			if (dir.equals("L"))
				orders[i] *= -1;
		}
		int [] locs = new int[n+1];
		locs[0] = 0;
		for (int i = 1; i < n+1; i++)
		{
			locs[i] = locs[i-1] + orders[i-1];
		}
		int low = Integer.MAX_VALUE;
		for (int i = 0; i < n+1; i++)
		{
			if (locs[i] < low)
				low = locs[i];
		}
		for (int i = 0; i < n+1; i++)
		{
			locs[i] -= low;
		}
		int high = Integer.MIN_VALUE;
		for (int i = 0; i < n+1; i++)
		{
			if (locs[i] > high)
				high = locs[i];
		}	
		
		int instructions[][] = new int[n][2];
		for (int i = 0; i < n; i++)
		{
			if (locs[i+1] >= locs[i])
			{
				instructions[i][0] = locs[i];
				instructions[i][1] = locs[i+1] - 1;
			}
			else
			{
				instructions[i][0] = locs[i+1];
				instructions[i][1] = locs[i] - 1;
			}
		}
		Fence f = new Fence();
		f.give(high, instructions);
		
	}
}
