import java.util.Scanner;
import java.util.Stack;


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




    // Mouse class
    private static class Mouse {
        int r;
        int c;
        int dir;

        public Mouse(int r, int c) {
            this.r = r;
            this.c = c;
            this.dir = 0;
            // 0 = up
            // 1 = right
            // 2 = down
            // 3 = left
        }

        @Override
        public String toString() {
            return "( " + this.r + ", " + this.c + ", " + this.dir + " )";
        }
    }




    // constructor to initialize maze properties
    public Maze(int maxRows, int maxCols, int[][] maze, int foodRow, int foodCol) {
        this.maxRows = maxRows;
        this.maxCols = maxCols;
        this.maze = maze;
        this.foodRow = foodRow;
        this.foodCol = foodCol;
        this.isSolved = false;
        this.visited = new int[maxRows][maxCols]; // initializes all to 0
        this.stack = new Stack<>();
    }

    //checks to see if a cell has already been visited (used by the isValid method)
    private boolean isVisited(int row, int col) {
        return visited[row][col] == 1;
    }

    //checks to see if four conditions have been met
    private boolean isValid(int row, int col) {
        /*
        - Are the coordinates in the world?
        - Is there a wall there?
        - Is there a dead end there?
        - Have we been there before?
        - If all four checks pass, return true
        */
        // checks if point is out of bounds
        if (row >= maxRows || row < 0 || col >= maxCols || col < 0) {
            return false;
        }
        // checks if point is on a wall
        if (this.maze[row][col] == 0) {
            return false;
        }
        // checks if we have been here before
        if (isVisited(row, col)) {
            return false;
        }
        return true;
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

    // debugging method to pause the program
    public static void pause() {
        try (java.util.Scanner scan = new java.util.Scanner(System.in)) {
            System.out.println("Hit enter to continue");
            scan.nextLine();
        }
    }

    // solves the maze using DFS
    public boolean solve() {
        //debug
        printMatrix(this.maze);
        //debug
        printMatrix(this.visited);

        stack.push(new Mouse(0, 0)); // Start at top-left

        while (!stack.isEmpty()) {
            Mouse current = stack.peek();
            visited[current.r][current.c] = 1;

            if (current.r == foodRow && current.c == foodCol) {
                System.out.println("Food found!");
                return true;
            }
        }





        /*

        // push the initial mouse position to the stack
        stack.push(new Mouse(0, 0)); // Start at top-left

        // main loop for solving the maze
        while (!stack.isEmpty()) {
            Mouse current = stack.peek();
            visited[current.r][current.c] = 1; // mark current cell as visited

            // check if we've found the food
            if (current.r == foodRow && current.c == foodCol) {
                System.out.println("Food found!");
                return true;
            }

            // attempt to move in each direction
            boolean moved = false;
            for (Direction dir : Direction.values()) {
                int newRow = current.r + (dir == Direction.DOWN ? 1 : dir == Direction.UP ? -1 : 0);
                int newCol = current.c + (dir == Direction.RIGHT ? 1 : dir == Direction.LEFT ? -1 : 0);

                if (isValid(newRow, newCol)) {
                    stack.push(new Mouse(newRow, newCol)); // move mouse
                    moved = true;
                    break;
                }
            }

            // if no valid move, backtrack
            if (!moved) {
                stack.pop();
            }
        }

        System.out.println("No path to food!");
        return false; // no solution

         */
    }

    public void printPath() {
        System.out.println(stack);
    }
}


