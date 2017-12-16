package maze;

public class Game {
    public Maze maze;
    public Position position;

    public Game(Maze maze, Position initialPosition) {
        this.maze = maze;
        this.position = initialPosition;
    }

    public void goUp() {
        if(maze.canGoUp(position)) {
            position.x--;
        }

    }
    public void goDown() {
        if(maze.canGoDown(position)) {
            position.x++;
        }
    }
    public void goRight() {
        if(maze.canGoRight(position)) {
            position.y++;
        }
    }
    public void goLeft() {
        if(maze.canGoLeft(position)) {
            position.y--;
        }
    }
}
