package org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles;

import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;

// "Factory" that creates the collidable objects.
// Vamos precisar das dimensões certas para poder criar os objectos certos no sítio certo -----------------------------
// landObstacles : criar número fixo de SHELLs e CRABs e deixar o resto aleatório
// seaObstacles : WHALE - criar uma e deixar o resto aleatório


public class ObstacleFactory {

    /** Create different obstacles in the beach */
    public static Obstacle makeBeachObstacle(Grid grid) {

        int col;
        int row;

        row = (int) (Math.random() * Main.ROWS);
        col = (int) (Math.random() * Main.COLS);


        while ( ((col > Main.COLS - 6) && (row == 0)) || (row > Main.ROWS - 5)) {
            col = (int) (Math.random() * Main.COLS);
            row = (int) (Math.random() * Main.ROWS);
        }

        int random = (int) (Math.random() * LandObstacle.values().length);
        LandObstacle landObstacle = LandObstacle.values()[random];


        Obstacle obstacle;

        String[] others = {"Obstacles/House_64.png", "Obstacles/Towel2_40.png", "Obstacles/Towel_40.png", "Obstacles/Tree_64.png"};
        int pic = (int) (Math.random() * others.length);

        String[] shells = {"Obstacles/Shell_40.png", "Obstacles/Shell2_40.png"};
        int picShells = (int) (Math.random() * shells.length);

        switch (landObstacle) {

            case SHELL:
                obstacle = new Shell(grid.makeGridPosition(col, row, shells[picShells]));
                break;
            case CRAB:
                obstacle = new Crab(grid.makeGridPosition(col, row, "Obstacles/Crab_40.png"));
                break;
            case OTHERS:
                obstacle = new Others(grid.makeGridPosition(col, row,  others[pic]));
                break;
            default:
                obstacle = new Rock(grid.makeGridPosition());
        }
        return obstacle;
    }

    public static Obstacle makeSeaObstacle(Grid grid) {

        int col;
        int row;

// NEEDS CHANGE  - dimensões do mapa para ver onde é o mar e onde é a terra --------------------------------------------

        row = (int) (Math.random() * Main.ROWS);
        col = (int) (Math.random() * Main.COLS);

        while ((col == Main.COLS - 1) && ((row == Main.ROWS - 1) || (row <= 4))) {
            col = (int) (Math.random() * Main.COLS);
            row = (int) (Math.random() * Main.ROWS);
        }



        int random = (int) (Math.random() * SeaObstacle.values().length);
        SeaObstacle seaObstacle = SeaObstacle.values()[random];

        Obstacle obstacle;
        switch (seaObstacle) {
            case ROCK:
                obstacle = new Rock(grid.makeGridPosition());
                break;
            case BUOY:
                obstacle = new Buoy(grid.makeGridPosition());
                break;
       //   case WHALE:
        //        obstacle = new Whale(grid.makeGridPosition());
         //       break;
            default:
                obstacle = new Rock(grid.makeGridPosition());
        }
        return obstacle;
    }

}
