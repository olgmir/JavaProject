package maze;

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
                cells.add(new Cell(i, j));
            }
        }
    }

    private Point2D getCoordinates(int index) {
        int x = index / width;
        int y = index % width;
        return new Point2D(x, y);
    }

    public Cell getCell(int row, int column) {
        return this.cells.get(row * width + column);
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

    public void printMaze() {
        for(int i=0; i < height; i++) {
            for(int j=0; j < width; j++) {
                System.out.print(getCell(i, j));
            }
            System.out.println();
        }
    }
}
