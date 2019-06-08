package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.*;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Trash;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashFactory;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridFactory;
import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
//import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class Game {

    private Grid grid;
    private int delay;
    private Player player;
    private Trash[] trashes;
    private Obstacle[] obstacles;
    private Eco[] ecos;

    private int trashQuantity = 20;
    private int obstacleQuantity = 10;
    private int ecoQuantity = 5;


    public Game(GridType gridType, int cols, int rows, int delay) {
        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;
    }


    public void init() {

        grid.init();


        trashes = new Trash[trashQuantity];
        obstacles = new Obstacle[obstacleQuantity];
        ecos = new Eco[ecoQuantity];

        int row = 0;
        for (int i = 0; i < ecos.length; i++) {
            ecos[i] = new Eco(grid.makeGridPosition(Main.COLS - 1, row), TrashType.values()[i]);
            ecos[i].setGrid(grid);
            row += 1;
        }

        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = ObstacleFactory.makeObstacle(grid);
            obstacles[i].setGrid(grid);
        }

        for (int i = 0; i < trashes.length; i++) {
            trashes[i] = TrashFactory.makeTrash(grid, obstacles);
            trashes[i].setGrid(grid);
        }


        CollisionDetector collisionDetector = new CollisionDetector(obstacles, ecos, trashes, grid);

        player = new Player(grid.makeGridPosition(Main.COLS - 1, Main.ROWS - 1));
        player.setCollisionDetector(collisionDetector);

    }


    public void start() {

        System.out.println("Starting CleanOcean...");
        init();

    }

}
