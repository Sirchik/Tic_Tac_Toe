package players;

import java.util.Random;
import grid.Grid;

public class Computer extends AbstractPlayer {

    private final char EMPTY_SYMBOL = Grid.DEFAULT_CHAR;
    private char enemySymbol = Grid.DEFAULT_CHAR;

    public Computer(String in_name, char ch, Grid in_game) {
        super(in_name, ch, in_game);
    }


    public void move () {
        char[][] gridCopy = game.getGrid();

        if (enemySymbol == Grid.DEFAULT_CHAR)
            setEnemySymbol(gridCopy);

        if (haveVerticalLine(gridCopy, symbolForGame)) {
            return;
        }
        else if (haveHorizontalLine(gridCopy, symbolForGame)) {
            return;
        }
        else if (haveDiagonalLine(gridCopy, symbolForGame)) {
            return;
        }
        else if (haveHorizontalLine(gridCopy, enemySymbol)) {
            return;
        }
        else if (haveDiagonalLine(gridCopy, enemySymbol)) {
            return;
        }
        else if (haveVerticalLine(gridCopy, enemySymbol)) {
            return;
        }
        else {
            Random rand = new Random();
            boolean isMove = true;
            do {
                try {
                    isMove = game.setChar(symbolForGame, rand.nextInt(gridCopy.length), rand.nextInt(gridCopy.length));
                }
                catch (Exception e) {
                    isMove = false;
                    continue;
                }
            } while (!isMove);


        }
    }

    private void setEnemySymbol(char[][] grid) {
        for(int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid.length; ++j)
                if (grid[i][j] != symbolForGame && grid[i][j] != EMPTY_SYMBOL)
                    enemySymbol =  grid[i][j];
    }

    public boolean haveHorizontalLine(char[][] grid, char checkSymbol) {
        int countMySymbol = 0;
        int indexEmptySymbol = -1;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == checkSymbol)
                    countMySymbol++;
                else if (grid[i][j] == EMPTY_SYMBOL)
                    indexEmptySymbol = j;
            }

            if (indexEmptySymbol != -1 && countMySymbol == grid.length-1) {
                try {
                    game.setChar(symbolForGame, i, indexEmptySymbol);
                }
                catch (Exception e) { continue; }

                return true;
            }

            countMySymbol = 0;
            indexEmptySymbol = -1;
        }
        return false;
    }

    public boolean haveVerticalLine(char[][] grid, char checkSymbol) {
        int countMySymbol = 0;
        int indexEmptySymbol = -1;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == checkSymbol)
                    countMySymbol++;
                else if (grid[j][i] == EMPTY_SYMBOL)
                    indexEmptySymbol = j;
            }

            if (indexEmptySymbol != -1 && countMySymbol == grid.length-1) {
                try {
                    game.setChar(symbolForGame, indexEmptySymbol, i);
                }
                catch (Exception e) { continue; }

                return true;
            }

            countMySymbol = 0;
            indexEmptySymbol = -1;
        }
        return false;
    }

    public boolean haveDiagonalLine(char[][] grid, char checkSymbol) {

        int countMySymbol = 0;
        int indexEmptySymbol = -1;
        for (int i = 0; i < grid.length; i++){
            if (grid[i][i] == checkSymbol)
                countMySymbol++;
            else if (grid[i][i] == EMPTY_SYMBOL)
                indexEmptySymbol = i;
        }

        if (indexEmptySymbol != -1 && countMySymbol == grid.length-1) {
            try {
                game.setChar(symbolForGame, indexEmptySymbol, indexEmptySymbol);
            }
            catch (Exception e) {  }

            return true;
        }

        countMySymbol = 0;
        indexEmptySymbol = -1;
        int rowPosition = 0;
        int colPosition = 0;
        int j = grid.length-1;
        for (int i = 0; i < grid.length; i++){
            if (grid[i][j] == checkSymbol)
                countMySymbol++;
            else if (grid[i][j] == EMPTY_SYMBOL) {
                indexEmptySymbol = i;
                rowPosition = i;
                colPosition = j;
            }

            --j;
        }

        if (indexEmptySymbol != -1 && countMySymbol == grid.length-1) {
            try {
                game.setChar(symbolForGame, rowPosition, colPosition);
            }
            catch (Exception e) {  }

            return true;
        }

        return false;
    }


}
