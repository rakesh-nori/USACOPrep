/*
ID: 20rakes1
LANG: JAVA
TASK: ride
 */
import java.util.*;
import java.io.*;
public class ride 
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("ride.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("ride.out"));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int fVal = 1;
		for (int i = 0; i < s1.length(); i++)
		{
			String curr = s1.substring(i, i+1);
			if (curr.equals("A"))
				fVal *= 1;
			else if (curr.equals("B"))
				fVal *= 2;
			else if (curr.equals("C"))
				fVal *= 3;
			else if (curr.equals("D"))
				fVal *= 4;
			else if (curr.equals("E"))
				fVal *= 5;
			else if (curr.equals("F"))
				fVal *= 6;
			else if (curr.equals("G"))
				fVal *= 7;
			else if (curr.equals("H"))
				fVal *= 8;
			else if (curr.equals("I"))
				fVal *= 9;
			else if (curr.equals("J"))
				fVal *= 10;
			else if (curr.equals("K"))
				fVal *= 11;
			else if (curr.equals("L"))
				fVal *= 12;
			else if (curr.equals("M"))
				fVal *= 13;
			else if (curr.equals("N"))
				fVal *= 14;
			else if (curr.equals("O"))
				fVal *= 15;
			else if (curr.equals("P"))
				fVal *= 16;
			else if (curr.equals("Q"))
				fVal *= 17;
			else if (curr.equals("R"))
				fVal *= 18;
			else if (curr.equals("S"))
				fVal *= 19;
			else if (curr.equals("T"))
				fVal *= 20;
			else if (curr.equals("U"))
				fVal *= 21;
			else if (curr.equals("V"))
				fVal *= 22;
			else if (curr.equals("W"))
				fVal *= 23;
			else if (curr.equals("X"))
				fVal *= 24;
			else if (curr.equals("Y"))
				fVal *= 25;
			else if (curr.equals("Z"))
				fVal *= 26;
		}
		int sVal = 1;
		for (int i = 0; i < s2.length(); i++)
		{
			String curr = s2.substring(i, i+1);
			if (curr.equals("A"))
				sVal *= 1;
			else if (curr.equals("B"))
				sVal *= 2;
			else if (curr.equals("C"))
				sVal *= 3;
			else if (curr.equals("D"))
				sVal *= 4;
			else if (curr.equals("E"))
				sVal *= 5;
			else if (curr.equals("F"))
				sVal *= 6;
			else if (curr.equals("G"))
				sVal *= 7;
			else if (curr.equals("H"))
				sVal *= 8;
			else if (curr.equals("I"))
				sVal *= 9;
			else if (curr.equals("J"))
				sVal *= 10;
			else if (curr.equals("K"))
				sVal *= 11;
			else if (curr.equals("L"))
				sVal *= 12;
			else if (curr.equals("M"))
				sVal *= 13;
			else if (curr.equals("N"))
				sVal *= 14;
			else if (curr.equals("O"))
				sVal *= 15;
			else if (curr.equals("P"))
				sVal *= 16;
			else if (curr.equals("Q"))
				sVal *= 17;
			else if (curr.equals("R"))
				sVal *= 18;
			else if (curr.equals("S"))
				sVal *= 19;
			else if (curr.equals("T"))
				sVal *= 20;
			else if (curr.equals("U"))
				sVal *= 21;
			else if (curr.equals("V"))
				sVal *= 22;
			else if (curr.equals("W"))
				sVal *= 23;
			else if (curr.equals("X"))
				sVal *= 24;
			else if (curr.equals("Y"))
				sVal *= 25;
			else if (curr.equals("Z"))
				sVal *= 26;
		}
		boolean go = (sVal % 47 == fVal % 47);
		if (go)
			pw.println("GO");
		else
			pw.println("STAY");
		pw.close();
		br.close();

	}
}
