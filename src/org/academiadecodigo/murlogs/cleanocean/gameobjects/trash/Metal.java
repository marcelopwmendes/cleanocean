package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.Movable;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class Metal extends Trash implements Movable {


    public Metal(GridPosition gridPosition)  {

        super(gridPosition, TrashType.METAL);
    }

    @Override
    public void move() {

    }
}
