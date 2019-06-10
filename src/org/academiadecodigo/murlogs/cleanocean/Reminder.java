package org.academiadecodigo.murlogs.cleanocean;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    Timer timer;
    Toolkit toolkit;
    int minutes = 10;
    int seconds = 00;
    Text text = new Text(10, 10, minutes + ":" + seconds);

    public Reminder(int seconds) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), 0, seconds * 1000);

    }

    class RemindTask extends TimerTask {
        int numWarningBeeps = 600000;

        @Override
        public void run() {
            text.setColor(Color.RED);
            text.draw();
            if (numWarningBeeps > 0) {
                //toolkit.beep();
                numWarningBeeps--;
                if (seconds != 0) {
                    text.delete();
                    seconds--;
                    text.draw();
                    if (seconds >= 10) {
                        text.setText(minutes + ":" + seconds);
                        return;
                    }
                    text.setText(minutes + ":0" + seconds);
                    return;
                }

                if (minutes != 0) {
                    seconds = 59;
                    minutes--;
                    text.setText(minutes + ":" + seconds);
                    return;
                }

            }
            text.translate(40, 22);
            text.setText("Game Over");
            text.draw();

            System.exit(0);
        }

    }


}
