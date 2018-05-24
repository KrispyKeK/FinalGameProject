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
	public ArrayList<String> getAnswer(String input) 
	{
		ArrayList<String> combination = new ArrayList<String>();
		
		String answer = input;
		String instruction = "";
		
		Random randomActionGenerator = new Random();
		
		int randomAction = randomActionGenerator.nextInt(4);
		int randomLetter = randomActionGenerator.nextInt(5);
		int randomLocation = randomActionGenerator.nextInt(6);
		switch (randomAction) 
		{
		//Add
		case 0:
			if (input.length() < 7) 
			{
				answer += random.convertTextToArray(random.getWord()).get(randomLetter);
				instruction += input + ".add(" + random.convertTextToArray(random.getWord()).get(randomLetter) + ");"; 
				break;
			}
		//Pop
		case 1:
			answer = answer.substring(0, answer.length()-1);
			instruction += input + ".pop();";
			break; 
		//Set at Index
		case 2:
			String set = answer.substring(randomLocation-1, randomLocation);
			answer.replace(set, random.convertTextToArray(random.getWord()).get(randomLetter));
			instruction += input + ".set(" + randomLocation + "," + random.convertTextToArray(random.getWord()).get(randomLetter) + ");";
			break;
		//Add at Index
		case 3:
			if (input.length() < 7) 
			{
				String addIndex = answer.substring(randomLocation-1, randomLocation);
				answer.replace(addIndex, random.convertTextToArray(random.getWord()).get(randomLetter));
				instruction += input + ".addAtIndex(" + randomLocation + ", " + random.convertTextToArray(random.getWord()).get(randomLetter) + ");";
				break;
			}
		//Remove at Index
		case 4:
			String removeIndex = answer.substring(randomLocation-1, randomLocation);
			answer.replace(removeIndex, "");
			instruction += input + ".removeAtIndex(" + randomLocation + ");";
			break;
		//Does nothing
		default:
			
		}
		combination.add(answer);
		combination.add(instruction);
		return combination;
	}
}
