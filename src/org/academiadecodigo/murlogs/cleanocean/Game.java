package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.*;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles.Obstacle;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles.ObstacleFactory;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Movable;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Trash;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashFactory;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridFactory;
import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
import org.academiadecodigo.murlogs.cleanocean.menus.StarterMenu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * The Game Logic
 */
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

    Sound sound = new Sound("/resources/Musics/Beachsong.wav");

    public static Text score;
    public static Text organic;
    public static Text glass;
    public static Text metal;
    public static Text plastic;
    public static Text paper;
    public static Text weight;

    private int trashQuantity = 20;
    private int obstacleQuantity = 10;
    private int ecoQuantity = 5;
    private CollisionDetector collisionDetector;

    int countTrash = 0;

    public Game(GridType gridType, int cols, int rows, int delay) {
        grid = GridFactory.makeGrid(gridType, cols, rows, "resources/Backgrounds/Sand1280x720s.png");
        this.cols = cols;
        this.rows = rows;
        this.delay = delay;
    }

    public void inventory() {
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
        weight = new Text(25, 110, "WEIGHT: " + 0 + " /25");
        weight.setColor(Color.WHITE);
        weight.draw();
    }


    public void init() {


        grid.init();

        keyboardInit();

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
            ecos[i] = EcoFactory.makeEco(grid);
            ecos[i].setGrid(grid);
        }

        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = ObstacleFactory.makeBeachObstacle(grid);
            for (Eco e : ecos) {
                while (obstacles[i].getPosition().getCol() == e.getPos().getCol() && obstacles[i].getPosition().getRow() == e.getPos().getRow()) {
                    {
                        obstacles[i].randomPos();
                    }
                }
                obstacles[i].setGrid(grid);
            }
        }

        for (int i = 0; i < trashes.length; i++) {
            trashes[i] = TrashFactory.makeTrash(grid, obstacles, collisionDetector);
            for (Obstacle o : obstacles) {
                for (Eco e : ecos) {
                    while ((trashes[i].getPosition().getCol() == o.getPosition().getCol() && trashes[i].getPosition().getRow() == o.getPosition().getRow())
                            || (trashes[i].getPosition().getCol() == e.getPos().getCol() && trashes[i].getPosition().getRow() == e.getPos().getRow())) {
                        trashes[i].randomPos();
                    }
                    trashes[i].setGrid(grid);
                }
            }
        }


        String[] playersPictures = {"resources/Players/Boy_40.png", "resources/Players/Cat_40.png", "resources/Players/Dog_40.png", "resources/Players/Female_Pig_40.png",
                "resources/Players/Girl_40.png", "resources/Players/Man_40.png", "resources/Players/Pig_40.png", "resources/Players/Pig_Hat_40.png"};

        int playerPicture = (int) (Math.random() * playersPictures.length);

        GridPosition gridPosition = grid.makeGridPosition(Main.COLS - 1, Main.ROWS - 5, playersPictures[playerPicture]);
        this.player = new Player(grid, gridPosition, ecos);


        collisionDetector = new CollisionDetector(obstacles, ecos, trashes, grid, this.player);

        this.player.setCollisionDetector(collisionDetector);

        play = true;

    }


    public void start() {

        sound.play(true);


        starterMenu.starterMenu();


        while (!play) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        reminder = new Reminder(1);

        boolean flag = true;
        while (flag) {

            for (Obstacle o : obstacles) {
                if (o instanceof Movable) {
                    o.move();
                    if (collisionDetector.detectPlayer(o.getPosition(), o.getDirection())) {
                        player.setRandomWalk();
                    }
                }
            }

            for (Trash t : trashes) {
                if (!t.getPicked()) {
                    if (t instanceof Movable) {
                        if (collisionDetector.detectTrash(t.getPosition(), t.getDirection()) == null) {
                            t.move();
                        }
                    }
                }
                if (verifyPickedTrashes() && player.getTrashWeight() == 0) {
                    Text victory = new Text(580, 320, "Congratulations! You have a better world! \n Score:");
                    Integer scoreInteger = player.getScore();
                    String scoreString = scoreInteger.toString();
                    String[] scoreArray = scoreString.split("");
                    String[] scoreNumberArray = {"resources/Menu/0.png", "resources/Menu/1.png", "resources/Menu/2.png", "resources/Menu/3.png",
                            "resources/Menu/4.png", "resources/Menu/5.png", "resources/Menu/6.png",
                            "resources/Menu/7.png", "resources/Menu/8.png", "resources/Menu/9.png"};
                    int x = 550;
                    for (int i = 0; i < scoreArray.length; i++) {
                        x += 75;
                        Picture scorePicture;
                        switch (scoreArray[i]) {
                            case "0":
                                scorePicture = new Picture(x, 330, scoreNumberArray[0]);
                                scorePicture.draw();
                                break;
                            case "1":
                                scorePicture = new Picture(x, 330, scoreNumberArray[1]);
                                scorePicture.draw();
                                break;
                            case "2":
                                scorePicture = new Picture(x, 330, scoreNumberArray[2]);
                                scorePicture.draw();
                                break;
                            case "3":
                                scorePicture = new Picture(x, 330, scoreNumberArray[3]);
                                scorePicture.draw();
                                break;
                            case "4":
                                scorePicture = new Picture(x, 330, scoreNumberArray[4]);
                                scorePicture.draw();
                                break;
                            case "5":
                                scorePicture = new Picture(x, 330, scoreNumberArray[5]);
                                scorePicture.draw();
                                break;
                            case "6":
                                scorePicture = new Picture(x, 330, scoreNumberArray[6]);
                                scorePicture.draw();
                                break;
                            case "7":
                                scorePicture = new Picture(x, 330, scoreNumberArray[7]);
                                scorePicture.draw();
                                break;
                            case "8":
                                scorePicture = new Picture(x, 330, scoreNumberArray[8]);
                                scorePicture.draw();
                                break;
                            case "9":
                                scorePicture = new Picture(x, 330, scoreNumberArray[9]);
                                scorePicture.draw();
                                break;

                        }
                    }
                    victory.draw();
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }

                    System.exit(0);
                }
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }


    public boolean verifyPickedTrashes() {
        for (Trash t : trashes) {
            if (t.getPicked() == false) {
                return false;
            }
        }
        return true;
    }


    public void keyboardInit() {

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



