
import java.util.Scanner;

public class HayExp 
{
	public void giveQuery(int len, int queries, int[]baleCounts, int []queryBounds)
	{
		int[] pref = new int[len+1];
		pref[0] = 0;
		for (int i = 1; i < len+1; i++)
		{
			pref[i] = pref[i-1] + baleCounts[i-1];
		}
		for (int i = 0; i < queryBounds.length; i+=2)
		{
			int result = pref[queryBounds[i+1]] - pref[(queryBounds[i]-1)];
			System.out.println(result);
		}
	}	
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int numQs = sc.nextInt();
		int[] bales = new int[len];
		for (int i = 0; i < len; i++)
		{
			bales[i] = sc.nextInt();
		}
		int [] queryBounds = new int[numQs*2];
		for (int i = 0; i < queryBounds.length; i++)
		{
			queryBounds[i] = sc.nextInt();
		}
		HayExp hay = new HayExp();
		//int[] tokens = {5, 8, 12, 6};
		//int[] queries = {1, 3, 2, 4}; 
		hay.giveQuery(len, numQs, bales, queryBounds);
		
	}
	

}
