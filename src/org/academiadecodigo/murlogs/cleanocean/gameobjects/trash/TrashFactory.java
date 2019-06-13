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
        String[] paperT = {"Trashes/paperMagazine20.png", "Trashes/paperTrash40.png"};
        String[] plasticT = {"Trashes/plasticSac40.png", "Trashes/plasticBottle40.png"};
        String[] metalT = {"Trashes/metal40.png", "Trashes/metalCan40.png"};
        String[] glassT = {"Trashes/glassBottle40.png", "Trashes/glassSecBottle40.png"};
        String[] organicT = {"Trashes/organicBanana40.png", "Trashes/organicCorn40.png"};


        type = (int) (Math.random() * TrashType.values().length);
        TrashType trashType = TrashType.values()[type];

        /* Put trash in delimited space and put it in
        another place, if there is an obstacle there */

        boolean correctPosition = true;

        row = (int) (Math.random() * Main.ROWS);
        col = (int) (Math.random() * Main.COLS);

        while ( correctPosition && ((col > Main.COLS - 6) && (row == 0)) || (row > Main.ROWS - 5)) {

            correctPosition = false;

            col = (int) (Math.random() * Main.COLS);
            row = (int) (Math.random() * Main.ROWS);


            for (int i = 0; i < obstacles.length; i++) {
                if ((col == obstacles[i].getPosition().getCol()) && (row == obstacles[i].getPosition().getRow())) {
                    break;
                }
                correctPosition = true;
            }

        }

            //gridPosition = grid.makeGridPosition(col, row); collisionDetector

            Trash trash = null;

            switch (trashType) {
                case PAPER:
                    pic = (int) (Math.random() * paperT.length);
                    trash = new Paper(grid.makeGridPosition(col, row, paperT[pic]));
                    break;
                case METAL:
                    pic = (int) (Math.random() * metalT.length);
                    trash = new Metal(grid.makeGridPosition(col, row, metalT[pic]));
                    break;
                case PLASTIC:
                    pic = (int) (Math.random() * plasticT.length);
                    trash = new Plastic(grid.makeGridPosition(col, row, plasticT[pic]));
                    break;
                case GLASS:
                    pic = (int) (Math.random() * glassT.length);
                    trash = new Glass(grid.makeGridPosition(col, row, glassT[pic]));
                    break;
                case ORGANIC:
                    pic = (int) (Math.random() * organicT.length);
                    trash = new Organic(grid.makeGridPosition(col, row, organicT[pic]));
                    break;
            }
            return trash;
        }

    }
