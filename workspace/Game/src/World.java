import java.util.ArrayList;


public class World 
{
	ArrayList<GameObject> objects;
	
	public World()
	{
		objects = new ArrayList<GameObject>();
	}
	
	public void addToWorld(GameObject go)
	{
		objects.add(go);
	}
	
	public ArrayList<GameObject> getWorld()
	{
		return objects;
	}
}
