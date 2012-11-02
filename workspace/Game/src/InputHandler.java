import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener, FocusListener
{
	public boolean[] key = new boolean[256];
	
	public void keyPressed(KeyEvent e) 
	{	
		key[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) 
	{
		key[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e) 
	{
		
	}

	public void focusGained(FocusEvent e) 
	{
		
	}
	
	public void focusLost(FocusEvent e) 
	{
		for (int i = 0; i < key.length; i++)
			key[i] = false;
	}

}
