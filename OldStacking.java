import java.util.Arrays;
import java.util.Scanner;
public class OldStacking 
{
	int [] arr;
	public void giveMed(int n, int[][] instruct)
	{
		arr = new int[n];
		for (int i = 0; i < instruct.length; i++)
		{
			for (int j = instruct[i][0]; j <= instruct[i][1]; j++)
				arr[j-1]++;
		}
		Arrays.sort(arr);
		System.out.println(arr[n/2]);
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [][] instruct = new int[k][2];
		for (int i = 0; i < k; i++)
		{
			instruct[i][0] = sc.nextInt();
		    instruct[i][1] = sc.nextInt();
		}
		//Arrays.sort(instruct, new cmp());
		OldStacking stack  = new OldStacking();
		stack.giveMed(n, instruct);
	}
}
