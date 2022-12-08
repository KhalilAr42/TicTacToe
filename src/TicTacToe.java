import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        boolean showMenu = true;
        int choice = -1;

        System.out.println("\n\tHello and welcome to Tic Tac Toe :");

        while (showMenu) {

            System.out.println("===================================================");
            System.out.println("\t1. Play a game of Tic Tac Toe with a friend");
            System.out.println("\t2. Check the game instructions");
            System.out.println("\t3. Get the game result");
            System.out.println("\t4. Quit the game");
            System.out.println("===================================================");
            System.out.println("\nPlease enter the your choice : ");

            try {
                choice = scanner.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("\nPlease enter an integer value (1 or 2 or 3)\n");
                continue;
            } finally {
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    board.InitializeGrid();
                    boolean gameNotFinished = true;
                    int round = 0;

                    System.out.println("\nThis is the Initial state of the board : \n");
                    System.out.println(board);

                    while (gameNotFinished) {
                        System.out.println("\nPlease enter the coordinate of your play:");
                        String userPlay = scanner.nextLine();
                        if (userPlay.length() < 4 && userPlay.matches("[\\d\\s]+")) {
                            int row = Integer.parseInt(userPlay.split(" ")[0]);
                            int column = Integer.parseInt(userPlay.split(" ")[1]);
                            if (board.checkPositions(row, column) == 1) {
                                char symbol = round % 2 == 0 ? 'X' : 'O';
                                board.fillPosition(row, column, symbol);
                                System.out.println("\n"+board);
                                String result = Solver.getWinner(board.getGrid(), Board.SIZE, Board.SIZE);
                                if (result != "Game Not Finished") {
                                    System.out.println("\n Game is finished, the result is : " + result + "\n");
                                    gameNotFinished = false;
                                }
                                round++;
                            } else if (board.checkPositions(row, column) == -1) {
                                System.out.println("Coordinates should be from 1 to 3!");
                            } else {
                                System.out.println("This cell is occupied! Choose another one!");
                            }
                        } else {
                            System.out.println("Please enter valid coordinates separated by one space");
                        }
                    }
                    break;

                case 2:
                    board.printInstruction();
                    break;
                
                case 3:
                    board.InitializeGrid();
                    System.out.println("\nPlease enter the state of your game in one line seperated with spaces:");
                    String gameState = scanner.nextLine();
                    System.out.println("\nThe game you entered looks like this : \n");
                    board.fillGrid(gameState);
                    System.out.println(board);
                    String result = Solver.getWinner(board.getGrid(), Board.SIZE, Board.SIZE);
                    System.out.println("\nThe result of this game is : " + result + "\n");
                    break;

                case 4: 
                    System.out.println("\nThank you for playing, See you soon\n");
                    showMenu = false;
                    break;

                default:
                    System.out.println("\nPlease enter a valid menu choice (1 or 2 or 3) \n");
                    break;
            }

        }

    }

}
