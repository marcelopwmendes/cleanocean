package org.academiadecodigo.murlogs.cleanocean.grid;

import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    private static final int CELLSIZE = 16;
    private int cols;
    private int rows;
    //private Rectangle rectangle;
    private Picture backgroundSand;


    public SimpleGfxGrid(int cols, int rows, String s) {
        this.cols = cols;
        this.rows = rows;
        //this.rectangle = new Rectangle(PADDING, PADDING, CELLSIZE * cols, CELLSIZE * rows);
        this.backgroundSand = new Picture(PADDING, PADDING, s);

    }

    @Override
    public void init() {
        //rectangle.draw();
        backgroundSand.draw();
    }

    @Override
    public void setBackgroundSand(String s) {
        backgroundSand.load(s);
        backgroundSand.draw();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth() {
        return getCols() * CELLSIZE;
    }

    public int getHeight() {
        return getRows() * CELLSIZE;
    }

    public int getX() {
        return backgroundSand.getX();
    }

    public int getY() {
        return backgroundSand.getY();
    }

    public int getCellSize() {
        return CELLSIZE;
    }

    @Override
    public GridPosition makeGridPosition() {
        return new SimpleGfxPosition(this);
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxPosition(col, row, this);
    }

    public int rowToY(int row) {
        return PADDING + row * CELLSIZE;
    }

    public int columnToX(int column) {
        return PADDING + column * CELLSIZE;
    }

    public static int getPADDING() {
        return PADDING;
    }
}
