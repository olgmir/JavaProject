package maze.actions;

import maze.Cell;
import maze.Player;
import maze.tools.Tool;

public class PickUpTool implements EnterCellAction {
    @Override
    public void doAction(Player player, Cell cell) {
        if(cell.containsTool()) {
            Tool tool = cell.pickUpTool();
            if(tool != null) {
                player.takeTool(tool);
                System.out.println(String.format("Found %s in %s", tool, cell));
            }
        }
    }
}
