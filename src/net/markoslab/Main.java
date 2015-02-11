package net.markoslab;

public class Main
{
	
	public static void main(String[] args) throws InterruptedException {
		Game game = new BuffsTest();
		game.create();
        while (true) {
            game.update();
            Thread.sleep(20);
        }
	}
}
