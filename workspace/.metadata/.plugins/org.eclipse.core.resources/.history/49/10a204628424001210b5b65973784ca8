import java.awt.Color;
import java.awt.Graphics2D;


public class Sword extends GameObject
{
	GameObject owner;
	
	public Sword(double x, double y, double size, GameObject owner) 
	{
		super(x, y, size);
		this.owner = owner;
	}

	public void paint(Graphics2D g)
	{
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
	
	public void tick()
	{
		this.x = owner.x;
		this.y = owner.y;
	}
	
}
