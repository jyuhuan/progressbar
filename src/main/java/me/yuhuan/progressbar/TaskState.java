package me.yuhuan.progressbar;

import java.time.*;

/**
 * @author Yuhuan Jiang (jyuhuan@gmail.com).
 */
public class TaskState {
    String name;
    int cur = 0;
    int max = 0;

    LocalDateTime startTime = null;
    LocalDateTime endTime = null;

    public TaskState(String name, int cur, int max) {
        this.name = name;
        this.cur = cur;
        this.max = max;
    }

    String percentageStr() {
        return String.valueOf(Math.round(((double) cur) / max * 100)) + "%";
    }

    String ratioStr() {
        return cur + "/" + max;
    }

    Duration elapsedTime() {
        return Duration.between(startTime, endTime);
    }

    void advanceBy(int n) {
        cur += n;
    }

    void advance() {
        advanceBy(1);
    }

    void advanceTo(int n) {
        if (n < 0) cur = 0;
        else cur = n;
    }

}
