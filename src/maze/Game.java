package maze;

import javafx.geometry.Pos;
import maze.actions.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Maze maze;
    public Player player;
    public List<EnterCellAction> enterCellActions;
    public List<LeaveCellAction> leaveCellActions;
    public Position initialPosition;
    public Position endPosition;

    public Game(Maze maze, Position initialPosition, Position endPosition) {
        this.maze = maze;
        this.initialPosition = initialPosition;
        this.endPosition = endPosition;
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
            Position oldPosition = player.getPosition();
            player.updatePosition(oldPosition.x, oldPosition.y + 1);
        }
        Cell newCell = maze.getCell(player.getPosition());
        for (EnterCellAction action : enterCellActions) {
            action.doAction(player, newCell);
        }
        if (this.checkVictory()) {
            System.out.println("Victory!");
        }

    }
    public void goDown() {
        Cell currentCell = maze.getCell(player.getPosition());
        for (LeaveCellAction action: leaveCellActions) {
            action.doAction(player, currentCell, currentCell.south);
        }
        if(maze.canGoDown(player.getPosition())) {
            Position oldPosition = player.getPosition();
            player.updatePosition(oldPosition.x, oldPosition.y - 1);
        }
        Cell newCell = maze.getCell(player.getPosition());
        for (EnterCellAction action : enterCellActions) {
            action.doAction(player, newCell);
        }
        if (this.checkVictory()) {
            System.out.println("Victory!");
        }
    }
    public void goRight() {
        Cell currentCell = maze.getCell(player.getPosition());
        for (LeaveCellAction action: leaveCellActions) {
            action.doAction(player, currentCell, currentCell.east);
        }
        if(maze.canGoRight(player.getPosition())) {
            Position oldPosition = player.getPosition();
            player.updatePosition(oldPosition.x + 1, oldPosition.y);
        }
        Cell newCell = maze.getCell(player.getPosition());
        for (EnterCellAction action : enterCellActions) {
            action.doAction(player, newCell);
        }
        if (this.checkVictory()) {
            System.out.println("Victory!");
        }
    }
    public void goLeft() {
        Cell currentCell = maze.getCell(player.getPosition());
        for (LeaveCellAction action: leaveCellActions) {
            action.doAction(player, currentCell, currentCell.west);
        }
        if(maze.canGoLeft(player.getPosition())) {
            Position oldPosition = player.getPosition();
            player.updatePosition(oldPosition.x - 1, oldPosition.y);
        }
        Cell newCell = maze.getCell(player.getPosition());
        for (EnterCellAction action : enterCellActions) {
            action.doAction(player, newCell);
        }
        if (this.checkVictory()) {
            System.out.println("Victory!");
        }
    }

    public boolean checkVictory() {
        return player.getPosition().x == this.endPosition.x && player.getPosition().y == this.endPosition.y;
    }
}
