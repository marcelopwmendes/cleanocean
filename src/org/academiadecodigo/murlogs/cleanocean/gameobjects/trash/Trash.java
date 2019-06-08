package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class Trash {                    //abstract

    private GridPosition position;
    private Grid grid;
    private TrashType trashType;
    private boolean picked;


    public Trash(GridPosition position, TrashType trashType) {
        this.trashType = trashType;
        this.position = position;
        picked = false;
        setTrashColor(trashType);

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
