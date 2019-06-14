package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public abstract class Trash {

    private GridPosition position;
    private Grid grid;
    private TrashType trashType;
    private boolean picked;

    protected GridDirection currentDirection = GridDirection.UP;

    public Trash(GridPosition position, TrashType trashType) {
        this.trashType = trashType;
        this.position = position;
        picked = false;
    }


    public abstract void move();


    public void accelerate(GridDirection direction) {

        GridDirection newDirection = direction;

        currentDirection = newDirection;

        position.moveInDirection(newDirection, 1);


    }

    public GridDirection chooseDirection() {

        return GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];

    }

    public GridPosition getPosition() {
        return position;
    }

    public GridDirection getDirection() {
        return currentDirection;
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

    public void randomPos(){
        position.setPos((int) (Math.random() * Main.COLS), (int) (Math.random() * Main.ROWS));
    }

    public void setPicked() {
        picked = true;
        position.hide();
    }

}
