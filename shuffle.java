import java.util.*;
import java.io.*;

public class shuffle
{
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new File("shuffle.out"));
		int n = sc.nextInt();
		int [] cows = new int[n]; 
		int loc[] = new int[n];
		for (int i = 0; i < n; i++)
		{
			loc[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++)
		{
			cows[i] = sc.nextInt();
		}
		for (int i = 0; i < 3; i++)
		{
			int [] temp = new int[n];
			for (int a = 0; a < n; a++)
			{
				temp[a] = cows[loc[a] - 1];
			}
			cows = temp;
		}
		for (int i = 0; i < cows.length; i++)
			pw.println(cows[i]);
		pw.close();
		sc.close();
	}
}
