package org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles;


// Land debris that will make you go slower by hurting your feet if you step on it.
// It will be invisible until you move through it.

import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacle;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

//TODO: Hide shell
//TODO: Player can colide with shell
//TODO: If player colide with shell, shell goes visible and player goes slower

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
