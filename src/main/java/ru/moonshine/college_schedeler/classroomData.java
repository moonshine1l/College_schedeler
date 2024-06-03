package ru.moonshine.college_schedeler;

public class classroomData {

    private Integer id;
    private Integer classroom;

    public Integer getClassroom() {
        return classroom;
    }

    public void setClassroom(Integer classroom) {
        this.classroom = classroom;
    }

    public classroomData(Integer id, Integer classroom){
        this.id = id;
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
    }

    public classroomData(Integer classroom) {
        this.classroom = classroom;
    }
}
