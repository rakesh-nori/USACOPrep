/**
import java.io.*;
import java.util.*;
public class snowboots 
{
	public static void main(String [] args) throws IOException
	{
		//Scanner sc = new Scanner(new FileReader("snowboots.in"));
		Scanner sc = new Scanner(System.in);
		//PrintWriter pw = new PrintWriter(new File("snowboots.out"));
		int n = sc.nextInt();
		int b = sc.nextInt();
		int [] path = new int[n];
		Queue<Boot> boots = new LinkedList<Boot>();
		for (int i = 0; i < n; i++)
		{
			path[i] = sc.nextInt();
		}
		for (int i = 0; i < b; i++)
		{
			Boot a = new Boot(sc.nextInt(), sc.nextInt());
			boots.add(a);
		}
		int discard = 0;
		int loc = 0;
		while (loc != n-1)
		{
			Boot curr = boots.peek();
			int s = curr.s;
			int d = curr.d;
			//System.out.println(d);
			int val = 1;
			boolean canStep = false;
			while (val <= d && !canStep)
			{
				//System.out.println(loc + val);
				//System.out.println(path[loc+val]);
				if (loc + val < n && path[loc + val] <= s)
				{
					//System.out.println("I stepped");
					canStep = true;
					loc = loc + val;
				}
				else
					val++;
			}
			if (!canStep)
			{
				//System.out.println(s);
				//System.out.println(d);
				//System.out.println(path[loc]);
				boots.remove();
				//System.out.println("ok");
				discard++;
				while (boots.peek().s < path[loc])
				{
					//System.out.println("ok");
					boots.remove();
					discard++;
				}
			}
		}
		//pw.println(discard);
		System.out.println(discard);
		//pw.close();
		sc.close();
		
	}
	static class Boot
	{
		public  int s;
		public  int d;
		public Boot(int x, int y)
		{
			s = x;
			d = y;
		}
	}
}
**/
import java.io.*;
import java.util.*;
public class snowboots
{
	public static void main(String [] args) throws IOException
	{
		
	}
}

