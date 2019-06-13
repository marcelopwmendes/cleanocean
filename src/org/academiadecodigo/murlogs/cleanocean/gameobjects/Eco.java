package org.academiadecodigo.murlogs.cleanocean.gameobjects;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Eco {

    private TrashType trashType;
    private Grid grid;
    private GridPosition pos;
    private Picture pic;

    public Eco(GridPosition pos, TrashType trashType) {
        this.trashType = trashType;
        this.pos = pos;


        switch (trashType) {
            case PAPER:

                pos.setColor(GridColor.BLUE);
                break;
            case METAL:
                pos.setColor(GridColor.ORANGE);
                break;
            case PLASTIC:
                pos.setColor(GridColor.YELLOW);
                break;
            case GLASS:
                pos.setColor(GridColor.GREEN);
                break;
            case ORGANIC:
                pos.setColor(GridColor.RED);
                break;
        }
    }


    public int recycleTrash(int trashQuantity) {
        return trashType.getScore() * trashQuantity;
    }

    public GridPosition getPos() {
        return pos;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
