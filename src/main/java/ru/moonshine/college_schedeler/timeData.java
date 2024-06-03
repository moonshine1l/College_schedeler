package ru.moonshine.college_schedeler;

import java.time.LocalTime;

public class timeData {

    private Integer id;
    private String start, end;

    public timeData(Integer id, String start, String end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
