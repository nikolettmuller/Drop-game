package dropgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_S) {
			Game.direction = "down";
			System.out.println(Game.direction);
		}
		if (key == KeyEvent.VK_A) {
			Game.direction = "left";
			System.out.println(Game.direction);
		}
		if (key == KeyEvent.VK_D) {
			Game.direction = "right";
			System.out.println(Game.direction);
		}
		if (key == KeyEvent.VK_W) {
			Game.direction = "up";
			System.out.println(Game.direction);
		}
	}
}
