package org.academiadecodigo.murlogs.cleanocean.menus;

import org.academiadecodigo.murlogs.cleanocean.Game;
import org.academiadecodigo.murlogs.cleanocean.grid.Grid;
import org.academiadecodigo.murlogs.cleanocean.grid.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StarterMenu implements KeyboardHandler {

    Picture play;
    Picture playRed;
    Picture help;
    Picture helpRed;
    Picture gameName;
    Picture menuSelector;
    Picture reverseMenuSelector;
    Picture background;

    SimpleGfxGrid gfxGrid;

    private Grid grid;
    private Game game;
    private HelpMenu helpMenu = new HelpMenu(game);

    Keyboard keyboard = new Keyboard(this);
    KeyboardEvent pressA;
    KeyboardEvent pressD;
    KeyboardEvent pressSpace;

    KeyboardEvent releaseSpace;

    public StarterMenu(Game game) {
        this.game = game;
    }

    public void starterMenu() {

        keyboardInit();
        //Initial menu
        //Grid gfxGrid = grid;
        background = new Picture(SimpleGfxGrid.PADDING, SimpleGfxGrid.PADDING, "menu background.png");
        background.draw();

        play = new Picture(250, 520, "play.png");
        play.draw();

        playRed = new Picture(248, 518, "playRed.png");

        help = new Picture(807, 520, "help.png");
        help.draw();

        helpRed = new Picture(805, 518, "helpRed.png");

        gameName = new Picture(317, 228, "game name.png");
        gameName.draw();

        menuSelector = new Picture(480, 520, "menu selector.png");
        menuSelector.draw();

        reverseMenuSelector = new Picture(677, 520, "menu selector reversed.png");

    }


    public void keyboardInit() {

        // Select pressD or pressA to choose play or help in the menu
        pressA = new KeyboardEvent();
        pressA.setKey(KeyboardEvent.KEY_A);
        pressA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pressD = new KeyboardEvent();
        pressD.setKey(KeyboardEvent.KEY_D);
        pressD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pressSpace = new KeyboardEvent();
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        releaseSpace = new KeyboardEvent();
        releaseSpace.setKey(KeyboardEvent.KEY_SPACE);
        releaseSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(pressA);
        keyboard.addEventListener(pressD);
        keyboard.addEventListener(pressSpace);

        keyboard.addEventListener(releaseSpace);


    }


    Picture current;
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
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

                if (current == play || current == null) {
                    play.delete();
                    playRed.draw();
                }
                if (current == help) {
                    help.delete();
                    helpRed.draw();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                if (current == play || current == null) {

                    keyboard.removeEventListener(pressA);
                    keyboard.removeEventListener(pressD);
                    keyboard.removeEventListener(pressSpace);
                    keyboard.removeEventListener(releaseSpace);
                    game.init();
                    break;
                }
                if (current == help) {
                    helpMenu.helperMenu(this);
                    keyboard.removeEventListener(pressA);
                    keyboard.removeEventListener(pressD);
                    keyboard.removeEventListener(pressSpace);
                    keyboard.removeEventListener(releaseSpace);
                }
                break;
        }

    }

    public void setCurrent(Picture current) {
        this.current = current;
    }

    public Picture getPlay() {
        return play;
    }
}
