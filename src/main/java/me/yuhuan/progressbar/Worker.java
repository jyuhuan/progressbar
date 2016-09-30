package me.yuhuan.progressbar;

/**
 * @author Yuhuan Jiang (jyuhuan@gmail.com).
 */
public class Worker extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i < 50) {
            System.out.print(i);
            System.out.print(' ');
            i += 1;
        }
        System.out.print('\n');
        System.out.print('\n');

    }
}
