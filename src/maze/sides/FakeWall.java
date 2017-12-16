package maze.sides;

public class FakeWall extends Wall {
    @Override
    public boolean canGoThrough() {
        return true;
    }
}
