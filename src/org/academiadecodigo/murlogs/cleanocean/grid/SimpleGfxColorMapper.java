package org.academiadecodigo.murlogs.cleanocean.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class SimpleGfxColorMapper {

    private static final Color colors[] = {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.BLUE,
            Color.MAGENTA,
            Color.WHITE
    };

    public static Color getColor(GridColor color) {

        Color sGfxColor = null;

        switch (color) {
            case RED:
                sGfxColor = colors[0];
                break;
            case ORANGE:
                sGfxColor = colors[1];
                break;
            case YELLOW:
                sGfxColor = colors[2];
                break;
            case GREEN:
                sGfxColor = colors[3];
                break;
            case BLUE:
                sGfxColor = colors[4];
                break;
            case MAGENTA:
                sGfxColor = colors[5];
                break;
            case NOCOLOR:
                sGfxColor = colors[6];
                break;

        }
        return sGfxColor;
    }
}
