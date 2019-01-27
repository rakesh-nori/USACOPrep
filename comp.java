
static class comp implements Comparator<Point> 
{
	public long compare(Point a, Point b)
	{
		return ((a.x+a.y)-(b.x+b.y));
	}
}
