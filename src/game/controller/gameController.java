package game.controller;

import game.view.*;
import game.model.*;
import java.util.*;

public class gameController 
{
	gameFrame frame;
	word random;
	public gameController() 
	{
		frame = new gameFrame(this);
		random = new word("random");
	}
	public void start() 
	{
		
	}
	public String getAnswer(String input) 
	{
		String answer = "";
		Random randomActionGenerator = new Random();
		int randomAction = randomActionGenerator.nextInt(5);
		int randomLetter = randomActionGenerator.nextInt(7);
		
		System.out.println(randomAction + " " + randomLetter);
		
		switch (randomAction) 
		{
		//Add
		case 0:
			
		//Remove
		case 1:
			
		//Replace at Index
		case 2:
			
		//Add at Index
		case 3:
			
		//Remove at Index
		case 4:
			
		}

		return answer;
	}
}
