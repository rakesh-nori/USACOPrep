import java.util.*;
import java.io.*;

public class measurement 
{
	public static void main(String[]args) throws IOException
	{
		int[][] time = new int[101][3];
		Scanner sc = new Scanner(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new File("measurement.out"));
		//Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//System.out.println(n);
		int occurence = 0;
		while (sc.hasNextLine())
		{
			String s = sc.nextLine();
			if (occurence == 0)
			{
			
			}
			else
			{
				//System.out.println(s.substring(0, 1));
				int num = Integer.parseInt(s.substring(0, 1));
			//	System.out.println(s.substring(1, 2) == " ");
				if (!s.substring(1, 2).equals(" "))
				{ 
					num *= 10;
					num += Integer.parseInt(s.substring(1,2));
				}
				if (s.substring(2,3).equals("0"))
				{
					num *= 10;
					num += Integer.parseInt(s.substring(2,3));
				}
				//System.out.println(num);
				int locSign = s.indexOf("-");
				if (locSign == -1)
					locSign = s.indexOf("+");
				int secondNum = Integer.parseInt(s.substring(locSign));
				//System.out.println(secondNum);
				if (s.indexOf("Bes") != -1)
				{
					time[num][0] += secondNum;
				}
				else if (s.indexOf("Els") != -1)
				{
					time[num][1] += secondNum;
				}
				else
					time [num][2] += secondNum;
			}
			occurence++;
			if (occurence == n+1)
				break;
		}
		int a = 0;
		int b = 0; 
		int c = 0;
		int change = 0;
		int prev = 0;
		prev = 19;
		for (int i = 1; i < time.length; i++)
		{
			a += time[i][0];
			b += time[i][1];
			c += time[i][2];
			int curr = 0;
			int newVal = Math.max(c, Math.max(a, b));
			if (newVal == a)
				curr += 1;
			if (newVal == b)
				curr += 7;
			if (newVal == c)
				curr += 11;
			if (curr != prev)
			{
				change++;
			}
			prev = curr;
			
		}
		pw.println(change);
		sc.close();
		pw.close();
	}
	
}
