package leetcode;

public class WordSearch_79 {

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;

		int numRows = board.length;
		int numCols = board[0].length;
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numCols; j++)
				if (searchWord(board, word, i, j	))
					return true;

		return false;
	}

	public boolean searchWord(char[][] board, String word, int x, int y) {
		int numRows = board.length;
		int numCols = board[0].length;

		if (word.isEmpty())
			return true;

		if (x >= numRows || y >= numCols || x < 0 || y < 0)
			return false;

		if (board[x][y] == word.charAt(0)) {
			char temp = board[x][y];
			board[x][y] = '.';
			boolean isPresent = searchWord(board, word.substring(1), x + 1, y)
					|| searchWord(board, word.substring(1), x, y + 1) || searchWord(board, word.substring(1), x - 1, y)
					|| searchWord(board, word.substring(1), x, y - 1);

			board[x][y] = temp;
			return isPresent;
		}

		return false;
	}

	public static void main(String[] args) {
		WordSearch_79 obj = new WordSearch_79();
		char[][] board = {{'a','b'}};
		System.out.println(obj.exist(board, "ba"));
	}

}
