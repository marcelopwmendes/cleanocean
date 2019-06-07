package org.academiadecodigo.murlogs.cleanocean.grid;

import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    private static final int CELLSIZE = 20;
    private int cols;
    private int rows;
    private Rectangle rectangle;


    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.rectangle = new Rectangle(PADDING, PADDING, CELLSIZE * cols, CELLSIZE * rows);
    }

    @Override
    public void init() {
        rectangle.draw();
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
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
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

    public int columnToX(int column){
        return PADDING + column * CELLSIZE;
    }
}
