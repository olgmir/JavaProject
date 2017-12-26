package maze;

import maze.sides.BreakableWall;
import maze.sides.Door;
import maze.sides.OpenSide;
import maze.sides.Wall;
import maze.tools.Hammer;
import maze.tools.Key;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        if (args.length < 2) {
//            System.err.println("Usage: <programname> <inputFile>");
//            System.exit(1);
//        }

//        String mazeName = args[1];

        String mazeName = "medium.maze";
        List<String> mazeLines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(mazeName));
            // We throw away the first line.
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                mazeLines.add(line);
                line = reader.readLine();
            }
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(2);
        }
        catch (IOException e) {
            System.err.println(e);
            System.exit(3);
        }

        System.out.println(mazeLines);

        Maze maze = MazeGenerator.fromLines(mazeLines);
        maze.printMaze();

        Game game = new Game(maze, new Position(0, 0));
        System.out.println(game.maze.canGoRight(game.player.getPosition()));
        game.goDown();
        System.out.println(game.player.getPosition());
        game.goDown();
        System.out.println(game.player.getPosition());
        game.goRight();
        System.out.println(game.player.getPosition());
    }

    public static void oldMain(String[] args) {
        System.out.println("Hello world");
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(0, 0, new Wall(), new BreakableWall(), new OpenSide(), new Wall()));
        cells.add(new Cell(0, 1, new Wall(), new Wall(), new BreakableWall(), new OpenSide(), new Hammer()));
        cells.add(new Cell(0, 2, new Wall(), new Wall(), new Door(), new BreakableWall(), new Key()));
        cells.add(new Cell(0, 3, new Wall(), new Wall(), new Wall(), new Door()));
        Maze maze = new Maze(1, 4, cells);
//        maze.printMaze();

        Position position = new Position(0, 0);
        Game game = new Game(maze, position);

        System.out.println(game.player.getPosition());
        System.out.println(game.player.getInventory());
        game.goRight();
        System.out.println(game.player.getPosition());
        System.out.println(game.player.getInventory());
        game.goRight();
        System.out.println(game.player.getPosition());
        System.out.println(game.player.getInventory());
        game.goRight();
        System.out.println(game.player.getPosition());
        System.out.println(game.player.getInventory());
    }
}