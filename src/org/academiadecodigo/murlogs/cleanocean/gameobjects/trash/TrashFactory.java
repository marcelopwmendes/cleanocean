package org.academiadecodigo.murlogs.cleanocean.gameobjects.trash;

import org.academiadecodigo.murlogs.cleanocean.CollisionDetector;
import org.academiadecodigo.murlogs.cleanocean.Main;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles.Obstacle;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class TrashFactory {

    public static Trash makeTrash(Grid grid, Obstacle[] obstacles, CollisionDetector collisionDetector) {

        GridPosition gridPosition;
        int col;
        int row;
        int type;
        int pic;
        String[] paperT = {"paperMagazine40.png", "paperTrash40.png"};
        String[] plasticT = {"plasticSac40.png", "plasticBottle40.png"};
        String[] metalT = {"metal40.png", "metalCan40.png"};
        String[] glassT = {"glassBottle40.png", "glassSecBottle40.png"};
        String[] organicT = {"organicBanana40.png", "organicCorn40.png"};


        type = (int) (Math.random() * TrashType.values().length);
        TrashType trashType = TrashType.values()[type];

        /* Put trash in delimited space and put it in
        another place, if there is an obstacle there */
        row = (int) (Math.random() * Main.ROWS);
        col = (int) (Math.random() * Main.COLS);
        while ( ((col > Main.COLS - 6) && (row == 0)) || (row > Main.ROWS - 5)) {

            col = (int) (Math.random() * Main.COLS);
            row = (int) (Math.random() * Main.ROWS);


            if ((col <= Main.COLS - 6) && (row > 1) || row <= Main.ROWS - 5) {

                for (int i = 0; i < obstacles.length; i++) {

                    while ((col == obstacles[i].getPosition().getCol()) &&
                            (row == obstacles[i].getPosition().getRow())) {
                        row = (int) (Math.random() * Main.ROWS);
                        col = (int) (Math.random() * Main.COLS);

                    }
                }
            }
        }

        //gridPosition = grid.makeGridPosition(col, row); collisionDetector

        Trash trash = null;

        switch (trashType) {
            case PAPER:
                pic = (int) (Math.random() * paperT.length);
                trash = new Paper(grid.makeGridPosition(col, row, paperT[pic]));
                System.out.println("paper initial location " + col + " " + row);
                break;
            case METAL:
                pic = (int) (Math.random() * metalT.length);
                trash = new Metal(grid.makeGridPosition(col, row, metalT[pic]));
                System.out.println("metal initial location " + col + " " + row);
                break;
            case PLASTIC:
                pic = (int) (Math.random() * plasticT.length);
                trash = new Plastic(grid.makeGridPosition(col, row, plasticT[pic]));
                System.out.println("plastic initial location " + col + " " + row);
                break;
            case GLASS:
                pic = (int) (Math.random() * glassT.length);
                trash = new Glass(grid.makeGridPosition(col, row, glassT[pic]));
                System.out.println("glass initial location " + col + " " + row);
                break;
            case ORGANIC:
                pic = (int) (Math.random() * organicT.length);
                trash = new Organic(grid.makeGridPosition(col, row, organicT[pic]));
                System.out.println("organic initial location " + col + " " + row);
                break;
        }
        return trash;
    }

}
