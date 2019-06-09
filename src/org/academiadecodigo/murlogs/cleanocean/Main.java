package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
import org.academiadecodigo.murlogs.cleanocean.grid.SimpleGfxGrid;

public class Main {

    public static final int COLS = 80;
    public static final int ROWS = 45;
    public static final int DELAY = 200;


    public static void main(String[] args) {

        Game game = new Game(GridType.SIMPLE_GFX, COLS, ROWS, DELAY);

        game.start();


    }


}
