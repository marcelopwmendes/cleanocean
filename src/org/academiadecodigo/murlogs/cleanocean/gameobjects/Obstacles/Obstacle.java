package org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles;

import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public abstract class Obstacle { // classe Obstacle para ABSTRACT - para criar obstáculos diferentes

    protected GridPosition position;
    private Grid grid;
    protected GridDirection currentDirection = GridDirection.LEFT;


    public Obstacle(GridPosition pos) {
        this.position = pos;
    }


    public void move() {
    }


    public void accelerate(GridDirection direction) {

        GridDirection newDirection = direction;

        currentDirection = newDirection;

        position.moveInDirection(newDirection, 1);

    }


    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPosition() {
        return position;
    }


    public GridDirection getDirection() {
        return currentDirection;
    }


    public void randomPos() {
        position.setPos((int) (Math.random() * Main.COLS), (int) (Math.random() * Main.ROWS));
    }
}
