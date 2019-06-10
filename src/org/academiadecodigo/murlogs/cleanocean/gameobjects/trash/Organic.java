package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Organic extends Trash implements Movable {

    public Organic(GridPosition gridPosition, CollisionDetector collisionDetector) {

        super(gridPosition, TrashType.ORGANIC, collisionDetector);
    }

    @Override
    public void move() {
    }
}
