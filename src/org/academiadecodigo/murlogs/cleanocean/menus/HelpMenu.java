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


    //FALTA meter um boneco a olhar para cima/baixo/esq/dir consoante as teclas e mudar o texto da descrição

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
    private Picture aKey;
    private Picture aKeyRed;
    private Picture aExplained;
    private Picture dKey;
    private Picture dKeyRed;
    private Picture dExplained;
    private Picture sKey;
    private Picture sKeyRed;
    private Picture sExplained;
    private Picture wKey;
    private Picture wKeyRed;
    private Picture wExplained;
    private Picture qToLeave;
    private Picture press;


    private Grid grid;
    private Game game;
    private StarterMenu starterMenu;

    Keyboard keyboard = new Keyboard(this);
    KeyboardEvent pressW;
    KeyboardEvent pressA;
    KeyboardEvent pressS;
    KeyboardEvent pressD;
    KeyboardEvent pressQ;

    KeyboardEvent releaseW;
    KeyboardEvent releaseA;
    KeyboardEvent releaseS;
    KeyboardEvent releaseD;
    KeyboardEvent releaseQ;

    public HelpMenu(Game game) {
        this.game = game;
    }

    public void helperMenu(StarterMenu starterMenu) {
        this.starterMenu = starterMenu;

        keyboardInit();
        // help menu

        SimpleGfxGrid gfxGrid = null;
        background = new Picture(gfxGrid.getPADDING(), gfxGrid.getPADDING(), "resources/Menu/Menu_background.png");
        background.draw();

        helpDescription1 = new Picture(150, 50, "resources/Menu/helpDescription1.png");
        helpDescription1.draw();

        helpDescription2 = new Picture(175, 100, "resources/Menu/helpDescription2.png");
        helpDescription2.draw();

        helpDescription3 = new Picture(200, 150, "resources/Menu/helpDescription3.png");
        helpDescription3.draw();

        helpDescription4 = new Picture(150, 200, "resources/Menu/helpDescription4.png");
        helpDescription4.draw();

        helpDescription5 = new Picture(350, 250, "resources/Menu/helpDescription5.png");
        helpDescription5.draw();

        helpDescription6 = new Picture(550, 300, "resources/Menu/helpDescription6.png");
        helpDescription6.draw();

        helpDescription7 = new Picture(700, 350, "resources/Menu/helpDescription7.png");
        helpDescription7.draw();

        helpDescription8 = new Picture(250, 400, "resources/Menu/helpDescription8.png");
        helpDescription8.draw();

        helpDescription9 = new Picture(250, 450, "resources/Menu/helpDescription9.png");
        helpDescription9.draw();

        reverseMenuSelector = new Picture(677, 520, "resources/Menu/Menu_selector_reversed.png");

        press = new Picture(25, 575, "resources/Menu/Press_Button.png");
        press.draw();

        wKey = new Picture(225, 575, "resources/Menu/W_key_Blue.png");
        wKey.draw();
        wKeyRed = new Picture(225, 575, "resources/Menu/W_key_Red.png");

        aKey = new Picture(175, 625, "resources/Menu/A_key.png");
        aKey.draw();
        aKeyRed = new Picture(173, 623, "resources/Menu/A_key_to_turn_Red.png");

        sKey = new Picture(225, 625, "resources/Menu/S_key.png");
        sKey.draw();
        sKeyRed = new Picture(223, 623, "resources/Menu/S_key_Red.png");

        dKey = new Picture(275, 625, "resources/Menu/D_key.png");
        dKey.draw();
        dKeyRed = new Picture(273, 623, "resources/Menu/D_key_to_turn_Red.png");

        qToLeave = new Picture(980, 690, "resources/Menu/Q_key_to_leave.png");
        qToLeave.draw();


        wExplained = new Picture(525, 585, "resources/Menu/W_key_to_up.png");
        aExplained = new Picture(375, 625, "resources/Menu/A_key_to_left.png");
        dExplained = new Picture(650, 625, "resources/Menu/D_key_to_right.png");
        sExplained = new Picture(500, 650, "resources/Menu/S_key_to_down.png");
    }


    public void keyboardInit() {

        pressW = new KeyboardEvent();
        pressW.setKey(KeyboardEvent.KEY_W);
        pressW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pressA = new KeyboardEvent();
        pressA.setKey(KeyboardEvent.KEY_A);
        pressA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pressS = new KeyboardEvent();
        pressS.setKey(KeyboardEvent.KEY_S);
        pressS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pressD = new KeyboardEvent();
        pressD.setKey(KeyboardEvent.KEY_D);
        pressD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pressQ = new KeyboardEvent();
        pressQ.setKey(KeyboardEvent.KEY_Q);
        pressQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        releaseW = new KeyboardEvent();
        releaseW.setKey(KeyboardEvent.KEY_W);
        releaseW.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        releaseA = new KeyboardEvent();
        releaseA.setKey(KeyboardEvent.KEY_A);
        releaseA.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        releaseS = new KeyboardEvent();
        releaseS.setKey(KeyboardEvent.KEY_S);
        releaseS.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        releaseD = new KeyboardEvent();
        releaseD.setKey(KeyboardEvent.KEY_D);
        releaseD.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        releaseQ = new KeyboardEvent();
        releaseQ.setKey(KeyboardEvent.KEY_Q);
        releaseQ.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(pressW);
        keyboard.addEventListener(pressA);
        keyboard.addEventListener(pressS);
        keyboard.addEventListener(pressD);
        keyboard.addEventListener(pressQ);

        keyboard.addEventListener(releaseW);
        keyboard.addEventListener(releaseA);
        keyboard.addEventListener(releaseS);
        keyboard.addEventListener(releaseD);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                wExplained.draw();
                wKey.delete();
                wKeyRed.draw();
                break;
            case KeyboardEvent.KEY_A:
                aExplained.draw();
                aKey.delete();
                aKeyRed.draw();
                break;
            case KeyboardEvent.KEY_S:
                sExplained.draw();
                sKey.delete();
                sKeyRed.draw();
                break;
            case KeyboardEvent.KEY_D:
                dExplained.draw();
                dKey.delete();
                dKeyRed.draw();
                break;
            case KeyboardEvent.KEY_Q:
                starterMenu.starterMenu();
                starterMenu.setCurrent(starterMenu.getPlay());
                keyboard.removeEventListener(pressA);
                keyboard.removeEventListener(pressD);
                keyboard.removeEventListener(pressS);
                keyboard.removeEventListener(pressW);
                keyboard.removeEventListener(pressQ);
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_W:
                wExplained.delete();
                wKeyRed.delete();
                wKey.draw();
                break;
            case KeyboardEvent.KEY_A:
                aExplained.delete();
                aKeyRed.delete();
                aKey.draw();
                break;
            case KeyboardEvent.KEY_S:
                sExplained.delete();
                sKeyRed.delete();
                sKey.draw();
                break;
            case KeyboardEvent.KEY_D:
                dExplained.delete();
                dKeyRed.delete();
                dKey.draw();
                break;

            case KeyboardEvent.KEY_Q:
                keyboard.removeEventListener(releaseA);
                keyboard.removeEventListener(releaseD);
                keyboard.removeEventListener(releaseS);
                keyboard.removeEventListener(releaseW);
                keyboard.removeEventListener(releaseQ);
                break;
        }
    }


}
