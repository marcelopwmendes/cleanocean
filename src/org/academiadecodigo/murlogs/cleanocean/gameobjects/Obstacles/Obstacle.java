package org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles;

import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public abstract class Obstacle { // classe Obstacle para ABSTRACT - para criar obstáculos diferentes

    private GridPosition position;
    private Grid grid;

    public Obstacle(GridPosition pos) {
        this.position = pos;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPosition() {
        return position;
    }

    public void randomPos(){
        position.setPos((int) (Math.random() * Main.COLS), (int) (Math.random() * Main.ROWS));
    }
}
