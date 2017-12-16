package maze.actions;

import maze.Cell;
import maze.Player;
import maze.sides.Side;

public interface LeaveCellAction {
    public void doAction(Player player, Cell cell, Side side);
}
