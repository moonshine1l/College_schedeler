package ru.moonshine.college_schedeler;

public class courseData {

    private Integer id;
    private Integer course;

    public courseData(Integer id, Integer course) {
        this.id = id;
        this.course = course;
    }

    public courseData(Integer course) {
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCourse() {
        return course;
    }
}
