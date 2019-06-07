package org.academiadecodigo.murlogs.cleanocean.gameobjects.Trash;

import org.academiadecodigo.murlogs.cleanocean.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Glass extends Trash {

    private String[] glassPics = {"organicBanana.png", "organicCorn.png"};
    private GridPosition gridPosition;
    private TrashType trashType;
    private Picture picture;
    private int weight;
    private int score;
    private int height;
    private int width;


    public Glass(GridPosition gridPosition, TrashType trashType, int weight, int score) {
        super(gridPosition, trashType);
        this.weight = weight;
        this.score = score;

        int random = (int) (Math.random() * glassPics.length);
        picture = new Picture(30, 30, glassPics[random]);
        picture.draw();


    }


    public int getScore() {
        return score;
    }

    public int getWeight() {
        return weight;
    }

}

