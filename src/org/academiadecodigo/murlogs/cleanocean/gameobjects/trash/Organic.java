package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.Movable;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Organic extends Trash implements Movable {

    public Organic(GridPosition gridPosition) {

        super(gridPosition, TrashType.ORGANIC);
    }

    @Override
    public void move() {
    }
}
