import java.util.*;
import java.io.*;

public class Stroll 
{
	public static int[][]vals;
	public static int max;
	public static boolean vis[];
	public static void recurse(int cur, int dep)
	{
		if (cur == 0)
		{
			if (dep > max)
				max = dep;
			return;
		}
		if (vis[cur-1])
			return;
		vis[cur-1] = true;
		for (int i = 0; i < vals[cur-1].length; i++)
		{
			int next = vals[cur-1][i];
			recurse(next, dep+1);
		}
		
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		vals = new int[p-1][2];
		for (int r = 0; r< p-1; r++)
		{
			int n = sc.nextInt();
			int d = sc.nextInt();
			int c = sc.nextInt();
			vals[n-1][0] = d;
			vals[n-1][1] = c;
		}
		vis = new boolean [p-1];
		max = 0;
		
		recurse(1, 0);
		System.out.println(max);
	}
}
