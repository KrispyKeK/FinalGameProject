package game.model;
import java.util.*;
public class word {
	String text;
	public word(String text) 
	{
		this.text = text;
	}
	public ArrayList<String> convertTextToArray(String text) 
	{
		ArrayList<String> conversion = new ArrayList<String>();
		int textPrevious = 0;
		for (int index = 1; index < text.length(); index++) 
		{
			conversion.add(text.substring(textPrevious, index));
			textPrevious++;
		}
		return conversion;
	}
	public String getWord() 
	{
		return text;
	}
	public void setWord() {
		this.text = text; 
	}
}
