import java.util.*;
public class Dish 
{
	public static void main(String [] args)
	{
		Stack in = new Stack();
		Stack w = new Stack();
		Stack d = new Stack();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = num; i > 0; i--)
		{
			in.push(i);
		}
		while(d.size() < num)
		{
			int n = sc.nextInt();
			if (n == 1)
			{
				int amount = sc.nextInt();
				for (int i = 0; i < amount;i++)
				{
					w.push(in.pop());
				}
			}
			else
			{
				int amount = sc.nextInt();
				for (int i = 0; i < amount;i++)
				{
					d.push(w.pop());
				}
			}
		}
		for (int i = 0; i < num;i++)
			System.out.println(d.pop());
	}

}
