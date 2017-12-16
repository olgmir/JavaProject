package maze;

import maze.tools.Tool;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Maze maze;
    public Position position;
    public List<Tool> inventory;

    public Game(Maze maze, Position initialPosition) {
        this.maze = maze;
        this.position = initialPosition;
        this.inventory = new ArrayList<>();
    }

    public void goUp() {
        if(maze.canGoUp(position)) {
            position.x--;
        }
        if(maze.containsTool(position)) {
            inventory.add(maze.getTool(position));
        }

    }
    public void goDown() {
        if(maze.canGoDown(position)) {
            position.x++;
        }
        if(maze.containsTool(position)) {
            inventory.add(maze.getTool(position));
        }
    }
    public void goRight() {
        if(maze.canGoRight(position)) {
            position.y++;
        }
        if(maze.containsTool(position)) {
            inventory.add(maze.getTool(position));
        }
    }
    public void goLeft() {
        if(maze.canGoLeft(position)) {
            position.y--;
        }
        if(maze.containsTool(position)) {
            inventory.add(maze.getTool(position));
        }
    }
}
