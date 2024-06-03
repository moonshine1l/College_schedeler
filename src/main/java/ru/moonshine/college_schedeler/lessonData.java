package ru.moonshine.college_schedeler;

public class lessonData {

    private Integer id;
    private String title;

    public lessonData(Integer id, String title){
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public lessonData(String title) {
        this.title = title;
    }
}
