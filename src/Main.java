/**
 * Created with IntelliJ IDEA.
 * User: scorp
 * Date: 21.07.13
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
import java.util.Scanner;
import java.util.Random;

public class Main {
    public  static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();
        Human player1 = new Human("Bob", 'X', game);
        Human player2 = new Human("Walter", 'Y', game);
        GameStatus status = GameStatus.PLAY;
        Scanner input = new Scanner(System.in);

        System.out.println();
        game.drawGrid();
        while (true)
        {
            player1.move();
            game.drawGrid();
            if (player1.gameOver()) {
                break;
            }

            player2.move();
            game.drawGrid();
            if (player2.gameOver()) {
                break;
            }

        }
    }
}
