package dropgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

	public Menu(BaseWindow wb) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JLabel text = new JLabel("Choose game size:	     ");
		add(text);

		JButton button1 = new JButton(" 3 x 3 ");
		button1.setSize(150, 75);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wb.addGame(3, 3);
			}
		});
		add(button1);
		JButton button2 = new JButton(" 4 x 4 ");
		button2.setSize(150, 75);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wb.addGame(4,4);
			}
		});
		add(button2);
		JButton button3 = new JButton(" 6 x 6 ");
		button3.setSize(150, 75);
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wb.addGame(6, 6);
			}
		});
		add(button3);
	}

}
