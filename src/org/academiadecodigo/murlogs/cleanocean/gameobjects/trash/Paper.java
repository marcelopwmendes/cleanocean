package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class Paper extends Trash implements Movable {

    private final static int SPEED = 3;
    private int counter = 0;

    public Paper(GridPosition gridPosition ) {

        super(gridPosition, TrashType.PAPER);
    }

    @Override
    public void move() {
        counter++;
        //System.out.println("Moving...");
        if (counter % 4 == 0) {
            accelerate(chooseDirection(), Paper.SPEED);
        }
    }

    @Override
    public GridDirection chooseDirection() {

        return GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];

    }


}
