package maze;

import javafx.geometry.Pos;
import maze.sides.OpenSide;
import maze.tools.Tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maze {
    public List<Cell> cells;
    public int width, height;

    public Maze(int width, int height){
        this.width = width;
        this.height = height;
        this.cells = new ArrayList<>(width*height);
        for(int i=0; i < height; i++) {
            for(int j=0; j < width; j++) {
                cells.add(new Cell(i, j, new OpenSide(), new OpenSide(), new OpenSide(), new OpenSide()));
            }
        }
    }

    public Maze(int width, int height, List<Cell> cells) {
        assert width * height == cells.size();
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    private Position getCoordinates(int index) {
        int x = index / width;
        int y = index % width;
        return new Position(x, y);
    }

    public Cell getCell(int row, int column) {
        return this.cells.get(row * width + column);
    }

    public Cell getCell(Position pos) {
        return getCell(pos.x, pos.y);
    }

    public Map<String, Cell> getNeighbors(int row, int column) {
        Map<String, Cell> result = new HashMap<>();

        if(row == 0) {
            result.put("Up", null);
            result.put("Down", getCell(row + 1, column));
        }
        else if(row == height - 1) {
            result.put("Up", getCell(row - 1, column));
            result.put("Down", null);
        }
        else{
            result.put("Up", getCell(row - 1, column));
            result.put("Down", getCell(row + 1, column));
        }

        if(column == 0) {
            result.put("Left", null);
            result.put("Right", getCell(row,column + 1));
        }
        else if(column == width -1) {
            result.put("Left", getCell(row, column - 1));
            result.put("Right", null);
        }
        else{
            result.put("Left", getCell(row, column - 1));
            result.put("Right", getCell(row, column + 1));
        }
        return result;
    }

    public boolean canGoUp(Position pos) {
        Cell cell = getCell(pos);
        return cell.north.canGoThrough();
    }

    public boolean canGoDown(Position pos) {
        Cell cell = getCell(pos);
        return cell.south.canGoThrough();
    }

    public boolean canGoLeft(Position pos) {
        Cell cell = getCell(pos);
        return cell.west.canGoThrough();
    }

    public boolean canGoRight(Position pos) {
        Cell cell = getCell(pos);
        return cell.east.canGoThrough();
    }

    public boolean containsTool(Position position) {
        return getCell(position).containsTool();
    }

    public Tool getTool(Position position) {
        return getCell(position).pickUpTool();
    }

    public void printMaze() {
        for(int i=0; i < height; i++) {
            for(int j=0; j < width; j++) {
                System.out.print(getCell(i, j));
            }
            System.out.println();
        }
    }
}
