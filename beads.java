/*
 ID: 20rakes1
LANG: JAVA
TASK: beads
 */
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class beads 
{
	public static void main (String [] args) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("beads.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("beads.out"));
		int n = sc.nextInt();
		String lace = sc.next();
		int [] counts = new int[n];
		for (int index = 0; index < n; index++)
		{
			boolean rDiff = false;
			int left = 0;
			boolean lDiff = false;
			int lindex = index-1;
			if (lindex < 0)
			{
				lindex = n-1;
			}
			int inlin = lindex;
			String lSub = lace.substring(lindex, lindex+1);
			while (!lDiff)
			{
				if (!lSub.equals("w"))
				{
					if (!(lace.substring(lindex, lindex+1).equals(lSub))&&!(lace.substring(lindex, lindex+1).equals("w")))
					{
						lindex+=2;
						lDiff = true;
					}
					else
					{
						left++;
					}	
				}
				else
				{
					left++;
					lSub = lace.substring(lindex, lindex+1);
				}
				lindex --;
				if (lindex < 0)
					lindex = n-1;
				if (inlin == lindex)
				{
					rDiff = true;
					break;
				}
			}
			int rindex = index;
			int inrin = rindex;
			int right = 0;
			String rSub = lace.substring(rindex, rindex+1);
			while (!rDiff)
			{
				if (rindex >= n)
					rindex = 0;
				if (!rSub.equals("w"))
				{
					if (!lace.substring(rindex, rindex+1).equals(rSub)&&!(lace.substring(rindex, rindex+1).equals("w")))
					{
						rDiff = true;
					}
					else
					{
						right++;
					}
				}
				else
				{
					right++;
					rSub = lace.substring(rindex, rindex+1);
				}
				rindex ++;
				if (rindex >= n)
					rindex = 0;
				if (rindex == lindex)
				{
					break;
				}
			}
			counts[index] = left + right;
		}
		Arrays.sort(counts);
		pw.println(counts[n-1]);
		pw.close();
		sc.close();
	}
}
