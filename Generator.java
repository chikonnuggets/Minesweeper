import java.util.*;

public class Generator {
	public static String[][] generate(int row, int col, int numMines) {
		String[][] field = new String[row][col];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				field[i][j] = "";
			}
		}
		int numOfSpots = row * col;
		Random r = new Random();
		int n = r.nextInt(numOfSpots);
		while (numMines > 0) {
			int rowOfMine = n / col;
			int colOfMine = n % col;
			if (field[rowOfMine][colOfMine].equals("mine")) {
				n = r.nextInt(numOfSpots);
			} else {
				field[rowOfMine][colOfMine] = "mine";
				numMines--;
				n = r.nextInt(numOfSpots);
			}
		}
		return countMines(field);
	}

	public static String[][] countMines(String[][] fld) {
		String[][] field = fld;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				int num = 0;
				for (int k = j - 1; k < j + 2; k++) {
					if (k >= 0 && k < field[0].length) {
						if (i != 0) {
							if (field[i - 1][k].equals("mine")) {
								num++;
							}
						}
						if (i != field.length - 1) {
							if (field[i + 1][k].equals("mine")) {
								num++;
							}
						}
					}
				}
				if (j != 0) {
					if (field[i][j - 1].equals("mine")) {
						num++;
					}
				}
				if (j != field[0].length - 1) {
					if (field[i][j + 1].equals("mine")) {
						num++;
					}
				}
				if (!field[i][j].equals("mine")) {
					field[i][j] = "" + num;
				}
			}
		}
		return field;
	}
}
