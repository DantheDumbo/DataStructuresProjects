import java.util.Stack;

public class Maze {
    public enum Direction {NORTH, EAST, SOUTH, WEST}

    private int rows;
    private int cols;

    private int footX;
    private int footY;
    private Stack<Mouse> stack;

    private boolean isSolved;

    private int[][] maze;
    private boolean[][] visited;

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
        this.isSolved = false;
        initializeVisited();
    }

    //checks to see if four conditions have beeen met
    private boolean isValid(int row, int col) {
        return true; // temp
    }

    private boolean wasVisited(int row, int col) {
        return true; // temp
    }

    private void initializeVisited() {
        // set all values of the visited matrix to false
    }
}
