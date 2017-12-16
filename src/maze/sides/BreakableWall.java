package maze.sides;

public class BreakableWall extends Wall {
    private boolean isBroken = false;

    @Override
    public boolean canGoThrough() {
        return isBroken;
    }

    public void kapootMaken() {
        this.isBroken = true;
    }
}
