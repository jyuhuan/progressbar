package me.yuhuan.progressbar;

import jline.TerminalFactory;

import java.io.*;

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

    static Writer _output = new OutputStreamWriter(System.out);

    public static Object control(int n, char c) throws IOException {
        _output.write("\\033[" + n + c);
        return new Object();
    }

    public static Object up(int n) throws IOException {
        if (n == 0) return "";
        else return control(n, 'A');
    }

    public static Object down(int n) throws IOException {
        if (n == 0) return "";
        else return control(n, 'B');
    }

    public static Object right(int n) throws IOException {
        if (n == 0) return "";
        else return control(n, 'C');
    }

    public static Object left(int n) throws IOException {
        if (n == 0) return "";
        else return control(n, 'D');
    }

    public static Object clearScreen(int n) throws IOException {
        return control(n, 'J');
    }

    public static Object clearLine(int n) throws IOException {
        return control(n, 'K');
    }



}
