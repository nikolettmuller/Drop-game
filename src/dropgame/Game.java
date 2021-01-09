package dropgame;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {

	private int y;
	private int x;

	private int countClick = 0;
	private int countWhite = 0;
	private int countBlack = 0;

	public static String direction;
	
	public static Boolean chooseColor = null;
	
	private String winner = "";

	static Buttons buttonArray[][];

	public Game(int x, int y) {
		addKeyListener(new ButtonListener());
		Player player = new Player();
		this.x = x;
		this.y = y;
		buttonArray = new Buttons[x][y];
		setLayout(new GridLayout(x, y));
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				Buttons button = new Buttons(i, j, this);
				buttonArray[i][j] = button;
				add(button);
			}
		}
		setRandomColor();
		buttonArray[0][0].isNextButton();
	}

	public void setRandomColor() {
		int rand_x;
		int rand_y;
		for (int i = 0; i < this.x; i++) {
			do {
				rand_x = (int) (Math.random() * (this.x - 0)) + 0;
				rand_y = (int) (Math.random() * (this.y - 0)) + 0;
			} while (buttonArray[rand_x][rand_y].getIsSet() == true);
			buttonArray[rand_x][rand_y].setBackgroundButton(1);
		}
		for (int i = 0; i < this.y; i++) {
			do {
				rand_x = (int) (Math.random() * (this.x - 0)) + 0;
				rand_y = (int) (Math.random() * (this.y - 0)) + 0;
			} while (buttonArray[rand_x][rand_y].getIsSet() == true);
			buttonArray[rand_x][rand_y].setBackgroundButton(2);
		}
		for (int i = 0; i < this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				if (buttonArray[i][j].getIsSet() == false) {
					buttonArray[i][j].setBackgroundButton(0);
				}
			}
		}
	}

	public void checkPress() {
		countClick++;
		countWhite = this.x;
		countBlack = this.y;
		for (int i = 0; i < this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				if (buttonArray[i][j].getBackground().equals(Color.WHITE)) {
					countWhite++;
				}
				if (buttonArray[i][j].getBackground().equals(Color.BLACK)) {
					countBlack++;
				}
			}
		}
		if (countClick > x * 5) {
			findWinner();
			setNewGame();
		}
		/*
		else if(countBlack == 0) {
			findWinner();
			setNewGame();
		}
		else if(countWhite == 0) {
			findWinner();
			setNewGame();
		}*/
	}
	
	public void findWinner() {
		if(countWhite > countBlack) {
			winner = "White player won";
		}
		if(countBlack > countWhite) {
			winner = "Black player won";
		}
		if(countWhite == countBlack) {
			winner = "The game is draw";
		}
	}
	
	public void setNewGame() {
		Object[] options = { "Yes", "No" };
		JPanel panel = new JPanel();
		BaseWindow bs = new BaseWindow();

		int result = JOptionPane.showOptionDialog(null, "Want to start a new game?", winner,  JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		if (result == JOptionPane.YES_OPTION) {
			StartGame sg = new StartGame();

		}
		if (result == JOptionPane.NO_OPTION) {
			bs.showExitConfirmation();
		}
	}
}