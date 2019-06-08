package org.academiadecodigo.murlogs.cleanocean.gameobjects;

import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;

public class ObstacleFactory {

    public static Obstacle makeObstacle(Grid grid) {

        int col;
        int row;


        row = (int) (Math.random() * Main.ROWS);
        col = (int) (Math.random() * Main.COLS);

        while ((col == Main.COLS - 1) && ((row == Main.ROWS - 1) || (row <= 4))) {
            col = (int) (Math.random() * Main.COLS);
            row = (int) (Math.random() * Main.ROWS);
        }


        return new Obstacle(grid.makeGridPosition(col, row));
    }
}
