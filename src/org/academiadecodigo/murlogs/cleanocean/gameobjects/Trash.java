package org.academiadecodigo.murlogs.cleanocean.gameobjects;

import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Trash {

    private GridPosition position;
    private Grid grid;
    private TrashType trashType;
    private boolean picked;


    public Trash(GridPosition position, TrashType trashType) {
        this.trashType = trashType;
        this.position = position;
        picked = false;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
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

    public void setPicked() {
        picked = true;
        position.hide();
    }

}
