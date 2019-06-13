package org.academiadecodigo.murlogs.cleanocean.gameobjects;


import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Trash;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

//TESTE PARA VER SE O GIT DEIXA O DANILO BRINCAR
public class Player implements KeyboardHandler {

    private static final int CAPACITY = 25;
    private int[] trash;
    private int trashWeight;
    private int score;
    private boolean inBeach;
    private Keyboard keyboard;
    private Eco[] ecos;
    private GridPosition position;
    protected GridDirection currentDirection;
    private Grid grid;
    //private String pic = "girl_front_stopped.png";

    private CollisionDetector collisionDetector;


    public Player(GridPosition pos, Eco[] ecos) {
        trash = new int[5];
        trashWeight = 0;
        score = 0;
        inBeach = true;
        position = pos;
        this.ecos = ecos;
        pos.setColor(GridColor.GREEN);
        keyboard = new Keyboard(this);
        init();
    }

    public void init() {
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


  /*
       // apanhar o lixo carregando no espaço - por exemplo!
       // ou então não apanhar com o espaço, apanhar automaticamente
       // e caso tenha a mochila cheia e apanhe mais algum o mochila rompe
       // e cai o lixo OU ENTÃO o lixo serve como obstáculo até que esvazie a mochila

        KeyboardEvent pickTrash = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_SPACE);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
*/
        keyboard.addEventListener(up);
        keyboard.addEventListener(left);
        keyboard.addEventListener(down);
        keyboard.addEventListener(right);

    }

    public void move(GridDirection direction) {


        currentDirection = direction;


        if (collisionDetector.detectObstacle(position, direction)) {
            return;
        }

        Trash trash = collisionDetector.detectTrash(position, direction);

        if (trash != null && !trash.getPicked()) {
            pickTrash(trash);
        }


        position.moveInDirection(direction, 1);


        // empty bagTrash
        if (getPosition().getRow() == 1 && getPosition().getCol() > 27) {
            int points = 0;
            for (int i = 0; i < ecos.length; i++) {
                points += ecos[i].recycleTrash(getTrash()[i]);
            }
            clearTrash();
            setScore(points);
            System.out.println(getScore());
        }
    }

    public void pickTrash(Trash trash) {
        if (CAPACITY <= (trash.getTrashType().getWeight() + trashWeight)) {
            System.out.println("FULL");
            return;
        }
        trash.setPicked();
        addTrash(trash.getTrashType());
        System.out.println(trashWeight);
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                //up
                currentDirection = GridDirection.UP;
                break;
            case KeyboardEvent.KEY_A:
                //left
                currentDirection = GridDirection.LEFT;
                break;
            case KeyboardEvent.KEY_S:
                //down
                currentDirection = GridDirection.DOWN;
                break;
            case KeyboardEvent.KEY_D:
                //right
                currentDirection = GridDirection.RIGHT;
                break;
        }
        move(currentDirection);
    }

    public void clearTrash() {
        trashWeight = 0;
        for (int i = 0; i < trash.length; i++) {
            trash[i] = 0;
        }
    }

    public int[] recycle() {
        return trash;
    }

    public void addTrash(TrashType trashType) {

        switch (trashType) {
            case PAPER:
                trash[0]++;
                trashWeight += trashType.getWeight();
                System.out.println(trash[0]);
                break;

            case METAL:
                trash[1]++;
                trashWeight += trashType.getWeight();
                System.out.println(trash[1]);
                break;

            case PLASTIC:
                trash[2]++;
                trashWeight += trashType.getWeight();
                System.out.println(trash[2]);
                break;

            case GLASS:
                trash[3]++;
                trashWeight += trashType.getWeight();
                System.out.println(trash[3]);
                break;

            case ORGANIC:
                trash[4]++;
                trashWeight += trashType.getWeight();
                System.out.println(trash[4]);
                break;
        }

    }

    public int[] getTrash() {
        return trash;
    }

    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = this.score + score;
    }


    public boolean isInBeach() {
        return inBeach;
    }

    public void setInBeach(boolean inBeach) {
        this.inBeach = inBeach;
    }

    public GridPosition getPosition() {
        return position;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }


}
