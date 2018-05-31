package game.view;

import javax.swing.*;
import game.controller.*;

public class gameFrame extends JFrame
{
	gameController controller;
	gamePanel panel;
	
	public gameFrame(gameController controller) 
	{
		super();
		this.controller = controller;
		this.panel = new gamePanel(controller);
		setupFrame();
	}
	private void setupFrame() 
	{
		this.setContentPane(panel);
		this.setTitle("Java ArrayList<String> Puzzle");
		this.setSize(450, 325);
		this.setResizable(false);
		this.setVisible(true);
	}
}
