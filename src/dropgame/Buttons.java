package dropgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Buttons extends JButton {

	private Boolean isSet = false;
	private int x;
	private int y;


	public Buttons(int x, int y, Game game) {
		setFocusable(false);
		this.x = x;
		this.y = y;
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed: " + x + " " + y);
				isNextButton();
				game.checkPress();
				pushRow();
			}
		});
	}

	public void setBackgroundButton(int n) {

		isSet = true;
		int white = 1;
		int black = 2;
		int blue = 0;

		if (n == white) {
			setBackground(Color.WHITE);
		} else if (n == black) {
			setBackground(Color.BLACK);
		} else if (n == blue) {
			setBackground(Color.BLUE);
		}
	}

	public Boolean getIsSet() {
		return isSet;
	}

	public void setIsSet(Boolean isSet) {
		this.isSet = isSet;
	}

	public void pushRow() {

		switch (Game.direction) {
		case "up":
			for (int i = 0; i < Game.buttonArray[0].length - 1; i++) {
				Game.buttonArray[i][y].setBackground(Game.buttonArray[i + 1][y].getBackground());
			}
			Game.buttonArray[Game.buttonArray[0].length - 1][y].setBackgroundButton(0);
			break;

		case "down":
			for (int i = Game.buttonArray[0].length - 1; i > 0; i--) {
				Game.buttonArray[i][y].setBackground(Game.buttonArray[i - 1][y].getBackground());
			}
			Game.buttonArray[0][y].setBackgroundButton(0);
			break;

		case "left":
			for (int i = 0; i < Game.buttonArray[0].length - 1; i++) {
				Game.buttonArray[x][i].setBackground(Game.buttonArray[x][i + 1].getBackground());
			}
			Game.buttonArray[x][Game.buttonArray[0].length - 1].setBackgroundButton(0);
			break;

		case "right":
			for (int i = Game.buttonArray[0].length - 1; i > 0; i--) {
				Game.buttonArray[x][i].setBackground(Game.buttonArray[x][i - 1].getBackground());
			}
			Game.buttonArray[x][0].setBackgroundButton(0);
			break;
		}
	}

	public void isNextButton() {
		if (Game.chooseColor.equals(false)) {
			for (int i = 0; i < Game.buttonArray[0].length; i++) {
				for (int j = 0; j < Game.buttonArray[0].length; j++) {
					if (Game.buttonArray[i][j].getBackground().equals(Color.WHITE)
							|| Game.buttonArray[i][j].getBackground().equals(Color.BLUE)) {
						Game.buttonArray[i][j].setEnabled(false);
					} else if (Game.buttonArray[i][j].getBackground().equals(Color.BLACK)) {
						Game.buttonArray[i][j].setEnabled(true);
					}
				}
			}
			Game.chooseColor = true;
		} else {
			for (int i = 0; i < Game.buttonArray[0].length; i++) {
				for (int j = 0; j < Game.buttonArray[0].length; j++) {
					if (Game.buttonArray[i][j].getBackground().equals(Color.BLACK)
							|| Game.buttonArray[i][j].getBackground().equals(Color.BLUE)) {
						Game.buttonArray[i][j].setEnabled(false);
					} else if (Game.buttonArray[i][j].getBackground().equals(Color.WHITE)) {
						Game.buttonArray[i][j].setEnabled(true);
					}
				}
			}
			Game.chooseColor = false;
		}

	}

}
