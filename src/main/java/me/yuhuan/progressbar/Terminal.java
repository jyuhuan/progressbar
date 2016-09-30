package me.yuhuan.progressbar;

import jline.TerminalFactory;

/**
 * @author Yuhuan Jiang (jyuhuan@gmail.com).
 */
public class Terminal {

    public static int width() {
        return TerminalFactory.get().getWidth();
    }

    public static void returnCarriage() {
        System.out.print(Ansi.CarriageReturn);
    }

}
