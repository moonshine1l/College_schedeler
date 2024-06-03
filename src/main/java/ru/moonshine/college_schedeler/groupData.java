package ru.moonshine.college_schedeler;

public class groupData {

    private Integer id;
    private String title;

    public groupData(Integer id, String title){
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public groupData(String title) {
        this.title = title;
    }
}
