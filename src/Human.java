import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: scorp
 * Date: 22.07.13
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
public class Human {
    private String name;
    private char symbolForGame;
    private TicTacToe game;
    private Scanner input = new Scanner(System.in);

    Human(String in_name, char ch, TicTacToe in_game) {
        name = in_name;
        symbolForGame = ch;
        game = in_game;
    }

    public void move () {
        int row;
        int col;

        do {
            System.out.print(name + " введите номер строки -> ");
            row = input.nextInt();
            System.out.print(name + " введите номер столбца -> ");
            col = input.nextInt();
        } while (!game.makeMove(symbolForGame, row, col));
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
