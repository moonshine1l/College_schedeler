package ru.moonshine.college_schedeler;

public class timeData {

    private Integer id;


    private Integer num;
    private String start, end;

    public timeData(Integer id, Integer num, String start, String end) {
        this.id = id;
        this.num = num;
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

    public Integer getNum() {return num;}
}
