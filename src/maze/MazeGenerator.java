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
    public static Maze fromLines(String[] lines) {
        String line = lines[lines.length - 1];
        String[] params = line.split(",");
        int height = Integer.parseInt(params[0]);
        int width = Integer.parseInt(params[1]);
        List<Cell> cells = new ArrayList<>();
        for(int i = 0; i < lines.length; i++) {
            line = lines[i];
            params = line.split(",");
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            Side north = SideBuilder.byName(params[2]);
            Side south = SideBuilder.byName(params[3]);
            Side east = SideBuilder.byName(params[4]);
            Side west = SideBuilder.byName(params[5]);
            Tool tool = ToolBuilder.byName(params[6]);
            cells.add(new Cell(x, y, north, south, east, west, tool));
        }
        return new Maze(height, width, cells);
    }
}
