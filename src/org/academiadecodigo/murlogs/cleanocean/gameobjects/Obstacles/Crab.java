package org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles;

// Land critter that will make you dizzy -
// if it pinches you, your direction keys will be randomized/changed.

import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacle;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Movable;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Crab extends Obstacle implements Movable {


    private int counter = 0;


    public Crab(GridPosition position) {

        super(position);
    }




    public void move() {

        counter++;
        if (counter % 4 == 0) {
            accelerate(chooseDirection());
        }
    }



}
