package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.grid.GridType;
import org.academiadecodigo.murlogs.cleanocean.grid.SimpleGfxGrid;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(GridType.SIMPLE_GFX, 80, 25, 200);

        game.start();


    }


}
