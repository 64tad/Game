import java.awt.Color;
import java.awt.Graphics2D;


public class Block extends GameObject
{

	public Block(double x, double y, double size) 
	{
		super(x, y, size);
		this.collides = true;
	}

	public void paint(Graphics2D g)
	{
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
	
	public void tick()
	{
		
	}
	
}
