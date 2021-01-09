package dropgame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Player {

	public Player() {
		Object[] options = { "White", "Black" };
		JPanel panel = new JPanel();
		panel.add(new JLabel("Starter color: "));

		int result = JOptionPane.showOptionDialog(null, panel, "Choose the starter color", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		if (result == JOptionPane.YES_OPTION) {
			System.out.println(result);
			Game.chooseColor = true;

		}
		if (result == JOptionPane.NO_OPTION) {
			System.out.println(result);
			Game.chooseColor = false;
		}
	}
}
