package maze.sides;

public class Door extends Side {
    private boolean isOpen = false;

    @Override
    public boolean canGoThrough() {
        return isOpen;
    }

    public void open() {
        this.isOpen = true;
    }
}
