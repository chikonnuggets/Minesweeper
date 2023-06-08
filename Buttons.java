import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Buttons {
	private JFrame frame;
	private String[][] field;
	private JButton[][] buttons;
	private static int count;

	public Buttons(Boolean compete, int row, int col, int mine) {
		count = 0;
		frame = new JFrame();
		frame.setLayout(new GridLayout(row, col));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(540,300);
		field = Generator.generate(row, col, mine);
		buttons = new JButton[row][col];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				buttons[i][j] = new JButton("");
				if (field[i][j].equals("mine")) {
					buttons[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("You lose");
							System.exit(0);
						}
					});
				} else {
					buttons[i][j].setActionCommand("" + count);
					buttons[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String num = e.getActionCommand();
							int n = Integer.parseInt(num);
							int row = n / field[0].length;
							int col = n % field[0].length;
							buttons[row][col].setText(field[row][col]);
							buttons[row][col].setEnabled(false);
						}
					});
				}
				frame.add(buttons[i][j]);
				count++;
			}
		}
	}
}
