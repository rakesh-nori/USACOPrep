import java.util.Scanner;

public class Ruler
{
    private String str;
	public void printRul(int n)
    {
        if (n == 1)
        {
        	System.out.println("*");
        	return;
        }
    	printRul(n-1);
    	for (int i = 0; i < n;  i++)
    		System.out.print("*");
    	System.out.println();
    	printRul(n-1);
    }
    
    public static void main(String [] args)
    {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	Ruler r = new Ruler();
    	for (int i = 0; i < n; i++)
    		System.out.print("*");
    	System.out.println();
    	r.printRul(n-1);
    	for (int i = 0; i < n; i++)
    		System.out.print("*");
    }
    
}