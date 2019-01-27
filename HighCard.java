import java.util.Arrays;
import java.util.Scanner;

public class HighCard 
{
	public void calcPoints(int n, int [] elsie)
	{
		int [] bessie = new int[n];
		int index = 0;
		int eIndex = 0;
		boolean found = false;
		for (int i = 1; i <= 2*n; i++)
		{
			if (elsie[eIndex] != i)
			{
				bessie[index] = i;
				index++;
			}
			else
			{
				eIndex++;
				if (eIndex == elsie.length)
				{
					if (index < n)
					{
						if (i <= 2*n)
						{
							while (i <= 2*n && index < bessie.length)
							{
								bessie[index] = i+1;
								index++;
								i++;
							}
						}
						
					}	
					break;
				}
			}
		}
		int findex = 0;
		int sindex = 0;
		int points = 0;
		for (int i = 0; i < elsie.length; i++)
		{
			if (elsie[findex] < bessie[sindex])
			{
				points++;
				sindex++;
				findex++;
			}
			else
			{
				sindex++;
			}
			if (sindex >= bessie.length)
				break;
		}
		System.out.println(points);
		
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] elsie = new int[n];
		for (int i = 0; i < n; i++)
			elsie[i] = sc.nextInt();
		Arrays.sort(elsie);
		HighCard bessie = new HighCard();
		bessie.calcPoints(n, elsie);
		
	}
}
