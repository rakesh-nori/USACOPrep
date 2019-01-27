import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;

public class ScCourse 
{
	public static int n;
	public static int m;
	public static int [] e;
	public static int [] h;
	public static int[] avg;
	public static int next(int index)
	{
		int i = index+1;
		while (i < m)
		{
			if (h[i] >= h[index])
			{
				return i;
			}
			i++;
		}
		return -1;
	}
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		avg = new int[n];
		e = new int[n];
		for (int i = 0; i < n; i++)
		{
			e[i] = sc.nextInt();
		}
		h = new int[m];
		for (int i = 0; i < m; i++)
		{
			h[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++)
		{
			int curr = e[i];
			int index = 0;
			while (curr >= 0 && index < m)
			{
				curr -= h[index];
				if (curr < 0)
					break;
				int next = next(index);
				if (next == -1)
				{
					avg[i] = m;
					break;
				}
				else
				{
					avg[i] += (next - index);
					index = next;
				}
				
			}
		}
		double total = 0;
		for (int i = 0; i < n; i++)
			total += avg[i];
		System.out.println(total / n);
	}
}
