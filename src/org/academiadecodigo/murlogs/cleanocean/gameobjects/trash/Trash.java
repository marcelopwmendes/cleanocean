package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public abstract class Trash {

    private GridPosition position;
    private Grid grid;
    private TrashType trashType;
    private boolean picked;
    private CollisionDetector collisionDetector;

    protected GridDirection currentDirection = GridDirection.UP;

    public Trash(GridPosition position, TrashType trashType, CollisionDetector collisionDetector) {
        this.trashType = trashType;
        this.position = position;
        this.collisionDetector = collisionDetector;
        picked = false;
        setTrashColor(trashType);

    }


    public abstract void move();


    public void accelerate(GridDirection direction, int speed) {

        GridDirection newDirection = direction;


        currentDirection = newDirection;

        for (int i = 0; i < speed; i++) {
            position.moveInDirection(newDirection, 1);
                /*if (collisionDetector.isUnSafe(position())) {
                    crash();
                    break;
                }*/
        }
    }


    public boolean isHittingWall() {

        switch (currentDirection) {
            case LEFT:
                if (position.getCol() == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (position.getCol() == grid.getCols() - 1) {
                    return true;
                }
                break;
            case UP:
                if (position.getRow() == 0) {
                    return true;
                }
                break;
            case DOWN:
                if (position.getRow() == grid.getRows() - 1) {
                    return true;
                }
        }

        return false;

    }


    public GridPosition getPosition() {
        return position;
    }


    public TrashType getTrashType() {
        return trashType;
    }


    public boolean getPicked() {
        return picked;
    }


    public void setGrid(Grid grid) {
        this.grid = grid;
    }


    public void setTrashColor(TrashType trashType) {
        switch (trashType) {
            case PAPER:
                position.setColor(GridColor.BLUE);
                break;
            case METAL:
                position.setColor(GridColor.ORANGE);
                break;
            case PLASTIC:
                position.setColor(GridColor.YELLOW);
                break;
            case GLASS:
                position.setColor(GridColor.GREEN);
                break;
            case ORGANIC:
                position.setColor(GridColor.RED);
                break;
        }
    }


    public void setPicked() {
        picked = true;
        position.hide();
    }

}
