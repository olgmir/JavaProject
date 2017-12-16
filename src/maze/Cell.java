package maze;

import maze.sides.Side;
import maze.tools.Tool;

public class Cell {
    private int x, y;
    public Side north, south, east, west;
    private Tool tool = null;

    public Cell(int x, int y, Side north, Side south, Side east, Side west, Tool tool) {
        this.x = x;
        this.y = y;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.tool = tool;
    }

    public Cell(int x, int y, Side north, Side south, Side east, Side west) {
        this(x, y, north, south, east, west, null);
    }

    public boolean containsTool() {
        return this.tool != null;
    }

    public Tool pickUpTool() {
        Tool tool = this.tool;
        this.tool = null;
        return tool;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
