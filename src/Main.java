/**
 * Created with IntelliJ IDEA.
 * User: scorp
 * Date: 21.07.13
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */

//=============================
// e-mail -> nik.scrp@gmail.com
//=============================

import java.util.Scanner;


public class Main {
    public  static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Human player1 = new Human("Bob", 'X', game);
        Computer comp = new Computer('Y', game);
        GameStatus status = GameStatus.PLAY;
        Scanner input = new Scanner(System.in);

        System.out.println();
        game.drawGrid();
        while (true) {
            player1.move();
            game.drawGrid();
            if (player1.gameOver()) {
                break;
            }

            System.out.println("Ход компьютера");
            comp.move();
            game.drawGrid();
            if (comp.gameOver()) {
                break;
            }

        }
    }
}
