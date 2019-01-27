import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScanDream 
{
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] h = new int[n];
		int maxdex = 0;
		int maxNum = 0;
		for (int i = 0; i < n; i++)
		{
			h[i] = sc.nextInt();
			if (h[i] > maxNum)
			{
				maxNum = h[i];
				maxdex = i;
			}
		}
		if (maxdex == n-1)
		{
			int max = h[0];
			int count = 0;
			for (int i = 1; i < n; i++)
			{
				if (h[i] >= max)
					max = h[i];
				else
				{
					count += (max -h[i]);
				}
			}
			System.out.println(count);
		}
		else if (maxdex == 0)
		{
			int max = h[n-1];
			int count = 0;
			for (int i = n-2; i >= 0; i--)
			{
				if (h[i] >= max)
					max = h[i];
				else
					count += (max - h[i]);
			}
			System.out.println(count);
		}
		else{
			int max = h[0];
			int count = 0;
			for (int i = 1; i < maxdex; i++)
			{
				if (h[i] >= max)
					max = h[i];
				else
				{
					count += (max -h[i]);
				}
			}
			int othermax = h[n-1];
			for (int i = n-2; i > maxdex; i--)
			{
				if (h[i] >= othermax)
					othermax = h[i];
				else
				{
					count += (othermax -h[i]);
				}
			}
			System.out.println(count);
		}
	}
}
