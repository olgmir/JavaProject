package maze.actions;

import maze.Cell;
import maze.Player;
import maze.sides.Door;
import maze.sides.Side;
import maze.tools.Key;

public class OpenDoor implements LeaveCellAction {
    @Override
    public void doAction(Player player, Cell cell, Side side) {
        if(player.hasToolType(Key.class) && side instanceof Door) {
            ((Door) side).open();
            System.out.println(String.format("Opened the door %s in cell %s", side, cell));
        }
    }
}
