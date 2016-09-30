package me.yuhuan.progressbar;

/**
 * @author Yuhuan Jiang (jyuhuan@gmail.com).
 */
public class CharUtils {
    public static String repeat(char c, int n) {
        char[] cs = new char[n];
        for (int i = 0; i < n; i++) cs[i] = c;
        return new String(cs);
    }
}
