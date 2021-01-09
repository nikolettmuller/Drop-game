package dropgame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BaseWindow extends JFrame {

	public BaseWindow() {
		setTitle("Drop out game");
		setSize(500, 550);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		addMenu();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				showExitConfirmation();
			}
		});
	}

	public void addMenu() {
		add(new Menu(this));
		getContentPane().revalidate();
		getContentPane().repaint();
	}
	
	public void addGame(int x, int y) {
		getContentPane().invalidate();
		getContentPane().removeAll();
		add(new Game(x, y)).requestFocusInWindow();
		getContentPane().revalidate();
		getContentPane().repaint();
		getContentPane();
	}

	protected void showExitConfirmation() {
		int show = JOptionPane.showConfirmDialog(this, "Are you leaving the game?", "Confirmation",
				JOptionPane.YES_NO_OPTION);
		if (show == JOptionPane.YES_OPTION) {
			doExit();
		}
	}

	protected void doExit() {
		this.dispose();
	}
}
