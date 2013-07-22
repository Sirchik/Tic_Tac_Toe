/**
 * Created with IntelliJ IDEA.
 * User: scorp
 * Date: 21.07.13
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */

enum GameStatus {WIN, PLAY, STANDOFF}

public class TicTacToe {
    private int gridSize = 3;
    private char[][] grid;
    private final char DEFAULT_CHAR = ' ';
    private char charX = 'X';
    private char charY = 'Y';

    TicTacToe()
    {
       this(3);
    }

    TicTacToe (int size)
    {
        if (size > 3)
        {
            gridSize = size;
        }
        grid = new char[gridSize][gridSize];
        clearGrid();
    }

    public void clearGrid()
    {
        for(int i = 0; i < gridSize; ++i)
            for (int j = 0; j < gridSize; ++j)
                grid[i][j] = DEFAULT_CHAR;
    }

    public void drawGrid()
    {
        System.out.println();

        System.out.print("[+]");
        for (int i = 0; i < gridSize; ++i)
        {
            System.out.print("[" + i + "]");
        }
        System.out.println();

        for (int i = 0; i < gridSize; ++i)
        {
            drawLine(i);
            System.out.println();
        }
    }

    private void drawLine(int line_index)
    {
        System.out.print("[" + line_index + "]");
        for (int i = 0; i < gridSize; ++i)
        {
            System.out.print("[" + grid[line_index][i] + "]");
        }
    }

    private void setChar (char symbol, int row, int col) throws CellNotFreeException
    {
        try
        {
            if (grid[row][col] != DEFAULT_CHAR)
                throw new CellNotFreeException();

            grid[row][col] = symbol;
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Опаньки! Неправильный индекс ячейки!");
            throw e;
        }
        catch (CellNotFreeException e)
        {
            System.out.println("Внезапно! Ячейка уже занята!");
            throw e;
        }
    }

    public boolean makeMove (char symbol, int row, int col)
    {
        try
        {
            setChar (symbol, row, col);
        }
        catch (Exception e)
        {
            return  false;
        }
        return true;
    }

    public GameStatus checkWin(char symbol)
    {
        if (checkVerticalLines(symbol) || checkGorisontalLines(symbol) || checkDiagonalLines(symbol))
            return GameStatus.WIN;

        if (checkStandoff())
            return GameStatus.STANDOFF;

        return GameStatus.PLAY;
    }

    private boolean checkVerticalLines(char symbol)
    {
        boolean isWin = true;
        for(int i = 0; i < gridSize; ++i)
        {
            isWin = true;
            for (int j = 0; j < gridSize; ++j)
            {
                if (grid[j][i] != symbol)
                    isWin = false;
            }

            if (isWin)
                break;
        }
        return isWin;
    }

    private boolean checkGorisontalLines(char symbol)
    {
        boolean isWin = true;
        for(int i = 0; i < gridSize; ++i)
        {
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

    private boolean checkDiagonalLines(char symbol)
    {
        //проверка слева на право
        boolean isWin = true;
        for(int i = 0; i < gridSize; ++i)
        {
            if (grid[i][i] != symbol)
            {
                isWin = false;
                break;
            }
        }
        if (isWin)
            return isWin;

         //проверка справа на лево
        for(int i = 0; i < gridSize; ++i)
        {
            int j = gridSize-1;
            isWin = true;
                if (grid[i][j] != symbol)
                {
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
        for(int i = 0; i < gridSize; ++i)
        {
            for (int j = 0; j < gridSize; ++j)
            {
                if (grid[i][j] == DEFAULT_CHAR)
                {
                    isStandoff = false;
                    break;
                }
            }
        }

        return isStandoff;
    }
}