package maze;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Maze maze = new Maze(4,5);
        maze.printMaze();
        Map<String, Cell> neighbors = maze.getNeighbors(3, 2);
        Map<String, Cell> neighbors2 = maze.getNeighbors(4, 3);
        System.out.println(neighbors);
        System.out.println(neighbors2);
    }
}