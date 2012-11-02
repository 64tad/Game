import java.awt.Color;
import java.awt.Graphics2D;

//Basic GameObject, Not Used Normally

public class GameObject 
{
	double x;
	double y;
	double size;
	
	boolean alive;
	
	public GameObject(double x, double y, double size)
	{
		this.x = x;
		this.y = y;
		this.size = size;
		alive = true;
	}
	
	public void paint(Graphics2D g)
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
	
	public void tick()
	{
		
	}
}
