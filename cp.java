import java.util.Comparator;

static class cp implements Comparator<Bale> 
{
	public int compare(Bale a, Bale b)
	{
		if (b.b-a.b != 0)
			return b.b - a.b;
		else
			return b.w - a.w;
	}
}