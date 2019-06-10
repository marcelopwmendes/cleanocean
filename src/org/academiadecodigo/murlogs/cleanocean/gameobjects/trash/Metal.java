package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Metal extends Trash implements Movable{


    public Metal(GridPosition gridPosition, CollisionDetector collisionDetector) {

        super(gridPosition, TrashType.METAL, collisionDetector);
    }

    @Override
    public void move() {

    }
}
