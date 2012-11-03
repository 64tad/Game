
public class WorldSaves 
{
	static World world1 = new World();
	static World world2 = new World();
	
	//Saves the data to the worlds
	public static void makeWorlds()
	{
		world2.addToWorld(new Block(100, 100, 30));
		world2.addToWorld(new Portal(200, 200, 20, world1));
		
		world1.addToWorld(new Block(100, 100, 30));
		world1.addToWorld(new Block(300, 300, 30));
		world1.addToWorld(new GameObject(200, 50, 20));
		world1.addToWorld(new Portal(200, 200, 20, world2));
		
	}
}
