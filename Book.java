import java.util.Scanner;

public class Book 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		String [] phrases = new String[m];
		sc.nextLine();
		for (int i = 0; i < m; i++)
		{
				phrases[i] = sc.nextLine();
		}
		String [] given = new String[n];
		for (int i = 0; i < n; i++)
		{
				given[i] = sc.nextLine();
		}
		int count = 0;
		for (int i = 0; i < given.length; i++)
		{
			for (int j = 0; j < phrases.length; j++)
			{
				if (phrases[j].indexOf(given[i])==0)
				{
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
