package maze.actions;

import maze.Cell;
import maze.Game;
import maze.Player;

public interface EnterCellAction {
    public void doAction(Player player, Cell cell);
}
