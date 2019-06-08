package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class Paper extends Trash {

    public Paper(GridPosition gridPosition) {
        super(gridPosition, TrashType.PAPER);
    }

}
