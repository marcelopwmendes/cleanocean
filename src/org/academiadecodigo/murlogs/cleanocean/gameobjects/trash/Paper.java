package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Movable;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class Paper extends Trash implements Movable {

    private int counter = 0;

    public Paper(GridPosition gridPosition ) {

        super(gridPosition, TrashType.PAPER);
    }

    @Override
    public void move() {
        counter++;
        if (counter % 4 == 0) {
            accelerate(chooseDirection());
        }
    }



}
