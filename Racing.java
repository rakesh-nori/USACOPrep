import java.util.Scanner;

public class Racing 
{
	public void giveLongest(int M, int T, int U, int F, int D, String [] path)
	{
		int sum = 0;
		int count = 0;
		while (sum <= M)
		{
			if (path[count].substring(0, 1).equals("u") || path[count].substring(0, 1).equals("d"))
				sum += (U + D);
			else
				sum += (F+F);
			count++;
		}
		System.out.println(count-1);
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int T = sc.nextInt();
		int U = sc.nextInt();
		int F = sc.nextInt();
		int D = sc.nextInt();
		String[] path = new String[T];
		for (int i = 0; i < T; i++)
		{
			path[i] = sc.next();
		}
		Racing rc = new Racing();
		rc.giveLongest(M, T, U, F, D, path);
	}

}
