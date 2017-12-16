package maze;

import maze.sides.Side;

public class Cell {
    private int x, y;
    public Side north, south, east, west;

    public Cell(int x, int y, Side north, Side south, Side east, Side west) {
        this.x = x;
        this.y = y;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
