package maze;

import maze.sides.Side;
import maze.sides.SideBuilder;
import maze.tools.Tool;
import maze.tools.ToolBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MazeGenerator {
    public static Maze fromLines(List<String> lines) {
        String lastLine = lines.get(lines.size() - 1);
        String[] params = lastLine.split(",");
        int height = Integer.parseInt(params[0]) + 1;
        int width = Integer.parseInt(params[1]) + 1;
        List<Cell> cells = new ArrayList<>();
        Maze maze = new Maze(height, width);
        for(String l: lines) {
            params = l.split(",");
            int x = Integer.parseInt(params[1]);
            int y = Integer.parseInt(params[0]);
            Side north = SideBuilder.byName(params[2]);
            Side south = SideBuilder.byName(params[3]);
            Side east = SideBuilder.byName(params[4]);
            Side west = SideBuilder.byName(params[5]);
            Tool tool = ToolBuilder.byName(params[6]);
//            cells.add(new Cell(x, y, north, south, east, west, tool));
            maze.addCell(new Cell(x, y, north, south, east, west, tool));
        }
        return maze;

    }
}
