import java.util.Stack;

enum Direction {UP, RIGHT, DOWN, LEFT}

public class Maze {
    // properties of maze
    private int maxRows;
    private int maxCols;

    private int foodRow;
    private int foodCol;

    // set to true if food is found or no solution
    private boolean isSolved;

    private int[][] maze; // contains our maze
    private int[][] visited; // tracks cells already visited

    private Stack<Mouse> stack;
    private Mouse workingMouse;



    // Mouse class
    private static class Mouse {
        int r;
        int c;
        Direction dir;

        public Mouse(int r, int c) {
            this.r = r;
            this.c = c;
            this.dir = Direction.UP;
        }

        @Override
        public String toString() {
            return "( " + this.r + ", " + this.c + ", " + this.dir + " )";
        }
    }



    public Maze(int maxRows, int maxCols, int[][] maze, int foodRow, int foodCol) {
        this.maxRows = maxRows;
        this.maxCols = maxCols;
        this.maze = maze;
        this.foodRow = foodRow;
        this.foodCol = foodCol;
        this.isSolved = false;
        initializeVisited();
        this.stack = new Stack<>();
        this.visited = new int[maxRows][maxCols];
    }

    private boolean wasVisited(int row, int col) {
        return true; // temp
    }

    private void initializeVisited() {
        for (int r = 0; r < this.maxRows; r++) {
            for (int c = 0; c < this.maxCols; c++) {
                this.visited[r][c] = 0;
            }
        }
    }

    // utility method to print a matrix (maze or visited)
    public void printMatrix(int[][] matrix) {
        for (int r = 0; r < this.maxRows; r++) {
            for (int c = 0; c < this.maxCols; c++) {
                System.out.printf("%3d", matrix[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isVisited (int row, int col) {
        return visited[row][col] == 1;
    }


    //checks to see if four conditions have beeen met
    private boolean isValid(int row, int col) {
    /*
    are the coordinates in the word?
    is there a wall there
    is there a dead end there
    have we been there before
    if all four digests pass, return true
     */
        // checks if point is out of bounds
        if (row >= maxRows || row < 0 || col >= maxCols || col < 0) {
            return false;
        }
        // checks if point is on a wall
        if (this.maze[row][col] == 0) {
            return false;
        }
        // checks if point has been visited
        if (this.maze[row][col] == -1) {
            return false;
        }
        // checks if we have been here before
        if (isVisited(row, col)) {
            return false;
        }
        return true;
    }
    public boolean solve() {
        //debug
        printMatrix(this.maze);
        //debug
        printMatrix(this.visited);
        return true; 
    }
}


