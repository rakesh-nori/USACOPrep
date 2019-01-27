
public class Pt implements Comparable 
{
	public int x;
	public int y;
	public boolean canRemove;
	
	public Pt(int x1, int y1)
	{
		x = x1;
		y = y1;
		canRemove = false;
	}
	
	public int compareTo(Pt other)
	{
		return this.x - other.x;
	}

}
