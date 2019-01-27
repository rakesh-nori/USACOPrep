import java.util.*;
public class Fence 
{
	private int[][] pref;
	public static int all [];
	
	
	public int[] updateStacks(int [] stacks)
	{
		int change = 0;
		for (int i = 0; i < stacks.length; i++)
		{
			change += pref[i][1];
			stacks[i] = change;
		}
		return stacks;
	}
	public void give(int n, int[][] instruct)
	{
		pref = new int [n+1][2];
		for (int ind = 0; ind < n+1; ind++)
		{
			pref[ind][0] = all[ind];
			pref[ind][1] = 0;
		}
		for (int i = 0; i < instruct.length;i++)
		{
			boolean found = false;
			int index = 0;
			while (!found)
			{
				if (pref[index][0] == instruct[i][0])
				{
					pref[index][1]++;
					found = true;
				}
				else
					index++;
			}
			boolean second = false;
			int sendex = 0;
			while (!second)
			{
				if (pref[sendex][0] == instruct[i][1])
				{
					pref[sendex+1][1]--;
					second = true;
				}
				else
					sendex++;
			}
			
		}
		int [] after = new int[n+1];
		int count = 0;
		after = updateStacks(after);
		for (int i = 0; i < n; i++)
		{
			if (after[i] >= 2)
			{
				count += (pref[i+1][0] - pref[i][0]+1); 
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
		all = new int[2 * n+1];
		for (int i = 0; i < n; i++)
		{
			
			if (locs[i+1] >= locs[i])
			{
				instructions[i][0] = locs[i];
				instructions[i][1] = locs[i+1] - 1;
				all[2*i] = locs[i];
				all[2*i+1] = locs[i+1] - 1;
			}
			else
			{
				instructions[i][0] = locs[i+1];
				instructions[i][1] = locs[i] - 1;
				all[2*i] = locs[i+1];
				all[2*i+1] = locs[i] - 1;
			}
		}
		Arrays.sort(all);
		Fence f = new Fence();
		f.give(instructions.length * 2, instructions);
		
	}
}
