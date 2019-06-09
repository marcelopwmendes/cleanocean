package org.academiadecodigo.murlogs.cleanocean.gameobjects;

import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles.*;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.SimpleGfxGrid;

// "Factory" that creates the collidable objects.
// Vamos precisar das dimensões certas para poder criar os objectos certos no sítio certo -----------------------------
// landObstacles : criar número fixo de SHELLs e CRABs e deixar o resto aleatório
// seaObstacles : WHALE - criar uma e deixar o resto aleatório


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

        int random = (int) (Math.random() * LandObstacle.values().length);
        LandObstacle landObstacle = LandObstacle.values()[random];


        Obstacle obstacle;

        switch (landObstacle) {
            case SHELL:
                obstacle = new Shell(grid.makeGridPosition());
                break;
            case PEOPLESTUFF:
                obstacle = new PeopleStuff(grid.makeGridPosition());
                break;
            case ROCK:
                obstacle = new Rock(grid.makeGridPosition());
                break;
            case CRAB:
                obstacle = new Crab(grid.makeGridPosition());
                break;
            default:
                obstacle = new Rock(grid.makeGridPosition());
        }

        return obstacle;
    }

    public static Obstacle makeSeaObstacle(Grid grid) {

        int col;
        int row;

// NEEDS CHANGE  - dimensões do mapa para ver onde é o mar e onde é a terra --------------------------------------------------------------

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
       //     case WHALE:
        //        obstacle = new Whale(grid.makeGridPosition());
         //       break;
            default:
                obstacle = new Rock(grid.makeGridPosition());
        }
        return obstacle;
    }

}
