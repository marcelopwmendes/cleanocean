package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.Movable;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Glass extends Trash implements Movable {

    public Glass(GridPosition gridPosition) {

        super(gridPosition, TrashType.GLASS);
    }

    @Override
    public void move() {
    }
}
