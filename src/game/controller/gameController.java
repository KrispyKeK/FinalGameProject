package game.controller;

import game.view.*;
import game.model.*;
import java.util.*;

public class gameController 
{
	gameFrame frame;
	word random;
	String instruction;
	public gameController() 
	{
		frame = new gameFrame(this);
		random = new word("random");
		instruction = "";
	}
	public ArrayList<String> getAnswer(ArrayList<String> inputed) 
	{
		ArrayList<String> combination = new ArrayList<String>();
		combination = inputed;
		
		String input = "example";
		
		Random randomActionGenerator = new Random();
		
		instruction = "";
		
		int randomAction = randomActionGenerator.nextInt(4);
		int randomLetter = randomActionGenerator.nextInt(5);
		int randomLocation = randomActionGenerator.nextInt(6);
		switch (randomAction) 
		{
		//Add
		case 0:
			if (inputed.size() < 7) 
			{
				combination.add(random.convertTextToArray(random.getWord()).get(randomLetter));
				instruction += input + ".add(" + random.convertTextToArray(random.getWord()).get(randomLetter) + ");"; 
				break;
			}
		//Pop
		case 1:
			combination.remove(combination.size()-1);
			instruction += input + ".pop();";
			break; 
		//Set at Index
		case 2:
			if (inputed.size() > randomLocation) 
			{
				combination.set(randomLocation, random.convertTextToArray(random.getWord()).get(randomLetter));
				instruction += input + ".set(" + randomLocation + "," + random.convertTextToArray(random.getWord()).get(randomLetter) + ");";		
			}
			break;
		//Add at Index
		case 3:
			if (inputed.size() > randomLocation && inputed.size() < 7) 
			{
				combination.add(randomLocation, random.convertTextToArray(random.getWord()).get(randomLetter));
				instruction += input + ".addAtIndex(" + randomLocation + ", " + random.convertTextToArray(random.getWord()).get(randomLetter) + ");";
				break;
			}
		//Remove at Index
		case 4:
			if (inputed.size() > randomLocation) 
			{
				combination.remove(randomLocation);
				instruction += input + ".removeAtIndex(" + randomLocation + ");";
			}
			break;
		//Does nothing
		default:
			
		}
		return combination;
	}
	public String getInstruction() 
	{
		return instruction;
	}
	public String convertArrayToText(ArrayList<String> input) 
	{
		String returnString = "";
		for (String output : input) 
		{
			returnString += output;
		}
		return returnString;
	}
}
