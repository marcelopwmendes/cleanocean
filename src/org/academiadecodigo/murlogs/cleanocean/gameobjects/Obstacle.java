package org.academiadecodigo.murlogs.cleanocean.gameobjects;

import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public abstract class Obstacle { // classe Obstacle para ABSTRACT - para criar obstáculos diferentes

    protected GridPosition position;
    private Grid grid;
    protected GridDirection currentDirection = GridDirection.UP;



    public Obstacle(GridPosition pos) {
        this.position = pos;
        pos.setColor(GridColor.RED);
    }



    public void accelerate(GridDirection direction) {

        GridDirection newDirection = direction;


        currentDirection = newDirection;

        position.moveInDirection(newDirection, 1);
                /*if (collisionDetector.isUnSafe(position())) {
                    crash();
                    break;
                }*/

    }


    public GridDirection chooseDirection() {

        return GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];

    }



    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPosition() {
        return position;
    }

}
