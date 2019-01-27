import java.util.Arrays;
import java.util.Scanner;

public class Reduce 
{

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pt [] cows  = new Pt[n];
		for (int i = 0; i < n; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			cows[i] = new Pt(x, y);
		}
		Reduce red = new Reduce();
		red.giveOptimal(cows);
			
	}
}

class Pnto implements Comparable<Pnt>
{
	public int x, y;
	public boolean remove;
	
	public int compareTo (Pnto other)
	{
		return 0;
	}
}
