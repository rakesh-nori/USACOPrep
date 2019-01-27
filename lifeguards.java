import java.util.*;
import java.io.*;
public class lifeguards 
{
	public static void main(String [] args) throws IOException
	{
		int covered[] = new int[1001];
		//Scanner sc = new Scanner(new FileReader("lifeguards.in"));
		Scanner sc = new Scanner(System.in);
		//PrintWriter pw = new PrintWriter(new File("lifeguards.out"));
		int n = sc.nextInt();
		int [][] times = new int[n][2];
		for (int i = 0; i < n; i++)
		{
			int begin = sc.nextInt();
			int end = sc.nextInt();
			times[i][0] = begin;
			times[i][1] = end;
			for (int a = begin; a < end; a++)
			{
				covered[a]++;
			}
		}
		int maxWatched = 0;
		for (int i = 0; i < n; i++)
		{
			int watched = 0;
			for (int a = times[i][0]; a < times[i][1]; a++)
			{
				covered[a]--;
			}
			for (int a = 0; a< 1001; a++)
			{
				if (covered[a] > 0)
					watched++;
			}
			if (watched > maxWatched)
				maxWatched = watched;
			for (int a = times[i][0]; a < times[i][1]; a++)
			{
				covered[a]++;
			}
			
		}
		System.out.println(maxWatched);
		//pw.println(maxWatched);
		sc.close();
		//pw.close();
	}
}
