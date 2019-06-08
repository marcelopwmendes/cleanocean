package org.academiadecodigo.murlogs.cleanocean.gameobjects;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Eco {

    private TrashType trashType;
    private Grid grid;
    private GridPosition pos;


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


<<<<<<< HEAD
    public int recycleTrash(int trashQuantity) {
        return trashType.getScore()*trashQuantity;
=======
    public int recycleTrash(int trash) {
        int count = 0;

        count = count + (trash * trashType.getScore());


        return count;
>>>>>>> 7c1368f1ddad1c92fdc7eb2f3c1bf1cfd8961eaf
    }


    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
