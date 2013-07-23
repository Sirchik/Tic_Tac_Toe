/**
 * Created with IntelliJ IDEA.
 * User: scorp
 * Date: 22.07.13
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
import java.util.Random;

public class Computer {
    private final String name = "Computer";
    private char symbolForGame;
    private TicTacToe game;
    private final char EMPTY_SYMBOL = ' ';

    Computer(char ch, TicTacToe in_game) {
        symbolForGame = ch;
        game = in_game;
    }

    /*
    Умеет ходить только если сетка размером 3х3
    */
    public void move () {
        char[][] gridCopy = game.getGrid();

        if (haveVerticalLineWithTwoMySymbol(gridCopy)) {
            return;
        }
        else if (haveGorisontalLineWithTwoMySymbol(gridCopy)) {
            return;
        }
        else if (haveDiagonalLineWithTwoMySymbol(gridCopy)) {
            return;
        }
        else {
            Random rand = new Random();
            boolean isMove = true;
            do {
                try {
                    isMove = game.makeMove(symbolForGame, rand.nextInt(3),rand.nextInt(3));
                }
                catch (Exception e) {
                    isMove = false;
                    continue;
                }
            } while (!isMove);


        }
    }

    public boolean haveGorisontalLineWithTwoMySymbol(char[][] grid) {
        int countMySymbol = 0;
        int indexEmptySymbol = -1;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == symbolForGame)
                    countMySymbol++;
                else if (grid[i][j] == EMPTY_SYMBOL)
                    indexEmptySymbol = j;
            }

            if (indexEmptySymbol != -1 && countMySymbol ==2) {
                try {
                    game.makeMove(symbolForGame, i, indexEmptySymbol);
                }
                catch (Exception e) { continue; }

                return true;
            }

            countMySymbol = 0;
            indexEmptySymbol = -1;
        }
        return false;
    }

    public boolean haveVerticalLineWithTwoMySymbol(char[][] grid) {
        int countMySymbol = 0;
        int indexEmptySymbol = -1;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == symbolForGame)
                    countMySymbol++;
                else if (grid[j][i] == EMPTY_SYMBOL)
                    indexEmptySymbol = j;
            }

            if (indexEmptySymbol != -1 && countMySymbol ==2) {
                try {
                    game.makeMove(symbolForGame, indexEmptySymbol, i);
                }
                catch (Exception e) { continue; }

                return true;
            }

            countMySymbol = 0;
            indexEmptySymbol = -1;
        }
        return false;
    }

    public boolean haveDiagonalLineWithTwoMySymbol(char[][] grid) {

        int countMySymbol = 0;
        int indexEmptySymbol = -1;
        for (int i = 0; i < grid.length; i++){
            if (grid[i][i] == symbolForGame)
                countMySymbol++;
            else if (grid[i][i] == EMPTY_SYMBOL)
                indexEmptySymbol = i;

            if (indexEmptySymbol != -1 && countMySymbol ==2) {
                try {
                    game.makeMove(symbolForGame, i, i);
                }
                catch (Exception e) { continue; }

                return true;
            }

            countMySymbol = 0;
            indexEmptySymbol = -1;
        }
        return false;
    }

    public char getSymbolForGame() {
        return symbolForGame;
    }

    public boolean gameOver () {
        GameStatus status = game.checkWin(symbolForGame);
        if (status == GameStatus.WIN) {
            System.out.println(name + " выйграл!");
            return true;
        }
        else if (status == GameStatus.STANDOFF) {
            System.out.println("Ничья!");
            return true;
        }
        else {
            return false;
        }
    }
}
