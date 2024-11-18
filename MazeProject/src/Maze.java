import java.util.Stack;

public class Maze {
    public enum Direction {NORTH, EAST, SOUTH, WEST}

    private int rows;
    private int cols;

    private int footX;
    private int footY;
    private Stack<Mouse> stack; 

    private int[][] maze;
    private boolean [][] visited;

    private static class Mouse {
        int x, y;
        Direction dir;

        public Mouse(int x, int y, Direction dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }

    public Maze(int rows, int cols, int[][] values, int foodX, int foodY) {

    }

    private void initializeVisited() {
        // set all values of the visited matrix to false
    }
}
