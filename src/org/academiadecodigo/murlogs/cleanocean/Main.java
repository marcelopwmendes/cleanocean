package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
import org.academiadecodigo.murlogs.cleanocean.grid.SimpleGfxGrid;

public class Main {

    public static final int COLS = 80;
    public static final int ROWS = 40;
    public static final int DELAY = 200;


    public static void main(String[] args) {

<<<<<<< HEAD
        Game game = new Game(GridType.SIMPLE_GFX, COLS, ROWS, DELAY);
=======
        Game game = new Game(GridType.SIMPLE_GFX, 80, 40, 200);
>>>>>>> 7c1368f1ddad1c92fdc7eb2f3c1bf1cfd8961eaf

        game.start();


    }


}
