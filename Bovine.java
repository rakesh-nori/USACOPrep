import java.util.Scanner;

public class Bovine 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] cows = new int[n];
		for (int i = 0; i < n; i++)
			cows[i] = i+1;
		boolean [] tagged = new boolean[n];
		boolean gameOver = false;
		int curr = 0;
		while (!gameOver)
		{
			tagged[curr] = true;
			int temp = cows[curr];
			cows[curr] = 0;
			curr += temp;
			if (curr >= n)
				curr -= n;	
			if (tagged[curr]||cows[curr] == 0)
			{
				System.out.println(temp);
				gameOver = true;
			}
		}
	}

}
