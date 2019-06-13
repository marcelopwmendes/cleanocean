package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.*;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles.Obstacle;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles.ObstacleFactory;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Trash;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashFactory;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.GridFactory;
import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
import org.academiadecodigo.murlogs.cleanocean.menus.StarterMenu;
//import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class GameOcean {

    /*private Grid grid;
    private int delay;
    private Player player;
    private Trash[] trashes;
    private Obstacle[] obstacles;
    private Eco[] ecos;
    private Reminder reminder;
    private Trash trash;
    private int score;
    private int trashQuantity = 10;
    private int obstacleQuantity = 0;
    private Game game;
    //private int ecoQuantity = 5;
    private CollisionDetector collisionDetector;

    public GameOcean(GridType gridType, int cols, int rows, int delay, int score, Game game) {
        grid = GridFactory.makeGrid(gridType, cols, rows, "Ocean.png");
        this.delay = delay;
        this.score = score;
        this.game = game;
        //this.player = player;
        //this.player.setGrid(grid);
    }


    public void init() {

        grid.init();


        trashes = new Trash[trashQuantity];
        obstacles = new Obstacle[obstacleQuantity];
        //ecos = new Eco[ecoQuantity];


        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = ObstacleFactory.makeSeaObstacle(grid);
            obstacles[i].setGrid(grid);
        }

        for (int i = 0; i < trashes.length; i++) {
            trashes[i] = TrashFactory.makeTrash(grid, obstacles, collisionDetector);
            while (trashes[i].getTrashType() == TrashType.PAPER || trashes[i].getTrashType() == TrashType.ORGANIC) {
                trashes[i] = TrashFactory.makeTrash(grid, obstacles, collisionDetector);
            }
            trashes[i].setGrid(grid);
        }

        player = new Player(grid, grid.makeGridPosition(Main.COLS - 1, 2, "pig40.png"), ecos);
        player.setScore(score);
        player.setInBeach(false);
        System.out.println(score);

        collisionDetector = new CollisionDetector(obstacles, trashes, grid, player);

        player.setCollisionDetector(collisionDetector);


    }


    public void start() throws InterruptedException {

        System.out.println("Starting CleanOcean...");
        init();

        //reminder = new Reminder(1);
        //System.out.println("Task scheduled.");

        while (true) {
            for (Trash t : trashes) {
                if (!t.getPicked()) {
                    t.move();
                    //if (collisionDetector.detectPlayer(t.getPosition(), t.getDirection())) {
                    //    player.pickTrash(t);
                    //}
                }
            }
            if (player.getTrashWeight() > 0 && player.getPosition().getCol() == Main.COLS - 1 && player.getPosition().getRow() == 0) {
                player.translate();
                player.setInBeach(true);
                game.goBack();
                //grid.setBackgroundSand("Sand.png");


            }


            Thread.sleep(delay);
        }
    }
*/
}
