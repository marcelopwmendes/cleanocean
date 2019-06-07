package org.academiadecodigo.murlogs.cleanocean.grid.position;

import org.academiadecodigo.murlogs.cleanocean.grid.GridColor;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;

public interface GridPosition {

    int getCol();

    int getRow();

    void setPos(int col, int row);

    GridColor getColor();

    void setColor(GridColor color);

    void show();

    void hide();

    void moveInDirection(GridDirection direction, int distance);

    boolean equals(GridPosition position);


}
