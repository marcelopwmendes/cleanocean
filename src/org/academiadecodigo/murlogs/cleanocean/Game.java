package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.*;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridFactory;
import org.academiadecodigo.murlogs.cleanocean.grid.GridType;


public class Game {

    private Grid grid;
    private int delay;
    private Player player;
    private Trash[] trashes;
    private Obstacle[] obstacles;
    private Eco[] eco;
    private int trashQuantity = 20;
    private int obstacleQuantity = 10;
    private int ecoQuantity = 5;

    public Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;

    }


    public void init() {

        grid.init();

        player = new Player(grid.makeGridPosition(70,20));
        trashes = new Trash[trashQuantity];
        obstacles = new Obstacle[obstacleQuantity];
        eco = new Eco[ecoQuantity];

        for (int i = 0; i < trashes.length; i++) {
            int random = (int) (Math.random() * TrashType.values().length);
            TrashType trashType = TrashType.values()[random];
            int col = (int) (Math.random() * 80);
            int row = (int) (Math.random() * 25);
            trashes[i] = new Trash(grid.makeGridPosition(col, row), trashType);
            trashes[i].setGrid(grid);
        }

        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new Obstacle(grid.makeGridPosition());
            obstacles[i].setGrid(grid);
        }

        int col = 79;
        int row = 0;
        for (int i = 0; i < eco.length; i++) {
            eco[i] = new Eco(grid.makeGridPosition(col, row), TrashType.values()[i]);
            eco[i].setGrid(grid);
            row += 1;
        }


    }


    public void start() {

        System.out.println("Starting CleanOcean...");
        init();

    }

}
