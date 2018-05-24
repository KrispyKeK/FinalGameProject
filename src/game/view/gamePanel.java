package game.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import game.controller.*;
import game.model.*;

public class gamePanel extends JPanel
{
	gameController controller;
	word answerText;

	//May change if I'm able to implement resizable JComponenets like how we added more elements in the Sandbox game
	private JButton enter;
	
	private JTextArea instruction;
	
	private JTextField answerOne;
	private JTextField answerTwo;
	private JTextField answerThree;
	private JTextField answerFour;
	private JTextField answerFive;
	private JTextField answerSix;
	private JTextField answerSeven;
	
	private SpringLayout baseLayout;
	
	public gamePanel(gameController controller) 
	{
		super();

		answerText = new word("example");
		this.controller = controller;

		enter = new JButton("ENTER");
		
		instruction = new JTextArea("~INSTRUCTIONS~");
		instruction.setEditable(false);
		
		answerOne = new JTextField("e");
		answerTwo = new JTextField("x");
		answerThree = new JTextField("a");
		answerFour = new JTextField("m");
		answerFive = new JTextField("p");
		answerSix = new JTextField("l");
		answerSeven = new JTextField("e");
		
		baseLayout = new SpringLayout();
				
		setupPanel();
		setupListener();
		setupLayout();
	}
	private void setupPanel() 
	{
		this.add(enter);
		
		this.add(instruction);
		
		this.add(answerOne);
		this.add(answerTwo);
		this.add(answerThree);
		this.add(answerFour);
		this.add(answerFive);
		this.add(answerSix);
		this.add(answerSeven);
		
		this.setLayout(baseLayout);
	}
	private void setupListener() 
	{
		enter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent VK_ENTER) 
			{
				
			}
		});
		enter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click) 
			{
				
			}
		});
	}
	private void setupLayout() 
	{
		baseLayout.putConstraint(SpringLayout.NORTH, instruction, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, instruction, -49, SpringLayout.NORTH, enter);
		baseLayout.putConstraint(SpringLayout.NORTH, answerSeven, 0, SpringLayout.NORTH, enter);
		baseLayout.putConstraint(SpringLayout.WEST, answerSeven, 310, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, answerSeven, -6, SpringLayout.WEST, enter);
		baseLayout.putConstraint(SpringLayout.EAST, answerFive, -192, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, answerFive, 6, SpringLayout.EAST, answerFour);
		baseLayout.putConstraint(SpringLayout.NORTH, answerSix, 0, SpringLayout.NORTH, enter);
		baseLayout.putConstraint(SpringLayout.WEST, answerSix, 6, SpringLayout.EAST, answerFive);
		baseLayout.putConstraint(SpringLayout.EAST, answerSix, -146, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, answerFive, 0, SpringLayout.NORTH, enter);
		baseLayout.putConstraint(SpringLayout.WEST, answerFour, 172, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, answerThree, 5, SpringLayout.EAST, answerTwo);
		baseLayout.putConstraint(SpringLayout.EAST, answerThree, -6, SpringLayout.WEST, answerFour);
		baseLayout.putConstraint(SpringLayout.NORTH, answerFour, 0, SpringLayout.NORTH, enter);
		baseLayout.putConstraint(SpringLayout.EAST, answerFour, -238, SpringLayout.EAST, this);
		
		baseLayout.putConstraint(SpringLayout.NORTH, answerThree, 0, SpringLayout.NORTH, enter);
		baseLayout.putConstraint(SpringLayout.WEST, answerTwo, 81, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, answerOne, 35, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, answerOne, -6, SpringLayout.WEST, answerTwo);
		baseLayout.putConstraint(SpringLayout.NORTH, answerTwo, 0, SpringLayout.NORTH, enter);
		
		baseLayout.putConstraint(SpringLayout.EAST, answerTwo, -329, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, answerOne, 0, SpringLayout.NORTH, enter);
		baseLayout.putConstraint(SpringLayout.WEST, instruction, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, instruction, 0, SpringLayout.EAST, enter);
		baseLayout.putConstraint(SpringLayout.SOUTH, enter, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, enter, -10, SpringLayout.EAST, this);
	}
}
