package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.*;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Movable;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Trash;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashFactory;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridFactory;
import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;



public class Game {

    private Grid grid;
    private int delay;
    private Player player;
    private Trash[] trashes;
    private Obstacle[] obstacles;
    private Eco[] ecos;
    private Reminder reminder;

    private int trashQuantity = 1;
    private int obstacleQuantity = 0;
    private int ecoQuantity = 5;
    private CollisionDetector collisionDetector;

    int countTrash = 0;

    public Game(GridType gridType, int cols, int rows, int delay) {
        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;
    }


    public void init() {

        grid.init();


        trashes = new Trash[trashQuantity];
        obstacles = new Obstacle[obstacleQuantity];
        ecos = new Eco[ecoQuantity];


        for (int i = 0; i < ecos.length; i++) {
            ecos[i] = EcoFactory.makeEco(grid);
            ecos[i].setGrid(grid);
        }

        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = ObstacleFactory.makeObstacle(grid);
            obstacles[i].setGrid(grid);
        }

        for (int i = 0; i < trashes.length; i++) {
            trashes[i] = TrashFactory.makeTrash(grid, obstacles, collisionDetector);
            trashes[i].setGrid(grid);
        }

        GridPosition gridPosition = grid.makeGridPosition(Main.COLS - 1, Main.ROWS - 5, "pig40.png");
        player = new Player(gridPosition, ecos);


        collisionDetector = new CollisionDetector(obstacles, ecos, trashes, grid, player);

        player.setCollisionDetector(collisionDetector);



    }


    public void start() throws InterruptedException {

        System.out.println("Starting CleanOcean...");

        init();

        reminder = new Reminder(1);
        System.out.println("Task scheduled.");

        boolean flag = true;

        while (flag) {
            for (Trash t : trashes) {
                if (!t.getPicked()) {
                    if (t instanceof Movable) {
                        t.move();
                        //}
                        // if (t.getTrashType() == TrashType.PAPER || t.getTrashType() == TrashType.PLASTIC) {
                        //   t.move();

                    }
                }
                if (t.getPicked()) {
                    countTrash++;
                    if (countTrash >= trashes.length) {
                        countTrash = trashes.length;
                        if ((player.getPosition().getCol() == (Main.COLS - 1)) && (player.getPosition().getRow() == (Main.ROWS - 1))) {
                            player.setInBeach(false);
                            grid.setBackgroundSand("Ocean.png");
                            flag = false;
                        }
                    }
                }
            }
            Thread.sleep(delay);
        }
    }
}


