package pl.qrsor.neetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class ValidSudoku
{
	public boolean isValidSudoku(char[][] board)
	{
		var rows = new ArrayList<Set<Character>>();
		for (int i = 0; i < 9; i++) {
			rows.add(new HashSet<>());
		}
		var columns = new ArrayList<Set<Character>>();
		for (int i = 0; i < 9; i++) {
			columns.add(new HashSet<>());
		}
		var squares = new ArrayList<Set<Character>>();
		for (int i = 0; i < 9; i++) {
			squares.add(new HashSet<>());
		}


		for (int rowNumber = 0; rowNumber < 9; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < 9; columnNumber++)
			{
				var currentElement = board[rowNumber][columnNumber];
				if (currentElement != '.') {
					//validate rows
					if(rows.get(rowNumber).contains(currentElement)) {
						return false;
					} else {
						rows.get(rowNumber).add(currentElement);
					}

					//validate columns
					if(columns.get(columnNumber).contains(currentElement)) {
						return false;
					} else {
						columns.get(columnNumber).add(currentElement);
					}

					//validate 3x3 squares
					int squareIndex = columnNumber /3 + (rowNumber / 3) * 3;
					if(squares.get(squareIndex).contains(currentElement)) {
						return false;
					} else {
						squares.get(squareIndex).add(currentElement);
					}
				}
			}
		}

		return true;
	}
}
