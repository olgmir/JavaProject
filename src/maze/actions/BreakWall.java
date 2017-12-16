package maze.actions;

import maze.Cell;
import maze.Player;
import maze.sides.BreakableWall;
import maze.sides.Side;
import maze.tools.Hammer;

public class BreakWall implements LeaveCellAction {
    @Override
    public void doAction(Player player, Cell cell, Side side) {
        if(player.hasToolType(Hammer.class) && side instanceof BreakableWall) {
            ((BreakableWall) side).kapootMaken();
            System.out.println(String.format("Breaking the wall %s in cell %s", side,  cell));
        }
    }
}
