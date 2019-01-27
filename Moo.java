import java.util.Scanner;

public class Moo 
{
	public int findLen(int k)
	{
		
		if (k == 0)
		{
			return 3;
		}
		else if(k < 0)
		{
			return 0;
		}
		else
		{
			return 2 * findLen(k-1) + k+3;
		}
	}
	public void printChar(int n)
	{
		int k = 0;
		while (findLen(k) < n)
			k++;
		getChar(n, k);
		
	}
	public void getChar(int n, int k)
	{
		if (n <= findLen(k-1))
		{
			if (k <= 0)
				return;
			getChar(n, k-1);
		}

		n -= findLen(k-1);

		if (n < k+3)
		{
			if (n == 1)
			{
				System.out.println("m");
			}
			else
				System.out.println("o");
			System.exit(0);
		}
		n -= (k+3);
		getChar(n, k-1);
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		Moo m = new Moo();
		m.printChar(n);
	}
}
