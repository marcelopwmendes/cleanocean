package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Plastic extends Trash implements Movable {


    public Plastic(GridPosition gridPosition, CollisionDetector collisionDetector) {

        super(gridPosition, TrashType.PLASTIC, collisionDetector);
    }


    @Override
    public void move() {
    }
}
