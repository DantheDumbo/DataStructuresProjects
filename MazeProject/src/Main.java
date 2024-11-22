public class Main {
    public static void main(String[] args) {
        int[][] maze1 = {
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
        };

        Maze m1 = new Maze(maze1.length, maze1[0].length, maze1, maze1.length-1, maze1[0].length-1);

        m1.solve();
    }
}
