package org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles;


// Land debris that will make you go slower by hurting your feet if you step on it.
// It will be invisible until you move through it.

import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;



public class Shell extends Obstacle {

    private GridPosition position;

    public Shell(GridPosition position) {
        super(position);
        super.getPosition().hide();
    }

    public void setVisible(boolean b) {
        if (b) {
            super.getPosition().show();
            return;
        }
        super.getPosition().hide();
    }

}
