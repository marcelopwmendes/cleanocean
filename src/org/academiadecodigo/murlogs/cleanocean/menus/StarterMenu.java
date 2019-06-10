package org.academiadecodigo.murlogs.cleanocean.menus;

import org.academiadecodigo.murlogs.cleanocean.Game;
import org.academiadecodigo.murlogs.cleanocean.grid.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StarterMenu implements KeyboardHandler {

    Picture play;
    Picture help;
    Picture gameName;
    Picture menuSelector;
    Picture reverseMenuSelector;
    Picture background;

    private Game game;

    Keyboard keyboard;
    KeyboardEvent left;
    KeyboardEvent right;
    KeyboardEvent select;

    public void starterMenu() {

        keyboardInit();
        //Initial menu
        SimpleGfxGrid gfxGrid = null;
        background = new Picture(gfxGrid.getPADDING(), gfxGrid.getPADDING(), "menu background.png");
        background.draw();

        play = new Picture(250, 520, "play.png");
        play.draw();

        help = new Picture(807, 520, "help.png");
        help.draw();

        gameName = new Picture(317, 228, "game name.png");
        gameName.draw();

        menuSelector = new Picture(480, 520, "menu selector.png");
        menuSelector.draw();

        reverseMenuSelector = new Picture(677, 520, "menu selector reversed.png");

    }



    public void keyboardInit() {

        // Select right or left to choose play or help in the menu
        left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        select = new KeyboardEvent();
        select.setKey(KeyboardEvent.KEY_SPACE);
        select.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(select);


    }

    Picture current;
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        System.out.println("sadsdasd");




        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                reverseMenuSelector.delete();
                menuSelector.draw();
                current = play;
                break;
            case KeyboardEvent.KEY_D:
                menuSelector.delete();
                reverseMenuSelector.draw();
                current = help;
                break;
            case KeyboardEvent.KEY_SPACE:
                if (current == play) {
                    game.init();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
