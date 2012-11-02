import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game 
{
	//Buffer Graphics
	BufferedImage img;
	Graphics2D g;

	//Storage of GameObjects
	ArrayList<GameObject> objects;
	Player player;
	InputHandler input;
	
	//Data For Fps Counter
	public int currentFPS = 0;
	public int FPS = 0;
	public long start = 0;

	//Number used for animation (Increases by 1 every tick)
	static long time = 0;
	
	//Init
	void start(InputHandler input)
	{
		img = new BufferedImage(Display.width, Display.height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) img.getGraphics();
		objects = new ArrayList<GameObject>();

		this.input = input;

		player = new Player(10, 10, 10, this);
		objects.add(new GameObject(400, 300, 10));
	}

	//Update All GameObjects And Player
	void tick()
	{
		time++;
		
		for (GameObject go : objects)
			go.tick();
		player.tick();
		
		//Remove all "dead" GameObjects
		for (int i = 0; i < objects.size(); i++)
			if (!objects.get(i).alive)
				objects.remove(i);
		
		//Update Fps Counter
		currentFPS++;
		if(System.currentTimeMillis() - start >= 1000) 
		{
			FPS = currentFPS;
			currentFPS = 0;
			start = System.currentTimeMillis();
		}
	}

	//Render Screen
	void render()
	{
		g.clearRect(0, 0, Display.width, Display.height);

		for (GameObject go : objects)
			go.paint(g);
		player.paint(g);
		
		g.setColor(Color.yellow);
		g.drawString("FPS:" + FPS, 10, 15);
	}

	//For input
	public boolean[] getKeys()
	{
		return input.key;
	}
}
