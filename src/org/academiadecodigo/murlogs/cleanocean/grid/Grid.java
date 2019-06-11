package org.academiadecodigo.murlogs.cleanocean.grid;

import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public interface Grid {


    void init();

    int getCols();

    int getRows();

    GridPosition makeGridPosition();

    GridPosition makeGridPosition(int col, int row, String picture);









}
