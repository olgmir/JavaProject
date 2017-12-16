package maze;

import maze.actions.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Maze maze;
    public Player player;
    public List<EnterCellAction> enterCellActions;
    public List<LeaveCellAction> leaveCellActions;

    public Game(Maze maze, Position initialPosition) {
        this.maze = maze;
        this.player = new Player(initialPosition);

        this.enterCellActions = new ArrayList<>();
        this.enterCellActions.add(new PickUpTool());

        this.leaveCellActions = new ArrayList<>();
        this.leaveCellActions.add(new BreakWall());
        this.leaveCellActions.add(new OpenDoor());
    }

    public void goUp() {
        Cell currentCell = maze.getCell(player.getPosition());
        for (LeaveCellAction action: leaveCellActions) {
            action.doAction(player, currentCell, currentCell.north);
        }
        if(maze.canGoUp(player.getPosition())) {
            player.getPosition().x--;
        }
        Cell newCell = maze.getCell(player.getPosition());
        for (EnterCellAction action : enterCellActions) {
            action.doAction(player, newCell);
        }

    }
    public void goDown() {
        Cell currentCell = maze.getCell(player.getPosition());
        for (LeaveCellAction action: leaveCellActions) {
            action.doAction(player, currentCell, currentCell.south);
        }
        if(maze.canGoDown(player.getPosition())) {
            player.getPosition().x++;
        }
        Cell newCell = maze.getCell(player.getPosition());
        for (EnterCellAction action : enterCellActions) {
            action.doAction(player, newCell);
        }
    }
    public void goRight() {
        Cell currentCell = maze.getCell(player.getPosition());
        for (LeaveCellAction action: leaveCellActions) {
            action.doAction(player, currentCell, currentCell.east);
        }
        if(maze.canGoRight(player.getPosition())) {
            player.getPosition().y++;
        }
        Cell newCell = maze.getCell(player.getPosition());
        for (EnterCellAction action : enterCellActions) {
            action.doAction(player, newCell);
        }
    }
    public void goLeft() {
        Cell currentCell = maze.getCell(player.getPosition());
        for (LeaveCellAction action: leaveCellActions) {
            action.doAction(player, currentCell, currentCell.west);
        }
        if(maze.canGoLeft(player.getPosition())) {
            player.getPosition().y--;
        }
        Cell newCell = maze.getCell(player.getPosition());
        for (EnterCellAction action : enterCellActions) {
            action.doAction(player, newCell);
        }
    }
}
