import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Player extends GameObject
{
	Game game;
	Sword sword;

	public Player(double x, double y, double size, Game game)
	{
		super(x, y, size);
		this.game = game;
	}

	public void paint(Graphics2D g)
	{
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)size, (int)size);

		if (sword != null)
			sword.paint(g);
	}

	public void tick()
	{
		if (game.getKeys()[KeyEvent.VK_W])
			this.y--;
		if (game.getKeys()[KeyEvent.VK_S])
			this.y++;
		if (game.getKeys()[KeyEvent.VK_A])
			this.x--;
		if (game.getKeys()[KeyEvent.VK_D])
			this.x++;

		if (game.getKeys()[KeyEvent.VK_SPACE])
			this.sword = new Sword(x + 5, y + 5, 20, this);

		if (sword != null)
			sword.tick();
	}
}
