package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Plastic extends Trash {

    public Plastic(GridPosition gridPosition) {
        super(gridPosition, TrashType.PLASTIC);
    }
}
