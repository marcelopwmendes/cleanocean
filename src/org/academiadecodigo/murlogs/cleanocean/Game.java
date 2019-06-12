package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.*;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Movable;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Trash;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashFactory;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridFactory;
import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;


public class Game {

    private Grid grid;
    private int delay;
    private Player player;
    private Trash[] trashes;
    private Obstacle[] obstacles;
    private Eco[] ecos;
    private Reminder reminder;

    public static Text score;
    public static Text organic;
    public static Text glass;
    public static Text metal;
    public static Text plastic;
    public static Text paper;
    public static Text weight;

    private int trashQuantity = 1;
    private int obstacleQuantity = 0;
    private int ecoQuantity = 5;
    private CollisionDetector collisionDetector;

    int countTrash = 0;

    public Game(GridType gridType, int cols, int rows, int delay) {
        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;
    }

    public void inventory(){
        score = new Text(34, 30, "SCORE: " + 0);
        score.setColor(Color.RED);
        score.draw();
        organic = new Text(34, 42, "ORGANIC: " + 0);
        organic.setColor(Color.GRAY);
        organic.draw();
        glass = new Text(34, 54, "GLASS: " + 0);
        glass.setColor(Color.GREEN);
        glass.draw();
        metal = new Text(34, 66, "METAL: " + 0);
        metal.setColor(Color.YELLOW);
        metal.draw();
        plastic = new Text(34, 78, "PLASTIC: " + 0);
        plastic.setColor(Color.ORANGE);
        plastic.draw();
        paper = new Text(34, 90, "PAPER: " + 0);
        paper.setColor(Color.CYAN);
        paper.draw();
        weight= new Text(25,110,"WEIGHT: " + 0 + " /25");
        weight.setColor(Color.WHITE);
        weight.draw();
    }


    public void init() {

        grid.init();

        trashes = new Trash[trashQuantity];
        obstacles = new Obstacle[obstacleQuantity];
        ecos = new Eco[ecoQuantity];

        Rectangle rectangle = new Rectangle(10, 10, 120, 150);
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
        rectangle.fill();
        inventory();


        int col = Main.COLS - 1;
        int row = 0;
        for (int i = 0; i < ecos.length; i++) {
            ecos[i] = new Eco(grid.makeGridPosition(col, row), TrashType.values()[i]);
            ecos[i].setGrid(grid);
            col -= 1;
        }

        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = ObstacleFactory.makeObstacle(grid);
            obstacles[i].setGrid(grid);
        }

        for (int i = 0; i < trashes.length; i++) {
            trashes[i] = TrashFactory.makeTrash(grid, obstacles, collisionDetector);
            trashes[i].setGrid(grid);
        }

        player = new Player(grid.makeGridPosition(Main.COLS - 1, Main.ROWS - 1), ecos);

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


