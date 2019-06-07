package org.academiadecodigo.murlogs.cleanocean.gameobjects.Trash;

import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Trash {

    private GridPosition position;
    private Grid grid;
    private TrashType trashType;
    private boolean picked;


   public Trash(GridPosition gridPosition, TrashType trashType) {
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
