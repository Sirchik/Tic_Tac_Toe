package players;

import java.util.*;
import grid.*;

public class Human extends AbstractPlayer {

    private Scanner input = new Scanner(System.in);

    public Human(String in_name, char ch, Grid in_game) {
        super(in_name, ch, in_game);
    }

    public void move () {
        int row;
        int col;
        boolean endMove = true;
        do {
            System.out.print(name + " введите номер строки -> ");
            if (input.hasNextInt())
                row = input.nextInt();
            else {
                input.next();
                endMove = false;
                continue;
            }
            System.out.print(name + " введите номер столбца -> ");
            if (input.hasNextInt())
                col = input.nextInt();
            else  {
                input.next();
                endMove = false;
                continue;
            }

            try {
                endMove = game.setChar(symbolForGame, row, col);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Опаньки! Неправильный индекс ячейки!");
                endMove = false;
                continue;
            }
            catch (CellNotFreeException e) {
                System.out.println("Внезапно! Ячейка уже занята!");
                endMove = false;
                continue;
            }

        } while (!endMove);
    }



}
