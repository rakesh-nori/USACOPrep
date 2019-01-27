import java.io.*;
import java.util.*;
public class reststops 
{
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("reststops.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new File("reststops.out"));
		int length = sc.nextInt();
		int n = sc.nextInt();
		int rf = sc.nextInt();
		int rb = sc.nextInt();
		int deltar = rf- rb;
		long [][] stops = new long[n][2];
		long max = 0;
		long tasty = 0;
		long maxloc = 0;
		long arrloc = 0;
		for (int i = 0; i < n; i++)
		{
			long a = Long.valueOf(sc.nextInt());
			long b = Long.valueOf(sc.nextInt());
			if (b > max)
			{
				max = Long.valueOf(b);
				maxloc = Long.valueOf(a);
				arrloc = Long.valueOf(i);
			}
			stops[i][0] = a;
			stops[i][1] = b;
		}
		tasty += maxloc * Long.valueOf(deltar) * max;
		
		while (arrloc + 1 < n)
		{
			long m = 0;
			long ml = 0;
			long al = 0;
			for (int i = (int)arrloc + 1; i < n; i++)
			{
				if (stops[i][1] >= m)
				{
					m = stops[i][1];
					ml = stops[i][0];
					al = i;
				}
			}
			//if (m == Integer.MIN_VALUE)
				//break;
			tasty += (ml-maxloc)*Long.valueOf(deltar)*m;
			maxloc = ml;
			arrloc = al;
		}
		//System.out.println(tasty);
		pw.println(tasty);
		pw.close();
		sc.close();
	}
}
