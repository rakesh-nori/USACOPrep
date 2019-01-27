import java.util.*;

public class CowZ 
{
	public static int n;
	public static int s;
	public static int e;
	public static Vector<Expression>[] commands;
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		e = sc.nextInt();
		commands = new Vector[e];
		for (int i = 0; i < e; i++)
		{
			String s = sc.next();
			commands[i].add(new Expression(s.substring(0, 1)., s.substring(2, 3)));
			System.out.println(s);
		}
		
		
	}
}
