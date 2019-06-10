package org.academiadecodigo.murlogs.cleanocean.menus;

import org.academiadecodigo.murlogs.cleanocean.Game;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HelpMenu implements KeyboardHandler {


    private Picture background;
    private Picture reverseMenuSelector;

    private Picture helpDescription1;
    private Picture helpDescription2;
    private Picture helpDescription3;
    private Picture helpDescription4;
    private Picture helpDescription5;
    private Picture helpDescription6;
    private Picture helpDescription7;
    private Picture helpDescription8;
    private Picture helpDescription9;


    SimpleGfxGrid gfxGrid;

    private Grid grid;
    private Game game;

    Keyboard keyboard = new Keyboard(this);
    KeyboardEvent left;
    KeyboardEvent right;
    KeyboardEvent select;

    public HelpMenu(Game game) {
        this.game = game;
    }

    public void helperMenu() {


        keyboardInit();
        // help menu

        SimpleGfxGrid gfxGrid = null;
        background = new Picture(gfxGrid.getPADDING(), gfxGrid.getPADDING(), "menu background.png");
        background.draw();

        helpDescription1 = new Picture(250, 520, "helpDescription1.png");
        helpDescription1.draw();

        helpDescription2 = new Picture(807, 520, "helpDescription2.png");
        helpDescription2.draw();

        helpDescription3 = new Picture(317, 228, "helpDescription3.png");
        helpDescription3.draw();

        helpDescription4 = new Picture(480, 520, "helpDescription6.png");
        helpDescription4.draw();

        helpDescription5 = new Picture(480, 520, "helpDescription5.png");
        helpDescription5.draw();

        helpDescription6 = new Picture(480, 520, "helpDescription6.png");
        helpDescription6.draw();

        helpDescription7 = new Picture(480, 520, "helpDescription7.png");
        helpDescription7.draw();

        helpDescription8 = new Picture(480, 520, "helpDescription8.png");
        helpDescription8.draw();

        helpDescription9 = new Picture(480, 520, "helpDescription9.png");
        helpDescription9.draw();

        reverseMenuSelector = new Picture(677, 520, "menu selector reversed.png");

    }


    public void keyboardInit() {

        // Select right or left to choose play or help in the menu
        left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);



    }

    Picture current;

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        System.out.println("Testing...");

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:

                break;
            case KeyboardEvent.KEY_D:

                break;
            case KeyboardEvent.KEY_SPACE:

                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
