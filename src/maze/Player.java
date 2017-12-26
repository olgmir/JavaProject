package maze;

import maze.tools.Tool;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Tool> inventory;
    private Position position;

    public Player(Position initialPosition) {
        this.position = initialPosition;
        this.inventory = new ArrayList<>();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void updatePosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }

    public void takeTool(Tool tool) {
        this.inventory.add(tool);
    }

    public List<Tool> getInventory() {
        return inventory;
    }

    public boolean hasToolType(Class<?> cls) {
        for (Tool tool: inventory) {
            if(tool.getClass() == cls)
                return true;
        }
        return false;
    }
}
