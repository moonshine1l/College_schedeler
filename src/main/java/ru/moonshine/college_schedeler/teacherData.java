package ru.moonshine.college_schedeler;

public class teacherData {
    private Integer teacher_id;
    private String teacher_name;
    private String teacher_surname;
    private String teacher_patronymic;
    private String teacher_email;
    private String phone;

    public teacherData(Integer teacher_id, String teacher_surname, String teacher_name,
                       String teacher_patronymic, String teacher_email, String phone){
        this.teacher_id = teacher_id;
        this.teacher_surname = teacher_surname;
        this.teacher_name = teacher_name;
        this.teacher_patronymic = teacher_patronymic;
        this.teacher_email = teacher_email;
        this.phone = phone;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public String getTeacher_surname() {
        return teacher_surname;
    }

    public String getTeacher_patronymic() {
        return teacher_patronymic;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public String getPhone() {
        return phone;
    }




}
