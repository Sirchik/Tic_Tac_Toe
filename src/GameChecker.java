/**
 * Created with IntelliJ IDEA.
 * User: scorp
 * Date: 27.07.13
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */
enum GameStatus {WIN, PLAY, STANDOFF}

public class GameChecker {

    private char[][] grid;
    private int gridSize;

    GameChecker(char[][] grid) {
        this.grid = grid;
        gridSize = grid.length;
    }

    public GameStatus checkWin(char symbol) {
        if (checkVerticalLines(symbol) || checkHorizontalLines(symbol) || checkDiagonalLines(symbol))
            return GameStatus.WIN;

        if (checkStandoff())
            return GameStatus.STANDOFF;

        return GameStatus.PLAY;
    }

    private boolean checkVerticalLines(char symbol) {
        boolean isWin = true;
        for(int i = 0; i < gridSize; ++i) {
            isWin = true;
            for (int j = 0; j < gridSize; ++j) {
                if (grid[j][i] != symbol)
                    isWin = false;
            }

            if (isWin)
                break;
        }
        return isWin;
    }

    private boolean checkHorizontalLines(char symbol) {
        boolean isWin = true;
        for(int i = 0; i < gridSize; ++i) {
            isWin = true;
            for (int j = 0; j < gridSize; ++j)
            {
                if (grid[i][j] != symbol)
                    isWin = false;
            }

            if (isWin)
                break;
        }
        return isWin;
    }

    private boolean checkDiagonalLines(char symbol) {
        //проверка слева на право
        boolean isWin = true;
        for(int i = 0; i < gridSize; ++i) {
            if (grid[i][i] != symbol) {
                isWin = false;
                break;
            }
        }
        if (isWin)
            return isWin;

        //проверка справа на лево
        int j = gridSize-1;
        for(int i = 0; i < gridSize; ++i) {
            isWin = true;
            if (grid[i][j] != symbol) {
                isWin = false;
                break;
            }
            --j;
        }
        return isWin;
    }

    private boolean checkStandoff()
    {
        boolean isStandoff = true;
        for(int i = 0; i < gridSize; ++i) {
            for (int j = 0; j < gridSize; ++j) {
                if (grid[i][j] == Grid.DEFAULT_CHAR) {
                    isStandoff = false;
                    break;
                }
            }
        }

        return isStandoff;
    }
}
