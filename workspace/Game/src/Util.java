import java.awt.Rectangle;

public class Util 
{
	public static boolean collides (GameObject go1, GameObject go2)
	{
		Rectangle r1 = new Rectangle((int)go1.x, (int)go1.y, (int)go1.size, (int)go1.size);
		Rectangle r2 = new Rectangle((int)go2.x, (int)go2.y, (int)go2.size, (int)go2.size);
		return r1.intersects(r2);
	}
}