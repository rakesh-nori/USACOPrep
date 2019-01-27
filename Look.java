import java.util.*;
public class Look 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] h = new int[n];
		int [] lookUps = new int[n];
		Stack look = new Stack();
		for (int i = 0; i < n; i++)
			h[i] = sc.nextInt();
		for (int i = n-1; i >= 0; i--)
		{
			int num = h[i];
			if (look.size() == 0)
			{
				look.push(i);
				lookUps[i] = -1;
			}
			else if (h[(int)(look.peek())] > h[i])
			{
				lookUps[i] = (int)(look.peek());
				look.push(i);
			}
			else
			{
				while (look.size() > 0 && h[(int)(look.peek())] <= h[i])
				{
					look.pop();
				}
				if (look.size() > 0)
					lookUps[i] = (int)(look.peek());
				else
					lookUps[i] = -1;
				look.push(i);
			}	
		}
		for (int i = 0; i < n; i++)
			System.out.println(lookUps[i] + 1);
	}
}
