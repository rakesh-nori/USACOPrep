
public class Bale implements Comparable
{
	public static int b, w;
	public int compareTo(Bale other)
	{
		if (other.b - b == 0)
			return other.w - w;
		else
			return other.b - b;
	}
	
}
