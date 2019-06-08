package org.academiadecodigo.murlogs.cleanocean.gameobjects;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Eco {

    private TrashType trashType;
    private Grid grid;
    private GridPosition pos;


    public Eco(GridPosition pos, TrashType trashType) {
        this.trashType = trashType;
        this.pos = pos;
    }


    public int recycleTrash(int trashQuantity) {
        return trashType.getScore()*trashQuantity;
    }


    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    // Para quem retorna o score??
}
