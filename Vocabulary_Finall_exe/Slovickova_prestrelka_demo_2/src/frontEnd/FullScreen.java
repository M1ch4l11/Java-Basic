package frontEnd;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FullScreen {
	
	Dimension size;
	
	public void nastavObrazovku (JFrame frame)
	{
		size = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(size);
	}
	
	public Dimension vratVelkost()
	{
		return size;
	}



}
