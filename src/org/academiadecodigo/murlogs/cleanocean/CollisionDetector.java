package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacle;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;


public class CollisionDetector {

    private Grid grid;

    private Obstacle[] obstacles;


    public CollisionDetector(Obstacle[] obstacles, Grid grid) {
        this.obstacles = obstacles;
        this.grid = grid;
    }



/*    public boolean detectObstacle(GridPosition position, GridDirection direction) {

        GridPosition nextPosition = getNextPosition(position, direction);

        for (Obstacle o : obstacles) {
            if (o.getPosition().equals(nextPosition)) {
                return true;
            }
        }
        return false;
    }

*/




    public boolean detectObstacle(GridPosition position, GridDirection direction) {

        int[] nextPosition = getNextPosition(position, direction);

        int nextCol = nextPosition[0];
        int nextRow = nextPosition[1];

        for (Obstacle o : obstacles) {
            if ( (o.getPosition().getCol() == nextCol) && (o.getPosition().getRow() == nextRow) ) {
                return true;
            }
        }
        return false;
    }


    public int[] getNextPosition(GridPosition position, GridDirection direction) {

        int[] nextPosition = new int[2];

        switch (direction) {
            case UP:
                nextPosition = moveUp(position);
                break;
            case DOWN:
                nextPosition = moveDown(position);
                break;
            case LEFT:
                nextPosition = moveLeft(position);
                break;
            case RIGHT:
                nextPosition = moveRight(position);
                break;
        }
        return nextPosition;
    }



    private int[] moveUp(GridPosition position) {
        int[] nextPosition = new int[2];
        nextPosition[0] = position.getCol();
        nextPosition[1] = position.getRow() - 1;
        return nextPosition;
    }

    private int[] moveDown(GridPosition position) {
        int[] nextPosition = new int[2];
        nextPosition[0] = position.getCol();
        nextPosition[1] = position.getRow() + 1;
        return nextPosition;
    }

    private int[] moveLeft(GridPosition position) {
        int[] nextPosition = new int[2];
        nextPosition[0] = position.getCol() - 1;
        nextPosition[1] = position.getRow();
        return nextPosition;
    }

    private int[] moveRight(GridPosition position) {
        int[] nextPosition = new int[2];
        nextPosition[0] = position.getCol() + 1;
        nextPosition[1] = position.getRow();
        return nextPosition;
    }

}
