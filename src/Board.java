import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board {

    public static final int SIZE = 3;
    private char[][] grid = new char[SIZE][SIZE];

    public char[][] getGrid() {
        return this.grid;
    }

    public Board() {
        grid = new char[SIZE][SIZE];
    }

    public void InitializeGrid() {
        // Initialize the array with the character '_' as empty tile
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '_';
            }
        }
    }

    @Override
    public String toString() {
        String boardToString = "";
        boardToString += "---------\n";
        for (int i = 0; i < SIZE; i++) {
            boardToString += "| ";
            for (int j = 0; j < SIZE; j++) {
                boardToString += grid[i][j];
                boardToString += " ";
            }
            boardToString += "| \n";
        }
        boardToString += "---------";
        return boardToString;
    }

    public void printInstruction() {

        System.out.println("\nTo play Tic Tac Toe you have to enter the coordinates of your play");
        System.out.println("The following figure represent the coordinates of each position in the board");
        System.out.print("\n");
        System.out.println("-------------------------");
        System.out.println("| (1,1) | (1,2) | (1,3) |");
        System.out.println("| (2,1) | (2,2) | (2,3) |");
        System.out.println("| (3,1) | (3,2) | (3,3) |");
        System.out.println("-------------------------");
        System.out.print("\n");
        System.out.println("X always start first, good luck and enjoy your game !");
        System.out.print("\n");

    }

    public int checkPositions(int row, int column) {

        boolean isOutOfBounds = row > SIZE || column > SIZE || row <= 0 || column <= 0;
        if (isOutOfBounds) {
            return -1;
        }

        boolean isFull = grid[row - 1][column - 1] != '_';
        if (isFull) {
            return -2;
        }

        return 1;
    }

    public void fillPosition(int row, int column, char symbol) {
        grid[row - 1][column - 1] = symbol;
    }

    public ArrayList<ArrayList<Integer>> getFreePosition() {
        ArrayList<ArrayList<Integer>> freePositions = new ArrayList<>();
        int row = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == '_') {
                    freePositions.add(row, new ArrayList<>(Arrays.asList(i, j)));
                    row++;
                }
            }
        }
        return freePositions;
    }

    public int[] getRandomPositionfromFreePositions(ArrayList<ArrayList<Integer>> freePositions) {
        Random random = new Random();

        int size = freePositions.size();
        int randomFreePosition = random.nextInt(size);
        int[] randomPosition = new int[2];

        randomPosition[0] = freePositions.get(randomFreePosition).get(0);
        randomPosition[1] = freePositions.get(randomFreePosition).get(1);

        return randomPosition;
    }

    public void fillGrid(String gameState) {
        int k = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char symbol = gameState.split(" ")[k].charAt(0);
                grid[i][j] = symbol;
                k += 1;
            }
        }
    }

}
