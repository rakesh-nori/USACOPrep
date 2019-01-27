import java.io.*;
import java.util.*;

public class billboard 
{
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("billboard.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new File("billboard.out"));
		int [][] coords = new int[4][2];
		int loc = 0;
		for (int i = 0; i < 2; i++)
		{
			coords[loc][0] = sc.nextInt();
			coords[loc][1] = sc.nextInt();
			loc++;
		    coords[loc][0] = sc.nextInt();
			coords[loc][1] = sc.nextInt();
			loc++;
		}
		int area = area(coords[0][0], coords[0][1], coords[1][0], coords[1][1]);
		int answer = 0;
		boolean falta = false;
		if ((coords[3][1] > coords[0][1] && coords[3][1] >= coords[1][1] && coords[2][1] <= coords[0][1]))
		{
			int left = coords[0][0];
			int right = coords[1][0];
			if (coords[3][0] > coords[0][0])
			{
				if (coords[2][0] > coords[0][0] && coords[2][0] < coords[1][0])
					left = coords[2][0];
				if (coords[3][0] < coords [1][0])
				{
					if (coords[2][0] > coords[0][0])
					{
						answer = area;
						falta = true;
					}
					else
						right = coords[3][0];
				}
				int tarp = (right - left) * (coords[1][1] - coords[0][1]);
				if (!(answer == area))
					answer = tarp;	 
			}
			else
			{
				answer = area;
				falta = true;
			}
		}
		else if ((coords[3][0] > coords[0][0] && coords[3][0] >= coords[1][0] && coords[2][0] <= coords[0][0]))
		{
			int bottom = coords[0][1];
			int top = coords[1][1];
			if (coords[3][1] > coords[0][1])
			{
				if (coords[2][1] > coords[0][1] && coords[2][1] < coords[1][1])
					bottom = coords[2][1];
				if (coords[3][1] < coords [1][1])
				{
					if (coords[2][1] > coords[0][1])
					{
						answer = area;
						falta = true;
					}
					else
						top = coords[3][1];
				}
				int tarp = (top - bottom) * (coords[1][0] - coords[0][0]);
				if (!(answer == area))
					answer = tarp;	 
			}
			else
			{
				answer = area;
				falta = true;
			}
		}
		else
		{
			falta = true;
			answer = area;
		}
		if (answer != area)
			answer = area - answer;
		if (answer == area && !falta)
			answer = 0;
		pw.println(answer);
		pw.close();
		sc.close();
	}
			
		/**
		 * 
		 
		int firstA = area(coords[0][0], coords[0][1], coords[1][0], coords[1][1]);
		int secondA = area(coords[2][0], coords[2][1], coords[3][0], coords[3][1]);
		int initial = firstA + secondA;
		int rLength = 0;
		if (coords[5][0] > coords[2][0])
		{
			int bottom = coords[2][0];
			if (coords[4][0] > coords[2][0])
				bottom = coords[4][0];
			if (coords[5][0] > coords[3][0])
			{
				if (coords[4][0] > coords[3][0])
					rLength = 0;
				else
					rLength = coords[3][0] - bottom;
			}
			else 
				rLength = coords[5][0] - bottom;
		}
		int rHeight = 0;
		if (coords[5][1] > coords [2][1])
		{
			int bottom = coords[2][1];
			if (coords[4][1] > coords[2][1])
				bottom = coords[4][1];
			if (coords[5][1] > coords[3][1])
			{
				if (coords[4][1] > coords[3][1])
					rHeight = 0;
				else
					rHeight = coords[3][1] - bottom;
			}
			else 
				rHeight = coords[5][1] - bottom;
		}
		initial -= Math.abs((rLength * rHeight));
		int length = 0;
		if (coords[4][0] < coords[1][0])
		{
			int front = coords[1][0];
			if (coords[5][0] < coords[1][0])
				front = coords[5][0];
			if (coords[4][0] < coords[0][0])
			{
				if (coords[5][0] < coords[0][0])
					length = 0;
				else
					length = front - coords[0][0];
			}
			else
				length =  front - coords[4][0];
		}
		int height = 0;
		if (coords[5][1] > coords[0][1])
		{
			int bottom = coords[0][1];
			if (coords[4][1] > bottom)
				bottom = coords[4][1];
			if (coords[5][1] > coords[1][1])
			{
				height = coords[1][1] - bottom;
			}
			else
				height = coords[5][1] - bottom;
		}
		initial -= Math.abs((length * height));
		//pw.println(initial);
		//pw.close();
		sc.close();
	}
	*/
	public static int area(int x1, int y1, int x2, int y2)
	{
		return Math.abs((x2-x1) * (y2-y1));
	}
}


