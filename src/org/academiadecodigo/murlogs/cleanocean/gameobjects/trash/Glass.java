package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Glass extends Trash implements Movable {

    public Glass(GridPosition gridPosition, CollisionDetector collisionDetector) {

        super(gridPosition, TrashType.GLASS, collisionDetector);
    }

    @Override
    public void move() {
    }
}
