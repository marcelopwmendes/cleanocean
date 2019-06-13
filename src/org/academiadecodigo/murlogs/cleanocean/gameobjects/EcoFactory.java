package org.academiadecodigo.murlogs.cleanocean.gameobjects;

import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Trash;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.TrashType;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;

public class EcoFactory {

    private static int col = Main.COLS;
    private static int row = 0;
    private static int i = -1;

    private static String[] eco = {"ecoPaper40.png", "ecoMetal40.png", "ecoPlastic40.png", "ecoGlass40.png", "ecoOrganic40.png"};


    public static Eco makeEco(Grid grid) {
        col--;
        i++;
        return new Eco(grid.makeGridPosition(col, row, eco[i]), TrashType.values()[i]);
    }


}
