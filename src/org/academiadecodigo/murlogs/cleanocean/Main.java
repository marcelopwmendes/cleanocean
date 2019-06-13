package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
import org.academiadecodigo.murlogs.cleanocean.grid.SimpleGfxGrid;

public class Main {

    public static final int COLS = 32;
    public static final int ROWS = 18;
    public static final int DELAY = 400;


    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(GridType.SIMPLE_GFX, COLS, ROWS, DELAY);

        game.start();


    }


}
