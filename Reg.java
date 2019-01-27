import java.util.*;
public class Reg
//DOES NOT WORK ON ECLIPSE BUT WORKS ON LMS
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue q = new LinkedList();
		Queue [] registers = new Queue[n];
		for (int i = 0; i < n; i++)
			registers[i] = new LinkedList();
		while (sc.hasNext())
		{
			String letter = sc.next();
			if (letter.equals("C"))
			{
				q.add(sc.nextInt());
			}
			else if (letter.equals("R"))
			{
				int reg = sc.nextInt() - 1;
				registers[reg].add(q.remove());
			}
		}
		for (int i = 0; i < n; i++)
		{
			int num = registers[i].size();
			System.out.print(num + " ");
			for (int j = 0; j < num; j++)
				System.out.print(registers[i].remove() + " ");
			System.out.println();
		}
		
	}
}
