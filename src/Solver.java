public class Solver {

    public static String getWinner(char[][] grid, int rows, int columns) {
        int countX = 0;
        int countO = 0;

        // Count Number of X and O in the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 'X') {
                    countX++;
                } else if (grid[i][j] == 'O') {
                    countO++;
                }
            }
        }

        boolean winnerIsX = false;
        boolean winnerIsO = false;

        // Check all the possible wins by either X or O
        for (int i = 0; i < rows; i++) {

            int row = 0;
            int column = 0;
            int diagonal = 0;
            int antiDiagonal = 0;

            for (int j = 0; j < columns; j++) {
                row += grid[i][j];
                column += grid[j][i];
                diagonal += grid[j][j];
                antiDiagonal += grid[j][2 - j];
            }

            // Because 'X' ASCII Code is 88 and 'O' ASCII Code is 79
            winnerIsX = winnerIsX || row == 264 || column == 264 || diagonal == 264 || antiDiagonal == 264;
            winnerIsO = winnerIsO || row == 237 || column == 237 || diagonal == 237 || antiDiagonal == 237;

        }

        String result;

        result = (Math.abs(countO - countX) > 1 || winnerIsX && winnerIsO) ? "Impossible"
                : winnerIsX ? "X wins"
                        : winnerIsO ? "O wins"
                                : countX + countO == 9 ? "Draw"
                                        : "Game Not Finished";

        return result;

    }
}
