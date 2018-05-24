package game.controller;

public class gameRunner {
	public static void main(String[]args) 
	{
		gameController controller = new gameController();
		controller.start();
		for (int index = 0; index < 20; index++) {
			controller.getAnswer("doesntmatter");
		}
	}
}
