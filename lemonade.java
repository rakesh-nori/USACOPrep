import java.io.*;
import java.util.*;
public class lemonade
{
	public static void main(String [] args) throws IOException
	{
		//Scanner sc = new Scanner("lemonade.in");
		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new FileWriter("lemonade.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];
		StringTokenizer s = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(s.nextToken());
		Arrays.sort(arr);
	    int [] actu = new int[n];
	    for (int i = 0; i < n; i++)
	    	actu[i] = arr[n-i-1];
	    int count = 0;
		for (int i = 0; i < n; i++)
		{
			if (actu[i] >= i)
				count++;
			else
				break;
		}
		//System.out.println(count);
		pw.println(count);
		br.close();
		pw.close();
	}
}
