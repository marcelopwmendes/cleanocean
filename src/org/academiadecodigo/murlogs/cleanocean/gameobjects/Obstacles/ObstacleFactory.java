package org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles;

import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;

/**
 * Creates collidable objects
 */

public class ObstacleFactory {

    /**
     * Creates different obstacles in the beach
     */
    public static Obstacle makeBeachObstacle(Grid grid) {

        int col;
        int row;

        row = (int) (Math.random() * Main.ROWS);
        col = (int) (Math.random() * Main.COLS);


        while (((col > Main.COLS - 6) && (row == 0)) || (row > Main.ROWS - 5)) {
            col = (int) (Math.random() * Main.COLS);
            row = (int) (Math.random() * Main.ROWS);
        }

        int random = (int) (Math.random() * LandObstacle.values().length);
        LandObstacle landObstacle = LandObstacle.values()[random];


        Obstacle obstacle;

        String[] others = {"resources/Obstacles/House_64.png", "resources/Obstacles/Towel2_40.png", "resources/Obstacles/Towel_40.png", "resources/Obstacles/Tree_64.png"};
        int pic = (int) (Math.random() * others.length);

        String[] shells = {"resources/Obstacles/Shell_40.png", "resources/Obstacles/Shell2_40.png"};
        int picShells = (int) (Math.random() * shells.length);

        switch (landObstacle) {

            case SHELL:
                obstacle = new Shell(grid.makeGridPosition(col, row, shells[picShells]));
                break;
            case CRAB:
                obstacle = new Crab(grid.makeGridPosition(col, row, "resources/Obstacles/Crab_40.png"));
                break;
            case OTHERS:
                obstacle = new Others(grid.makeGridPosition(col, row, others[pic]));
                break;
            default:
                obstacle = new Rock(grid.makeGridPosition());
        }
        return obstacle;
    }

}
