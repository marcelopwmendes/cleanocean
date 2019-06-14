package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.murlogs.cleanocean.gameobjects.Eco;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles.Shell;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Obstacles.Obstacle;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.Player;
import org.academiadecodigo.murlogs.cleanocean.gameobjects.trash.Trash;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.GridDirection;
import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;

public class CollisionDetector {

    private Grid grid;

    private Obstacle[] obstacles;
    private Eco[] ecos;
    private Trash[] trashes;
    private Player player;


    /**
     * Initializes a newly created Collision Detector with respective parameters
     *
     * @param obstacles
     * @param ecos
     * @param trashes
     * @param grid
     * @param player
     */
    public CollisionDetector(Obstacle[] obstacles, Eco[] ecos, Trash[] trashes, Grid grid, Player player) {
        this.obstacles = obstacles;
        this.ecos = ecos;
        this.grid = grid;
        this.trashes = trashes;
        this.player = player;
    }


    /**
     * Compare the position of parameters with all of Obstacles
     *
     * @param position
     * @param direction
     * @return true if position of parameters is equals position of any Obstacle. Otherwise return false.
     */
    public boolean detectObstacle(GridPosition position, GridDirection direction) {

        int[] nextPosition = getNextPosition(position, direction);

        int nextCol = nextPosition[0];
        int nextRow = nextPosition[1];

        for (Obstacle o : obstacles) {

            if ((o.getPosition().getCol() == nextCol) && (o.getPosition().getRow() == nextRow) && (!(o instanceof Shell))) {
                return true;
            }
            if (o instanceof Shell && (o.getPosition().getCol() == nextCol) && (o.getPosition().getRow() == nextRow)) {
                Shell shell = (Shell) o;
                shell.setVisible(true);
                player.setSlow();
                player.setScore(-10);
            }
        }

        // Detect Eco
        if (player.isInBeach()) {
            if ((nextCol > Main.COLS - 6) && (nextRow == 0)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compare the position of parameters with all Trashes
     *
     * @param position
     * @param direction
     * @return a Trash if the position equals to position of any Trash. Otherwise returns null
     */
    public Trash detectTrash(GridPosition position, GridDirection direction) {

        int[] nextPosition = getNextPosition(position, direction);

        int nextCol = nextPosition[0];
        int nextRow = nextPosition[1];

        for (Trash t : trashes) {
            if ((t.getPosition().getCol() == nextCol) && (t.getPosition().getRow() == nextRow)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Compare the position of parameters with Player's position
     *
     * @param position
     * @param direction
     * @return true if position equals position of the Player
     */
    public boolean detectPlayer(GridPosition position, GridDirection direction) {
        int[] nextPosition = getNextPosition(position, direction);
        int nextCol = nextPosition[0];
        int nextRow = nextPosition[1];

        return ((player.getPosition().getCol() == nextCol) && (player.getPosition().getRow() == nextRow));
    }

    /**
     * Get the next position of an Object according with its direction
     *
     * @param position
     * @param direction
     * @return an Array of ints with the next position [col][row]
     */
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

    /**
     * Move an Object up
     *
     * @param position
     * @return the next position
     */
    private int[] moveUp(GridPosition position) {
        int[] nextPosition = new int[2];
        nextPosition[0] = position.getCol();
        nextPosition[1] = position.getRow() - 1;
        return nextPosition;
    }

    /**
     * Move an Object down
     *
     * @param position
     * @return the next position
     */
    private int[] moveDown(GridPosition position) {
        int[] nextPosition = new int[2];
        nextPosition[0] = position.getCol();
        nextPosition[1] = position.getRow() + 1;
        return nextPosition;
    }

    /**
     * Move an Object to the left
     *
     * @param position
     * @return the next position
     */
    private int[] moveLeft(GridPosition position) {
        int[] nextPosition = new int[2];
        nextPosition[0] = position.getCol() - 1;
        nextPosition[1] = position.getRow();
        return nextPosition;
    }

    /**
     * Move an Object to the right
     * @param position
     * @return the next position
     */
    private int[] moveRight(GridPosition position) {
        int[] nextPosition = new int[2];
        nextPosition[0] = position.getCol() + 1;
        nextPosition[1] = position.getRow();
        return nextPosition;
    }

}
