import java.util.Scanner;

public class Cotillion
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
		{
			int k = sc.nextInt();
			int count = 0;
			int pos = 0; 
			String sit = sc.next();
			while (count >= 0 && pos < k)
			{
				if (sit.substring(pos, pos+1).equals(">"))
					count++;
				else
					count--;
				pos++;
			}
			if (count == 0)	
				System.out.println("legal");
			else
				System.out.println("illegal");
		}
	}
}
