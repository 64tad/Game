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
		for (GameObject go : objects)
			go.tick();
		player.tick();
	}
	
	//Render Screen
	void render()
	{
		g.clearRect(0, 0, Display.width, Display.height);
		
		for (GameObject go : objects)
			go.paint(g);
		player.paint(g);
	}
	
	//For input
	public boolean[] getKeys()
	{
		return input.key;
	}
}
