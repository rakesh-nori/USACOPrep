import java.util.Scanner;
public class BarnEchoes
{
	public void detEcho(String s1, String s2)
	{
		int length = 0;
		for(int i = 0; i<= s1.length(); i++)
		{
			for(int k =i; k<= s1.length(); k++)
		    {
				if ((s2.indexOf(s1.substring(i,k)) !=-1) && ((k-i)>length))
				{
					length = k-i;
				}
		    }
		}
		System.out.println(length);
    }
	
	public static void main (String[ ] args)
	{
		Scanner in = new Scafnner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		BarnEchoes b = new BarnEchoes();
		b.detEcho(s1,  s2);
	}
	
       
}