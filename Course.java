import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Course 
{
	public static int n;
	public static int m;
	public static int [] e;
	public static int [] h;
	public static int[] avg;
	public static int[] next;
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("course.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		next = new int[n];
		avg = new int[n];
		e = new int[n];
		StringTokenizer s = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
		{
			e[i] = Integer.parseInt(s.nextToken());
		}
		h = new int[m];
		StringTokenizer t = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
		{
			h[i] = Integer.parseInt(t.nextToken());
		}
		for (int i = 0; i < n; i++)
		{
			int curr = h[i];
			for (int j = 0; j < m; j++)
			{
				next[i] = -1;
				if (h[j] >= curr)
				{
					next[i] = j;
					break;
				}
			}
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
				int nt = next[index];
				if (nt == -1)
				{
					avg[i] = m;
					break;
				}
				else
				{
					avg[i] += (nt - index);
					index = nt;
				}
				
			}
		}
		double total = 0;
		for (int i = 0; i < n; i++)
			total += avg[i];
		System.out.println(total / n);
	}
}
