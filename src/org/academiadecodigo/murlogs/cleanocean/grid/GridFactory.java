package org.academiadecodigo.murlogs.cleanocean.grid;

public class GridFactory {

    public static Grid makeGrid(GridType gridType, int cols, int rows, String s) {
        return new SimpleGfxGrid(cols, rows,s);
    }

}
