package org.academiadecodigo.murlogs.cleanocean.grid;

import org.academiadecodigo.murlogs.cleanocean.grid.position.AbstractGridPosition;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxPosition extends AbstractGridPosition {

   // private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;
    private Picture picture;

    public SimpleGfxPosition(SimpleGfxGrid grid, String picture) {
        this((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid, picture);
    }

    public SimpleGfxPosition(int col, int row, SimpleGfxGrid grid, String pictureName) {
        super(col, row, grid);
        simpleGfxGrid = grid;
       // rectangle = new Rectangle(simpleGfxGrid.columnToX(col), simpleGfxGrid.rowToY(row), simpleGfxGrid.getCellSize(), simpleGfxGrid.getCellSize());
        picture = new Picture(simpleGfxGrid.columnToX(col), simpleGfxGrid.rowToY(row), pictureName);
        show();
    }

    @Override
    public void show() {
       // rectangle.fill();
        picture.draw();
    }

    @Override
    public void hide() {
        //rectangle.delete();
        picture.delete();
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        super.moveInDirection(direction, distance);
        int x = simpleGfxGrid.columnToX(getCol()) - picture.getX();
        int y = simpleGfxGrid.rowToY(getRow()) - picture.getY();
        picture.translate(x,y);
    }

    @Override
    public void setColor(GridColor color) {
        super.setColor(color);
        //picture.setColor(SimpleGfxColorMapper.getColor(color));
    }

    public void setPicture() {
        this.picture = picture;
    }
}
