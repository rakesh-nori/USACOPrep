import java.util.Arrays;
import java.util.Scanner;
public class Stacking 
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
	public void giveMed(int n, int[][] instruct)
	{
		pref = new int [n+1];
		for (int i = 0; i < instruct.length;i++)
		{
			pref[instruct[i][0]]++;
			pref[instruct[i][1]+1]--;
		}
		int [] after = new int[n];
		after = updateStacks(after);
		Arrays.sort(after);
		System.out.println(after[n/2]);
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [][] instruct = new int[k][2];
		for (int i = 0; i < k; i++)
		{
			instruct[i][0] = sc.nextInt()-1;
		    instruct[i][1] = sc.nextInt()-1;
		}
		Stacking stack  = new Stacking();
		stack.giveMed(n, instruct);
	}
}

