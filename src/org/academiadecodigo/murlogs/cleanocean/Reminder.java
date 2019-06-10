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
    Text text = new Text(0, 0, minutes + ":" + seconds);

    public Reminder(int seconds) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), 0, seconds * 1000);

    }

    class RemindTask extends TimerTask {
        int numWarningBeeps = 0;

        @Override
        public void run() {
            text.setColor(Color.RED);
            text.draw();
            if (numWarningBeeps > 0) {
                toolkit.beep();
                numWarningBeeps--;
                if (minutes == 0) {
                    text.setText("Fodasse");
                    return;
                }
                if (seconds != 0) {
                    text.delete();
                    seconds--;
                    text.draw();
                    text.setText(minutes + ":" + seconds);
                    return;
                }

                if (minutes != 0) {
                    seconds = 59;
                    minutes--;
                    text.setText(minutes + ":" + seconds);
                    return;
                }

            }

        }
    }


}
