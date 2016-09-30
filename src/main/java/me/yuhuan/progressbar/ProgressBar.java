package me.yuhuan.progressbar;

import java.time.Duration;

/**
 * @author Yuhuan Jiang (jyuhuan@gmail.com).
 */
public class ProgressBar {

    TaskState task = null;
    Thread updater = null;

    public ProgressBar(String name, int max) throws Exception {
        this(name, max, 500L);
    }

    public ProgressBar(String name, int max, final long refreshInterval) throws Exception {
        if (max == -1) throw new Exception("Indefinite progress bar not supported yet! ");
        else task = new TaskState(name, 0, max);

        // Start a thread that updates the display periodically.
        updater = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        refresh();
                        Thread.sleep(refreshInterval);
                    }
                }
                catch (InterruptedException e) {}
            }
        };
    }


    /**
     * Updates the display.
     */
    void refresh() {
        /// Step 1: Flush the old line
        Terminal.returnCarriage();


        /// Step 2: Make a new line
        //Duration t = task.elapsedTime();

        String prefix = task.name + " " + task.percentageStr() + " [";
        String suffix = "] " + task.ratioStr();
        int allowedLength = Terminal.width() - prefix.length() - suffix.length();

        int numDots = ((int)Math.round(((double)task.cur) / task.max * allowedLength));
        int numSpaces = allowedLength - numDots;

        String content = prefix + CharUtils.repeat('=', numDots) + CharUtils.repeat(' ', numSpaces) + suffix;


        /// Step 3: Draw the new task
        System.out.print(content);
    }

    void advance() {
        task.advance();
    }

    void start() {
        updater.start();
    }

    void stop() {
        updater.stop();
    }


}
