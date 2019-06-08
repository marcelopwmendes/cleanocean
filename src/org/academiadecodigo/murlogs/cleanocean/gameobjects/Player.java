package org.academiadecodigo.murlogs.cleanocean.gameobjects;


import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Player implements KeyboardHandler {

    private static final int CAPACITY = 25;
    private int[] trash;
    private int trashCounter;
    private int score;
    private boolean inBeach;
    private Keyboard keyboard;

    private GridPosition position;
    protected GridDirection currentDirection;

    //adicionado sem o Nuno - CHECK THIS PLS
    private Grid grid;

    private CollisionDetector collisionDetector;


    public Player(GridPosition pos) {
        trash = new int[5];
        trashCounter = 0;
        score = 0;
        inBeach = true;
        position = pos;
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
        this.currentDirection = direction;

        //se puder mexer-se, mexe-se - confirmar colisão com obstáculos/contentores

/*    if (isHittingWall() || collisionDetector.detectsObstacle(position, direction)) {
        return;
    }
*/

/*        if (isHittingWall(direction)) {
            return;
        }
*/


    if (collisionDetector.detectObstacle(position, direction)) {
        return;
    }


        position.moveInDirection(direction, 1);
    }





    public boolean isHittingWall(GridDirection currentDirection) {

        switch (currentDirection) {
            case LEFT:
                if (position.getCol() == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (position.getCol() == grid.getCols() - 1) {
                    return true;
                }
                break;
            case UP:
                if (position.getRow() == 0) {
                    return true;
                }
                break;
            case DOWN:
                if (position.getRow() == grid.getRows() - 1) {
                    return true;
                }
        }

        return false;

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

    }


    public void addTrash(TrashType trashType) {

    }


    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
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


    //adicionado sem o Nuno - CHECK THIS PLS
    public void setGrid(Grid grid) {
        this.grid = grid;
    }


}
