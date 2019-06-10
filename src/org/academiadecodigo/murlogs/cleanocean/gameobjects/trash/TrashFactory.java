package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacle;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class TrashFactory {

    public static Trash makeTrash(Grid grid, Obstacle[] obstacles, CollisionDetector collisionDetector) {

        GridPosition gridPosition;
        int col;
        int row;
        int random;

        random = (int) (Math.random() * TrashType.values().length);
        TrashType trashType = TrashType.values()[random];

        row = (int) (Math.random() * Main.ROWS);
        col = (int) (Math.random() * Main.COLS);
        while ( (col == Main.COLS - 1) && ( (row == Main.ROWS - 1) || (row <= 4) ) ) {
            col = (int) (Math.random() * Main.COLS);
            row = (int) (Math.random() * Main.ROWS);
        }

        for (int i = 0; i < obstacles.length; i++) {
            while ((col == obstacles[i].getPosition().getCol()) &&
                    (row == obstacles[i].getPosition().getRow())) {
                row = (int) (Math.random() * Main.ROWS);
                col = (int) (Math.random() * Main.COLS);
            }
        }

        //gridPosition = grid.makeGridPosition(col, row); collisionDetector

        Trash trash = null;

        switch (trashType) {
            case PAPER:
                trash = new Paper(grid.makeGridPosition(col, row));
                break;
            case METAL:
                trash = new Metal(grid.makeGridPosition(col, row));
                break;
            case PLASTIC:
                trash = new Plastic(grid.makeGridPosition(col, row));
                break;
            case GLASS:
                trash = new Glass(grid.makeGridPosition(col, row));
                break;
            case ORGANIC:
                trash = new Organic(grid.makeGridPosition(col, row));
                break;
        }
        return trash;
    }

}
