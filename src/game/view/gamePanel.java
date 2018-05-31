package game.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import game.controller.*;
import game.model.*;

public class gamePanel extends JPanel
{
	gameController controller;

	//May change if I'm able to implement resizable JComponenets like how we added more elements in the Sandbox game
	private JButton enter;
	private JButton quiz;
	private JButton hard;
	private JButton normal;
	private JButton easy;
	
	private JTextArea instruction;
	
	private JTextField answerOne;
	private JTextField answerTwo;
	private JTextField answerThree;
	private JTextField answerFour;
	private JTextField answerFive;
	private JTextField answerSix;
	private JTextField answerSeven;
	
	private JLabel clock;
	private JLabel scoreBoard;
	private JLabel countDownLabel;
	
	int score;
	
	private SpringLayout baseLayout;
	
	ArrayList<String> wordSet;
	ArrayList<String> example;
	
	public gamePanel(gameController controller) 
	{
		super();

		this.controller = controller;

		enter = new JButton("ENTER");
		quiz = new JButton("QUIZ");
		
		wordSet = new ArrayList<>();
		example = new ArrayList<>();
		
		instruction = new JTextArea("~INSTRUCTIONS~");
		instruction.setEditable(false);
		
		answerOne = new JTextField("e");
		answerTwo = new JTextField("x");
		answerThree = new JTextField("a");
		answerFour = new JTextField("m");
		answerFive = new JTextField("p");
		answerSix = new JTextField("l");
		answerSeven = new JTextField("e");
		
		score = 0;
		
		clock = new JLabel("Time:");
		scoreBoard = new JLabel("Score: " + score);
		countDownLabel = new JLabel("Time Left: ");
		
		baseLayout = new SpringLayout();
				
		setupPanel();
		setupListener();
		setupLayout();
		setupExample();
		timer();
	}
	private void timer() 
	{
		Thread tick = new Thread() 
		{
			public void run() 
			{
				for (;;) {
					Calendar calendar = new GregorianCalendar();
					int second = calendar.get(Calendar.SECOND);
					int minute = calendar.get(Calendar.MINUTE);
					int hour = calendar.get(Calendar.HOUR);
					
					clock.setText("Time :" + hour + ":" + minute + ":" + second);
					try 
					{
						sleep(1000);
						
					}
					catch (Exception e) 
					{
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		};
		tick.start();
	}
	private void setupPanel() 
	{
		this.add(enter);
		this.add(quiz);
		
		this.add(instruction);
		
		this.add(answerOne);
		this.add(answerTwo);
		this.add(answerThree);
		this.add(answerFour);
		this.add(answerFive);
		this.add(answerSix);
		this.add(answerSeven);
		
		this.add(clock);
		this.add(scoreBoard);
		
		this.setLayout(baseLayout);
	}
	private void setupListener() 
	{
		enter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click) 
			{
				if (controller.convertArrayToText(wordSet).equals(controller.convertArrayToText(getInput()))) 
				{
					instruction.setText("~INSTRUCTIONS~");
					score++;
					scoreBoard.setText("Score: " + score);
					resetExample();
				}
				else 
				{
					instruction.append("\nTry Again" + " " + controller.convertArrayToText(wordSet));
				}
			}
		});
		quiz.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click) 
			{	
				instruction.setText("~INSTRUCTIONS~");
				resetExample();
				for (int index = 0; index < 10; index++) 
				{
					wordSet = controller.getAnswer(example);
					instruction.append("\n" + controller.getInstruction());
					//instruction.append(" " + controller.convertArrayToText(wordSet));
				}
			}
		});
	}
	private void setupExample() 
	{
		example.add("e");
		example.add("x");
		example.add("a");
		example.add("m");
		example.add("p");
		example.add("l");
		example.add("e");
	}
	private void resetExample() 
	{
		answerOne.setText("e");
		answerTwo.setText("x");
		answerThree.setText("a");
		answerFour.setText("m");
		answerFive.setText("p");
		answerSix.setText("l");
		answerSeven.setText("e");
		
	}
	private ArrayList<String> getInput() 
	{
		ArrayList<String> inp = new ArrayList<>();
		inp.add(answerOne.getText());
		inp.add(answerTwo.getText());
		inp.add(answerThree.getText());
		inp.add(answerFour.getText());
		inp.add(answerFive.getText());
		inp.add(answerSix.getText());
		inp.add(answerSeven.getText());
		return inp;
	}
	private void setupLayout() 
	{
		baseLayout.putConstraint(SpringLayout.NORTH, countDownLabel, 5, SpringLayout.NORTH, quiz);
		baseLayout.putConstraint(SpringLayout.EAST, countDownLabel, -26, SpringLayout.WEST, quiz);
		baseLayout.putConstraint(SpringLayout.NORTH, scoreBoard, 5, SpringLayout.NORTH, quiz);
		baseLayout.putConstraint(SpringLayout.WEST, scoreBoard, 67, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, clock, 5, SpringLayout.NORTH, quiz);
		baseLayout.putConstraint(SpringLayout.WEST, clock, 0, SpringLayout.WEST, answerFour);
		baseLayout.putConstraint(SpringLayout.WEST, quiz, 0, SpringLayout.WEST, enter);
		baseLayout.putConstraint(SpringLayout.SOUTH, quiz, -6, SpringLayout.NORTH, enter);
		baseLayout.putConstraint(SpringLayout.EAST, quiz, 0, SpringLayout.EAST, enter);
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

