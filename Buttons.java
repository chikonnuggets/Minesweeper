import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Buttons {
	private JFrame frame;
	private String[][] field;

	public Buttons(Boolean compete, int row, int col, int mine) {
		frame = new JFrame();
		field = Generator.generate(row, col, mine);
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				JButton button = new JButton("");
				if (field[i][j].equals("mine")) {
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("You lose");
							System.exit(0);
						}
					});
				} else {
					button.addActionListener((ActionListener) this);
				}
				frame.add(button);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		
	}

	public void removeButton(int i, int j) {

	}
}
