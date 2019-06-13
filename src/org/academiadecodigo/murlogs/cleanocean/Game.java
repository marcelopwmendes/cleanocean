package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.*;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Movable;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Trash;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashFactory;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridFactory;
import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
import org.academiadecodigo.murlogs.cleanocean.menus.StarterMenu;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Game implements KeyboardHandler {

    private Grid grid;
    private int delay;
    private Player player;
    private Trash[] trashes;
    private Obstacle[] obstacles;
    private Eco[] ecos;
    private Reminder reminder;
    private StarterMenu starterMenu = new StarterMenu(this);
    private boolean play = false;
    private int cols;
    private int rows;

    Keyboard keyboard = new Keyboard(this);
    KeyboardEvent pressQ;

    private int trashQuantity = 20;
    private int obstacleQuantity = 10;
    private int ecoQuantity = 5;
    private CollisionDetector collisionDetector;

    int countTrash = 0;

    public Game(GridType gridType, int cols, int rows, int delay) {
        grid = GridFactory.makeGrid(gridType, cols, rows, "Sand.png");
        this.cols = cols;
        this.rows = rows;
        this.delay = delay;
    }


    public void init() {

        grid.init();
        keyboardinit();

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
        player = new Player(grid, gridPosition, ecos);


        collisionDetector = new CollisionDetector(obstacles, ecos, trashes, grid, player);

        player.setCollisionDetector(collisionDetector);

        play = true;

    }


    public void start() throws InterruptedException {

        System.out.println("Starting CleanOcean...");

        starterMenu.starterMenu();
        //init();

        while (!play) {
            Thread.sleep(500);
        }

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
                            GameOcean gameOcean = new GameOcean(GridType.SIMPLE_GFX, cols, rows, delay, player.getScore());
                            gameOcean.start();
                            flag = false;

                        }
                    }
                }
            }
            Thread.sleep(delay);
        }

    }


    public void keyboardinit() {

        pressQ = new KeyboardEvent();
        pressQ.setKey(KeyboardEvent.KEY_Q);
        pressQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(pressQ);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}



