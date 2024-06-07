package ru.moonshine.college_schedeler;

import java.time.LocalDate;
import java.util.Date;

public class scheduleData {

    private Integer id;
    private Date date;
    private String teacher, group, lesson;
    private Integer course, time, classroom;

    public scheduleData(Integer id, Date date, Integer course, String group, Integer time, String lesson, String teacher, Integer classroom) {
        this.id = id;
        this.date = date;
        this.teacher = teacher;
        this.group = group;
        this.lesson = lesson;
        this.course = course;
        this.time = time;
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getGroup() {
        return group;
    }

    public String getLesson() {
        return lesson;
    }

    public Integer getCourse() {
        return course;
    }

    public Integer getTime() {
        return time;
    }

    public Integer getClassroom() {
        return classroom;
    }
}
