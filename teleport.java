import java.io.*;
import java.util.*;
public class teleport 
{
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("teleport.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new File("teleport.out"));
		int n = sc.nextInt();
		int maxStart = 0;
		int maxEnd = 0;
		int [][] dung = new int[n][2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
		{
			dung[i][0] = sc.nextInt();
			if (Math.min(dung[i][0], min) == dung[i][0])
				min = dung[i][0];
			if (Math.max(dung[i][0], max) == dung[i][0])
				max = dung[i][0];
			dung[i][1] = sc.nextInt();
			if (Math.min(dung[i][1], min) == dung[i][1])
				min = dung[i][1];
			if (Math.max(dung[i][1], max) == dung[i][1])
				max = dung[i][1];
		}
		int [] arr  = new int[max - min+1];
		for (int i = 0; i < n; i++)
		{
			int start = dung[i][0] - (min);
			int end = start + (dung[i][1] - dung[i][0]);
			int maxVal = 0;
			boolean foundms = false;
			boolean foundme = false;
			if (end > start)
			{
				for (int a = start; a <= end-1; a++)
				{
					arr[a] += 1;
					if (arr[a] > maxVal && !foundms)
					{
						maxVal = arr[a];
						foundms = true;
						maxStart = a;
					}
					if (arr[a] == maxVal && arr[a+1] < maxVal &&!foundme)
					{
						foundme = true;
						maxEnd = a;
					}
				}
			}
			else
			{
				for (int a = end; a <= start; a++)
				{
					arr[a] += 1;
					if (arr[a] > maxVal && !foundms)
					{
						maxVal = arr[a];
						foundms = true;
						maxStart = a;
					}
					if (arr[a] == maxVal && arr[a+1] < maxVal &&!foundme)
					{
						foundme = true;
						maxEnd = a;
					}
				}
			}
				
		}
		int y = 0;
		long distance = 0;
		if (Math.abs(maxStart) > Math.abs(maxEnd))
			y = maxStart;
		else
			y = maxEnd;
		y -= min;
		for (int i = 0; i < n; i++)
		{
			//int start = dung[i][0] - (-100000000);
			//int end = start + (dung[i][1] - dung[i][0]);
			//System.out.println("AAA " + dung[i][0]);
			//System.out.println("ZZZ " + dung[i][1]);
			if (Math.abs(dung[i][1] - dung[i][0]) < (Math.abs(0 - dung[i][0]) + Math.abs(dung[i][1] - y)))
			{ 
				distance += Long.valueOf(Math.abs(dung[i][1] - dung[i][0]));
			}
			else
				distance += Long.valueOf((Math.abs(0 - dung[i][0]) + Math.abs(dung[i][1] - y)));
				
		}
		//System.out.println(distance);
		pw.println(distance);
	}
}
