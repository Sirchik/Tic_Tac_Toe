package grid;

public class GridPaint {

    private static char[][] grid;

    public static void draw(char[][] inGrid) {

        grid = inGrid;

        System.out.println();

        System.out.print("[+]");
        for (int i = 0; i < grid.length; ++i) {
            System.out.print("[" + i + "]");
        }
        System.out.println();

        for (int i = 0; i < grid.length; ++i) {
            drawLine(i);
            System.out.println();
        }
    }

    private static void drawLine(int line_index) {
        System.out.print("[" + line_index + "]");
        for (int i = 0; i < grid.length; ++i) {
            System.out.print("[" + grid[line_index][i] + "]");
        }
    }
}
