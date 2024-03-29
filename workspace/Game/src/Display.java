import javax.swing.JFrame;
import javax.swing.JPanel;


public class Display extends JPanel implements Runnable
{
	private static final long serialVersionUID = -4015573318498002014L;
	
	public final String gameName = "Game";
	public final String gameVersion = "Alpha 0.0.2";
	public static final int width = 800;
	public static final int height = 600;
	
	public InputHandler input;
	
	Game game;
	
	boolean running = false;
	
	static Display display;
	
	JFrame frame;
	Thread thread;
	
	//Init For Program
	public Display()
	{
		frame = new JFrame();
		
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		input = new InputHandler();
		
		frame.addKeyListener(input);
		frame.addFocusListener(input);
		
		game = new Game();
		
		start();
	}
	
	public static void main(String args[])
	{
		display = new Display();
	}
	
	//Starts The GameLoop
	void start()
	{
		if (running)
			return;
					
		running = true;
		game.start(input);
		thread = new Thread(this);
		System.out.println(gameName + " Version " + gameVersion + " Started");
		thread.start();
	}

	//Main Thread (Game Loop)
	public void run() 
	{
		while (running)
		{
			game.tick();
			game.render();
			paintScreen();
		}
	}
	
	//Draws The Buffer From Game To The Screen
	void paintScreen()
	{
		display.getGraphics().drawImage(game.img, 0, 0, width, height, null);
	}
}
