package org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles;

// Land critter that will make you dizzy -
// if it pinches you, your direction keys will be randomized/changed.

import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Movable;


import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Crab extends Obstacle implements Movable {


    private int counter;
    private boolean freezed = false;


    public Crab(GridPosition position) {

        super(position);
    }


    @Override
    public void move() {

        if (counter == 0) {
            counter = (int) (Math.random() * 4);
        }

        if (freezed) {
            counter--;
            if (counter < 0) {
                counter = 0;
                freezed = false;
                double random = Math.random();
                currentDirection = (random < 0.5) ? GridDirection.LEFT : GridDirection.RIGHT;
            }
            return;
        }

        int col = position.getCol();
        if (col == 0 || col == Main.COLS - 1) {
            if (currentDirection == GridDirection.RIGHT) {
                currentDirection = GridDirection.LEFT;
            } else if (currentDirection == GridDirection.LEFT) {
                currentDirection = GridDirection.RIGHT;
            }
        }
        accelerate(currentDirection);
        counter--;
        if (counter < 0) {
            counter = 0;
            freezed = true;
        }

    }

}
