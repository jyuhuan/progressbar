package me.yuhuan.progressbar;

/**
 * Created by yuhuan on 10/01/2016.
 */
public class ProgressBarTest {
    public static void main(String[] args) throws Exception {
        ProgressBar pgBar = new ProgressBar("Decoding", 1000, 5L);
        pgBar.start();

        int i = 0;
        while (i < 1000) {
            i += 1;
            pgBar.advance();
            Thread.sleep(10L);
        }

        pgBar.stop();
    }
}
