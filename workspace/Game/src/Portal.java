import java.awt.Color;
import java.awt.Graphics2D;


public class Portal extends GameObject
{

	World dest;
	
	public Portal(double x, double y, double size, World dest) 
	{
		super(x, y, size);
		this.dest = dest;
	}

	public void paint(Graphics2D g)
	{
		g.setColor(new Color(150, 0, 255));
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
	
	public void tick()
	{
		if (Util.collides(this, Game.player))
		{
			Game.world = dest;
			Game.player.x = 5;
			Game.player.y = 5;
		}
	}
	
}
