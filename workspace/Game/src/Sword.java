import java.awt.Color;
import java.awt.Graphics2D;

//Start of sword code

public class Sword extends GameObject
{
	GameObject owner;
	int life;
	
	public Sword(double x, double y, double size, GameObject owner) 
	{
		super(x, y, size);
		this.owner = owner;
		this.life = 100;
	}

	public void paint(Graphics2D g)
	{
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
	
	public void tick()
	{
		life--;
		if (life < 0)
			this.alive = false;
		
		System.out.println(life);
		
		this.x = owner.x;
		this.y = owner.y;
		
		this.x += Math.sin(Game.time / 20.0) * 16.0;
		this.y += Math.cos(Game.time / 20.0) * 16.0;
	}
	
}
