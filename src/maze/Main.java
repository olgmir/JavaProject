package maze;

import maze.sides.BreakableWall;
import maze.sides.OpenSide;
import maze.sides.Wall;
import maze.tools.Hammer;
import maze.tools.Key;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(0, 0, new Wall(), new BreakableWall(), new OpenSide(), new Wall()));
        cells.add(new Cell(0, 1, new Wall(), new Wall(), new BreakableWall(), new OpenSide(), new Hammer()));
        cells.add(new Cell(0, 2, new Wall(), new Wall(), new Wall(), new Wall(), new Key()));
        Maze maze = new Maze(1, 3, cells);
//        maze.printMaze();

        Position position = new Position(0, 0);
        Game game = new Game(maze, position);

        System.out.println(game.position);
        System.out.println(game.inventory);
        game.goRight();
        game.goRight();
        System.out.println(game.position);
        System.out.println(game.inventory);
    }
}