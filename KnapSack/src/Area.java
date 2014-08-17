
public class Area {
	public int startX;
	public int endX;
	public int height;
	
	public int getArea() {
		return height*(endX-startX);
	}
	public Area(int sX, int eX, int h)
	{
		startX = sX;
		endX = eX;
		height = h;
	}
}

