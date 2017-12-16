package maze.sides;

public class Wall extends Side {
    @Override
    public boolean canGoThrough() {
        return false;
    }
}
