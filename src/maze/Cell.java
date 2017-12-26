package maze;

import maze.sides.Side;
import maze.tools.EndToken;
import maze.tools.StartToken;
import maze.tools.Tool;

public class Cell {
//    private int x, y;
    private Position position;
    public Side north, south, east, west;
    private Tool tool = null;
    private boolean _isStart = false;
    private boolean _isEnd = false;

    public Cell(int x, int y, Side north, Side south, Side east, Side west, Tool tool) {
//        this.x = x;
//        this.y = y;
        this.position = new Position(x, y);
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        if(tool instanceof StartToken)
            this.markAsStart();
        else if(tool instanceof EndToken)
            this.markAsEnd();
        else
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
        return String.format("(%d, %d, %s)", position.x, position.y, tool);
    }

    public void markAsStart() {
        assert !this._isEnd;
        this._isStart = true;
    }

    public void markAsEnd() {
        assert !this._isStart;
        this._isEnd = true;
    }

    public boolean isStart() {
        return this._isStart;
    }

    public boolean isEnd() {
        return this._isEnd;
    }

    public Position getPosition() {
        return position;
    }
}
