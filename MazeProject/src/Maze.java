import java.util.Arrays;
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
    private int[][] path;

    private Stack<Mouse> stack;

    Scanner scan = new Scanner(System.in);




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
    public static void pause(Scanner scan) {
        System.out.println("Hit enter to continue");
        scan.nextLine();
    }

    // solves the maze using DFS
    public boolean solve() {
        if (!isValid(0, 0)) {
            System.out.println("Starting point is invalid.");
            return false;
        }

        stack.push(new Mouse(0, 0)); // Start at top-left

        while (!stack.isEmpty()) {
            Mouse current = stack.peek();
            visited[current.r][current.c] = 1;

            // Check for food
            if (current.r == foodRow && current.c == foodCol) {
                System.out.println("Food found!");
                printPath();
                return true;
            }

            boolean moved = false;

            // Check all directions
            while (current.dir < 4 && !moved) {
                if (current.dir == 0 && isValid(current.r - 1, current.c)) { // Up
                    stack.push(new Mouse(current.r - 1, current.c));
                    moved = true;
                } else if (current.dir == 1 && isValid(current.r, current.c + 1)) { // Right
                    stack.push(new Mouse(current.r, current.c + 1));
                    moved = true;
                } else if (current.dir == 2 && isValid(current.r + 1, current.c)) { // Down
                    stack.push(new Mouse(current.r + 1, current.c));
                    moved = true;
                } else if (current.dir == 3 && isValid(current.r, current.c - 1)) { // Left
                    stack.push(new Mouse(current.r, current.c - 1));
                    moved = true;
                }
                current.dir++;
            }

            if (!moved) {
                stack.pop(); // Dead end, backtrack
            }
            /*
            printMatrix(this.visited); // Debugging
            pause(scan);
             */
        }

        System.out.println("No path to cheese.");
        return false;
    }

    public void printPath() {
        Stack<Mouse> tempStack = new Stack<>();
        int[][] path = deepCopy(maze);
        Mouse m;

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()) {
            m = tempStack.pop();
            path[m.r][m.c] = -1;
        }
        printMatrix(path);
    }

    public static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}


