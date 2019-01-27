import java.util.*;

public class Robo 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] orders = new int[n];
		int len = 0;
		for (int i = 0; i < n; i++)
		{
			String next = sc.next();
			if (next.equals("ADD"))
			{
				orders[i] = 1;

			}
			else
			{
				orders[i] = 2;
	
			}
		}
		int count = 1;
		Stack s = new Stack();
		for (int i = 0; i < n; i++)
		{
			if (orders[i] == 1)
			{
				s.push(count);
				count++;
			}
			else if(orders[i]== 2)
				s.pop();
		}
		len = s.size();
		int [] stack = new int[len];
		for (int i = len-1; i >= 0; i--)
			stack[i] = (int)(s.pop());
		System.out.println(len);
		for (int i = 0; i < len; i++)
			System.out.println(stack[i]);
	}
}
