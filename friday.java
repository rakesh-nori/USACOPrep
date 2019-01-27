/*
ID: 20rakes1
LANG: JAVA
TASK: friday
 */
import java.util.*;
import java.io.*;
public class friday
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("friday.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new FileWriter("friday.out"));
		int day = 1;
		Day [] week = new Day[7];
		week[2] = new Day("Monday");
		week[3] = new Day("Tuesday");
		week[4] = new Day("Wednesday");
		week[5] = new Day("Thursday");
		week[6] = new Day("Friday");
		week[0] = new Day("Saturday");
		week[1] = new Day("Sunday");
		int month = 1;
		int year = 1900;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int stop = year + Integer.parseInt(st.nextToken()) - 1;
		int ind = 2;
		while (year != stop+1)
		{
			if (day == 13)
				week[ind].val ++;
			ind ++;
			if (ind == 7)
				ind = 0;
			day++;
			if (day == 29)
			{
				if (month == 2 && !isLeapYear(year))
				{
					month ++;
					day = 1;
				}
			}
			else if (day == 30 && month == 2 && isLeapYear(year))
			{
				//System.out.println(year);
				month++;
				day = 1;
			}
			else if (day == 31 && (month == 9 || month == 4 || month == 6 || month == 11))
			{
				month++;
				day = 1;
			}
			else if (day == 32)
			{
				month++;
				day = 1;
			}
			if (month == 13)
			{
				year ++;
				month = 1;
				day = 1;
			}
		}
		for (int i = 0; i < 7; i++)
		{
			if (i != 6)
				pw.print(week[i].val + " ");
			if (i == 6)
				pw.print(week[i].val);
		}
		pw.println();
		pw.close();
		br.close();
	}
	public static boolean isLeapYear(int yr)
	{
		if (yr % 100 == 0)
			return yr % 400 == 0;
		else
			return yr % 4 == 0;	
	}
	public static class Day
	{
		public String d;
		public int val;
		public Day(String da)
		{
			d = da;
			val = 0;
		}
	}
}

