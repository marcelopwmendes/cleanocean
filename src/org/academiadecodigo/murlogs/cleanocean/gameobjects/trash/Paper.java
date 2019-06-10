package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class Paper extends Trash implements Movable {

    private final static int SPEED = 3;
    private int counter = 0;

    public Paper(GridPosition gridPosition, CollisionDetector collisionDetector) {

        super(gridPosition, TrashType.PAPER, collisionDetector);
    }

    @Override
    public void move() {
        counter++;
        //System.out.println("Moving...");
        if (counter % 2 == 0) {
            accelerate(chooseDirection(), Paper.SPEED);
        }
    }

    public GridDirection chooseDirection() {

        return GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];

    }


}
