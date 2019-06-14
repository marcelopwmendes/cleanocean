package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.Movable;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Plastic extends Trash implements Movable {

    private int counter = 0;

    public Plastic(GridPosition gridPosition) {

        super(gridPosition, TrashType.PLASTIC);
    }


    @Override
    public void move() {
        counter++;

        if (counter % 2 == 0) {
            accelerate(chooseDirection());
        }
    }

    public GridDirection chooseDirection() {

        return GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];

    }

}
