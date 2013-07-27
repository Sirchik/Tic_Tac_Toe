package game;

import java.util.*;
import grid.*;
import players.*;

public class Game {

    private Grid grid;
    private GameChecker gameChecker;
    private Scanner input = new Scanner(System.in);
    private AbstractPlayer player1 = null;
    private AbstractPlayer player2 = null;

    private final char symbolX = 'X';
    private final char symbolO = 'O';


    public void startGame() {
        System.out.println("******Игра Крестики-Нолики******");

        setOptions();
        setGameMode();

        GridPaint.draw(grid.getGrid());
        while (true) {

            System.out.println(player1.getName() + " ходит");
            player1.move();
            GridPaint.draw(grid.getGrid());
            if (gameOver(player1)) {
                break;
            }

            System.out.println(player2.getName() + " ходит");
            player2.move();
            GridPaint.draw(grid.getGrid());
            if (gameOver(player2)) {
                break;
            }

        }

    }

    private void setOptions() {

        boolean wrongInput = true;
        do {
            try {
                System.out.print("Размер сетки -> ");
                grid = new Grid(input.nextInt());
                wrongInput = true;
            }
            catch (Exception e) {
                System.out.println("Ошибка ввода");
                input.next();
                wrongInput = false;
            }
        } while (!wrongInput);
        gameChecker = new GameChecker(grid.getGrid());



    }

    private void setGameMode() {
        System.out.println("Выберите режим игры (номер):");
        System.out.println("(1) Человек-Человек");
        System.out.println("(2) Человек-Компьютер");
        System.out.println("(3) Компьютер-Компьютер");

        int answer = 2;
        boolean wrongInput = true;
        do {
            try {
                System.out.print("-> ");
                answer = input.nextInt();

                if (answer < 1 || answer > 3) {
                    wrongInput = true;
                    continue;
                }

                wrongInput = false;
            }
            catch (Exception e) {
                System.out.println("Ошибка ввода");
                input.next();
                wrongInput = true;
            }
        } while (wrongInput);

       switch (answer) {
           case 1: {
               player1 = newHuman(1);
               player2 = newHuman(2);
           }
           break;
           case 2: {
               player1 = newHuman(1);
               player2 = new Computer("Comp", symbolO, grid);
           }
           break;
           case 3: {
               player1 = new Computer("Comp1", symbolX, grid);
               player2 = new Computer("Comp2", symbolO, grid);
           }
           break;

       }
    }

    private Human newHuman(int index) {
        System.out.print("Игрок №" + index + " введите свое имя -> ");
        String  name = input.next();
        if (player1 == null)
            return new Human(name, symbolX, grid);
        else
            return new Human(name, symbolO, grid);
    }

    private boolean gameOver (AbstractPlayer player) {
        GameStatus status = gameChecker.checkWin(player.getSymbolForGame());
        if (status == GameStatus.WIN) {
            System.out.println(player.getName() + " победил!");
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
