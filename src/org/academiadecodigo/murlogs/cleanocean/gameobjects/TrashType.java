package org.academiadecodigo.murlogs.cleanocean.gameobjects;

public enum TrashType {
    PAPER(1, 10),
    METAL(5, 30),
    PLASTIC(3, 50),
    GLASS(5, 30),
    ORGANIC(2, 1);

    private int weight;
    private int score;

    TrashType(int weight, int score) {
        this.weight = weight;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getWeight() {
        return weight;
    }
}
