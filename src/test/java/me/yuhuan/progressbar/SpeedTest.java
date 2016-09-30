package me.yuhuan.progressbar;

/**
 * @author Yuhuan Jiang (jyuhuan@gmail.com).
 */
public class SpeedTest {
    public static void main(String[] args) throws Exception {

        long t1 = System.nanoTime();

        ProgressBar pgBar = new ProgressBar("Decoding", 1000, 5L);
        pgBar.start();

        int i = 0;
        while (i < 1000) {
            //System.out.println("Training is at iteration " + i);
            i += 1;
            pgBar.advance();
            Thread.sleep(3L);
        }


        long t2 = System.nanoTime();

        long elapsed = t2 - t1;
        System.out.println("");
        System.out.println(elapsed);

        pgBar.stop();



    }
}
