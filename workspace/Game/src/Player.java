import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Player extends GameObject
{
	Game game;
	Sword sword;

	double lookX = 0, lookY = 0;

	public Player(double x, double y, double size, Game game)
	{
		super(x, y, size);
		this.game = game;
	}

	//Paints the player to the screen
	public void paint(Graphics2D g)
	{
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)size, (int)size);

		g.setColor(Color.magenta);
		g.fillRect((int)((x + size/2 - 3) + lookX * 10), (int)((y + size / 2 - 8 / 2) + lookY * 10), 8, 8);

		if (sword != null)
			sword.paint(g);
	}

	//Update the player (includes user input)
	public void tick()
	{
		int moveX = 0, moveY = 0;

		if (game.getKeys()[KeyEvent.VK_W])
			moveY--;
		if (game.getKeys()[KeyEvent.VK_S])
			moveY++;
		if (game.getKeys()[KeyEvent.VK_A])
			moveX--;
		if (game.getKeys()[KeyEvent.VK_D])
			moveX++;

		move(moveX, moveY);

		//Start of sword code
		if (game.getKeys()[KeyEvent.VK_SPACE])
			this.sword = new Sword(x + 5, y + 5, 10, this);

		if (sword != null)
		{
			sword.tick();
			if (!sword.alive)
				sword = null;
		}

	}

	void move(double moveX, double moveY)
	{

		boolean collidingX = false, collidingY = false;
		double newX, newY;

		//Check x
		newX = moveX + this.x;
		newY = moveY + this.y;
		
		if ((moveX != 0 && moveY != 0) || (moveX != 0 || moveY != 0))
		{
			lookX = moveX;
			lookY = moveY;
		}

		for (GameObject go : Game.objects)
			if (Util.collides(new Block(newX, this.y, this.size), go))
				if (go.collides)
					collidingX = true;

		for (GameObject go : Game.objects)
			if (Util.collides(new Block(this.x, newY, this.size), go))
				if (go.collides)
					collidingY = true;

		if (!collidingX)
			this.x = newX;

		if (!collidingY)
			this.y = newY;
	}
}
