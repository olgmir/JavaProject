package maze;

public class Game {
    public Maze maze;
    public Position position;

    public Game(Maze maze, Position initialPostion) {
        this.maze = maze;
        this.position = initialPostion;
    }

    public void goUp() {
        if(canGoUp()) {
            position.x--;
        }

    }
    public void goDown() {
        if(canGoDown()) {
            position.x++;
        }
    }
    public void goRight() {
        if(canGoRight()) {
            position.y++;
        }
    }
    public void goLeft() {
        if(canGoLeft()) {
            position.y--;
        }
    }
    public boolean canGoUp() {
        return position.x != 0;
    }
    public boolean canGoDown() {
        return position.x != maze.height - 1;
    }
    public boolean canGoRight() {
        return position.y != maze.width - 1;
    }
    public boolean canGoLeft() {
        return position.y != 0;
    }
}
