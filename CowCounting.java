import java.util.Scanner;

public class CowCounting 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int tag = 1;
		int i = 0;
		while (i < n)
		{
			int curr = tag;
			boolean dontUse = false;
			while (curr > 0)
			{
				if (curr % 10 == l)
				{
					if (!dontUse)
						tag++;
					dontUse = true;
					break;
				}
				curr /= 10;
			}
			if (dontUse)
				i--;
			else
				tag++;
			
			i++;
		}
		System.out.println(tag-1);
	}
}
