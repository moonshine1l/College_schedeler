package ru.moonshine.college_schedeler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button classroom;

    @FXML
    private Button classroomAdd;

    @FXML
    private Button classroomDelete;

    @FXML
    private TextField classroomId;

    @FXML
    private TableColumn<classroomData, Integer> classroomIdCol;

    @FXML
    private TextField classroomNum;

    @FXML
    private TableColumn<classroomData, Integer> classroomNumCol;

    @FXML
    private AnchorPane classroomPage;

    @FXML
    private TableView<classroomData> classroomTable;

    @FXML
    private Button classroomUpdate;

    @FXML
    private ComboBox<Integer> comboClassrom;

    @FXML
    private ComboBox<Integer> comboCourse;

    @FXML
    private ComboBox<String> comboGroup;

    @FXML
    private ComboBox<String> comboLesson;

    @FXML
    private ComboBox<Integer> comboNum;

    @FXML
    private ComboBox<String> comboTeacher;

    @FXML
    private Button course;

    @FXML
    private Button courseAdd;

    @FXML
    private Button courseDelete;

    @FXML
    private TextField courseId;

    @FXML
    private TableColumn<courseData, Integer> courseIdCol;

    @FXML
    private AnchorPane coursePage;

    @FXML
    private TableView<courseData> courseTable;

    @FXML
    private TextField courseTitle;

    @FXML
    private TableColumn<courseData, Integer> courseTitleCol;

    @FXML
    private Button courseUpdate;

    @FXML
    private DatePicker date;

    @FXML
    private Button group;

    @FXML
    private Button groupAdd;

    @FXML
    private Button groupDelete;

    @FXML
    private TextField groupId;

    @FXML
    private TableColumn<groupData, Integer> groupIdCol;

    @FXML
    private AnchorPane groupPage;

    @FXML
    private TableView<groupData> groupTable;

    @FXML
    private TextField groupTitle;

    @FXML
    private TableColumn<groupData, String> groupTitleCol;

    @FXML
    private Button groupUpdate;

    @FXML
    private Button lessonAdd;

    @FXML
    private Button lessonDelete;

    @FXML
    private TextField lessonId;

    @FXML
    private TableColumn<lessonData, Integer> lessonIdCol;

    @FXML
    private AnchorPane lessonPage;

    @FXML
    private TableView<lessonData> lessonTable;

    @FXML
    private TextField lessonTitle;

    @FXML
    private TableColumn<lessonData, String> lessonTitleCol;

    @FXML
    private Button lessonUpdate;

    @FXML
    private Button lessons;

    @FXML
    private Button schedule;

    @FXML
    private Button scheduleAdd;

    @FXML
    private TableColumn<?, ?> scheduleClassroomCol;

    @FXML
    private TableColumn<?, ?> scheduleCourseCol;

    @FXML
    private TableColumn<?, ?> scheduleDateCol;

    @FXML
    private TableColumn<?, ?> scheduleGroupCol;

    @FXML
    private TextField scheduleId;

    @FXML
    private TableColumn<?, ?> scheduleIdColumn;

    @FXML
    private TableColumn<?, ?> scheduleLessonCol;

    @FXML
    private TableColumn<?, ?> scheduleNumCol;

    @FXML
    private AnchorPane schedulePage;

    @FXML
    private TableView<?> scheduleTable;

    @FXML
    private TableColumn<?, ?> scheduleTeacherCol;

    @FXML
    private Button scheduleUpdate;

    @FXML
    private Button teacher;

    @FXML
    private Button teacherAdd;

    @FXML
    private Button teacherDelete;

    @FXML
    private TextField teacherId;

    @FXML
    private TableColumn<teacherData, Integer> teacherIdCol;

    @FXML
    private TextField teacherMail;

    @FXML
    private TableColumn<teacherData, String> teacherMailCol;

    @FXML
    private TextField teacherName;

    @FXML
    private TableColumn<teacherData, String> teacherNameCol;

    @FXML
    private AnchorPane teacherPage;

    @FXML
    private TextField teacherPatronymic;

    @FXML
    private TableColumn<teacherData, String> teacherPatronymicCol;

    @FXML
    private TextField teacherPhone;

    @FXML
    private TableColumn<teacherData, String> teacherPhoneCol;

    @FXML
    private TextField teacherSurname;

    @FXML
    private TableColumn<teacherData, String> teacherSurnameCol;

    @FXML
    private TableView<teacherData> teacherTable;

    @FXML
    private Button teacherUpdate;

    @FXML
    private Button time;

    @FXML
    private Button timeAdd;

    @FXML
    private Button timeDelete;

    @FXML
    private TextField timeEnd;

    @FXML
    private TableColumn<timeData, String> timeEndCol;

    @FXML
    private TextField timeId;

    @FXML
    private TableColumn<timeData, Integer> timeIdCol;

    @FXML
    private AnchorPane timePage;

    @FXML
    private TextField timeStart;

    @FXML
    private TableColumn<timeData, String> timeStartCol;

    @FXML
    private TableView<timeData> timeTable;

    @FXML
    private TextField timeNum;

    @FXML
    private TableColumn<?, ?> timeNumCol;

    @FXML
    private Button timeUpdate;

    private Connection con;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;




    public ObservableList<teacherData> addTeacher(){
        ObservableList<teacherData> listTeacher = FXCollections.observableArrayList();

        String sql = "SELECT * FROM teacher";

        con = Database.connectDB();
        try{
            teacherData teacherData;
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                teacherData = new teacherData(result.getInt("id"),
                        result.getString("surname"),
                        result.getString("name"),
                        result.getString("patronymic"),
                        result.getString("email"),
                        result.getString("phone"));

                listTeacher.add(teacherData);
            }
        } catch (Exception e){
            e.printStackTrace();
        }return listTeacher;
    }

    private ObservableList <teacherData> addTeacherList;
    public void addTeacherShowList(){
        addTeacherList = addTeacher();

        teacherIdCol.setCellValueFactory(new PropertyValueFactory<>("teacher_id"));
        teacherSurnameCol.setCellValueFactory(new PropertyValueFactory<>("teacher_surname"));
        teacherNameCol.setCellValueFactory(new PropertyValueFactory<>("teacher_name"));
        teacherPatronymicCol.setCellValueFactory(new PropertyValueFactory<>("teacher_patronymic"));
        teacherMailCol.setCellValueFactory(new PropertyValueFactory<>("teacher_email"));
        teacherPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        teacherTable.setItems(addTeacherList);
    }

    public ObservableList<classroomData> addClassroom(){
        ObservableList<classroomData> listClassroom = FXCollections.observableArrayList();

        String sql = "SELECT * FROM classroom";

        con = Database.connectDB();
        try{
            classroomData classroomData;
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                classroomData = new classroomData(result.getInt("id"),
                        result.getInt("number"));

                listClassroom.add(classroomData);
            }
        } catch (Exception e){
            e.printStackTrace();
        }return listClassroom;
    }

    private ObservableList <classroomData> addClassroomList;
    public void addClassroomShowList(){
        addClassroomList = addClassroom();

        classroomIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        classroomNumCol.setCellValueFactory(new PropertyValueFactory<>("classroom"));

        classroomTable.setItems(addClassroomList);
    }

    public void addSelectedTeacher(){
        teacherData teacherData = teacherTable.getSelectionModel().getSelectedItem();
        int num = teacherTable.getSelectionModel().getSelectedIndex();

        if ((num -1) < -1){return;}

        teacherId.setText(String.valueOf(teacherData.getTeacher_id()));
        teacherSurname.setText(String.valueOf(teacherData.getTeacher_surname()));
        teacherName.setText(String.valueOf(teacherData.getTeacher_name()));
        teacherPatronymic.setText(String.valueOf(teacherData.getTeacher_patronymic()));
        teacherMail.setText(String.valueOf(teacherData.getTeacher_email()));
        teacherPhone.setText(String.valueOf(teacherData.getPhone()));
    }

    public void addSelectedClassroom(){
        classroomData classroomData = classroomTable.getSelectionModel().getSelectedItem();
        int num = classroomTable.getSelectionModel().getSelectedIndex();

        if ((num -1) < -1){return;}

        classroomId.setText(String.valueOf(classroomData.getId()));
        classroomNum.setText(String.valueOf(classroomData.getClassroom()));

    }

    public ObservableList<courseData> addCourse(){
        ObservableList<courseData> listCourse = FXCollections.observableArrayList();

        String sql = "SELECT * FROM course";

        con = Database.connectDB();
        try{
            courseData courseData;
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                courseData = new courseData(result.getInt("id"),
                        result.getInt("number"));

                listCourse.add(courseData);
            }
        } catch (Exception e){
            e.printStackTrace();
        }return listCourse;
    }

    private ObservableList <courseData> addCourseList;
    public void addCourseShowList(){
        addCourseList = addCourse();

        courseIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        courseTitleCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        courseTable.setItems(addCourseList);
    }

    public void addSelectedCourse(){
        courseData courseData = courseTable.getSelectionModel().getSelectedItem();
        int num = courseTable.getSelectionModel().getSelectedIndex();

        if ((num -1) < -1){return;}

        courseId.setText(String.valueOf(courseData.getId()));
        courseTitle.setText(String.valueOf(courseData.getCourse()));

    }

    public ObservableList<groupData> addGroup(){
        ObservableList<groupData> listGroup = FXCollections.observableArrayList();

        String sql = "SELECT * FROM `group`";

        con = Database.connectDB();
        try{
            groupData groupData;
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                groupData = new groupData(result.getInt("id"),
                        result.getString("title"));

                listGroup.add(groupData);
            }
        } catch (Exception e){
            e.printStackTrace();
        }return listGroup;
    }

    private ObservableList <groupData> addGroupList;
    public void addGroupShowList(){
        addGroupList = addGroup();

        groupIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        groupTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        groupTable.setItems(addGroupList);
    }

    public void addSelectedGroup(){
        groupData groupData = groupTable.getSelectionModel().getSelectedItem();
        int num = groupTable.getSelectionModel().getSelectedIndex();

        if ((num -1) < -1){return;}

        groupId.setText(String.valueOf(groupData.getId()));
        groupTitle.setText(String.valueOf(groupData.getTitle()));

    }

    public ObservableList<lessonData> addLesson(){
        ObservableList<lessonData> listLesson = FXCollections.observableArrayList();

        String sql = "SELECT * FROM lesson";

        con = Database.connectDB();
        try{
            lessonData lessonData;
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                lessonData = new lessonData(result.getInt("id"),
                        result.getString("title"));

                listLesson.add(lessonData);
            }
        } catch (Exception e){
            e.printStackTrace();
        }return listLesson;
    }

    private ObservableList <lessonData> addLessonList;
    public void addLessonShowList(){
        addLessonList = addLesson();

        lessonIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        lessonTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));


        lessonTable.setItems(addLessonList);

    }

    public void addSelectedLesson(){
        lessonData lessonData = lessonTable.getSelectionModel().getSelectedItem();
        int num = lessonTable.getSelectionModel().getSelectedIndex();

        if ((num -1) < -1){return;}

        lessonId.setText(String.valueOf(lessonData.getId()));
        lessonTitle.setText(String.valueOf(lessonData.getTitle()));

    }

    public ObservableList<timeData> addTime(){
        ObservableList<timeData> listTime = FXCollections.observableArrayList();

        String sql = "SELECT * FROM time";

        con = Database.connectDB();
        try{
            timeData timeData;
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                timeData = new timeData(result.getInt("id"),
                        result.getInt("number"),
                        result.getString("start"),
                        result.getString("end"));


                listTime.add(timeData);
            }
        } catch (Exception e){
            e.printStackTrace();
        }return listTime;
    }


    private ObservableList <timeData> addTimeList;
    public void addTimeShowList(){
        addTimeList = addTime();

        timeIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        timeNumCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        timeStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        timeEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));

        timeTable.setItems(addTimeList);
    }

    public void addSelectedTime(){
        timeData timeData = timeTable.getSelectionModel().getSelectedItem();
        int num = timeTable.getSelectionModel().getSelectedIndex();

        if ((num -1) < -1){return;}

        timeId.setText(String.valueOf(timeData.getId()));
        timeNum.setText(String.valueOf(timeData.getNum()));
        timeStart.setText(String.valueOf(timeData.getStart()));
        timeEnd.setText(String.valueOf(timeData.getEnd()));

    }



    public void setComboCourse (){
        String sql = "SELECT `number` FROM course";
        List<Integer> list = new ArrayList<Integer>();
        con = Database.connectDB();
        try{
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){

                int num = result.getInt("number");
                list.add(num);
                ObservableList<Integer> lesNum = FXCollections.observableArrayList(list);
                comboCourse.setItems(lesNum);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setComboGroup (){
        List<String> list = new ArrayList<String>();
        String sql = "SELECT `title` FROM `group`";

        con = Database.connectDB();
        try{
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                String str = result.getString("title");
                list.add(str);
                ObservableList<String> lesNum = FXCollections.observableArrayList(list);
                comboGroup.setItems(lesNum);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setComboTeacher(){
        List<String> list = new ArrayList<String>();
        String sql = "SELECT `surname`, `name` FROM `teacher`";

        con = Database.connectDB();
        try{
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                String str = result.getString("surname");
                list.add(str);
                ObservableList<String> lesNum = FXCollections.observableArrayList(list);
                comboTeacher.setItems(lesNum);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setComboLesson (){
        List<String> list = new ArrayList<String>();
        String sql = "SELECT `title` FROM `lesson`";

        con = Database.connectDB();
        try{
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                String str = result.getString("title");
                list.add(str);
                ObservableList<String> lesNum = FXCollections.observableArrayList(list);
                comboLesson.setItems(lesNum);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setComboClassrom(){
        String sql = "SELECT `number` FROM classroom";
        List<Integer> list = new ArrayList<Integer>();
        con = Database.connectDB();
        try{
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){

                int num = result.getInt("number");
                list.add(num);
                ObservableList<Integer> lesNum = FXCollections.observableArrayList(list);
                comboClassrom.setItems(lesNum);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setComboTime(){
        String sql = "SELECT `number` FROM `time`";
        List<Integer> list = new ArrayList<Integer>();
        con = Database.connectDB();
        try{
            prepare = con.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){

                int num = result.getInt("number");
                list.add(num);
                ObservableList<Integer> lesNum = FXCollections.observableArrayList(list);
                comboNum.setItems(lesNum);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }






    public void createClassroom(){
        String insertData = "INSERT INTO classroom (number) VALUES (" +classroomNum.getText() +");";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(insertData);
            prepare.executeUpdate();
            addClassroomShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCourse(){
        String insertData = "INSERT INTO course (`number`) VALUES (" +courseTitle.getText() +");";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(insertData);
            prepare.executeUpdate();
            addCourseShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createGroup(){
        String insertData = "INSERT INTO `college_schedule`.`group` (`title`) VALUES ('"+ groupTitle.getText() +"');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(insertData);
            prepare.executeUpdate();
            addGroupShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createLesson(){
        String insertData = "INSERT INTO `lesson` (title) VALUES ('" +lessonTitle.getText() +"');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(insertData);
            prepare.executeUpdate();
            addLessonShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTeacher(){
        String insertData = "INSERT INTO `college_schedule`.`teacher` (`surname`, `name`, `patronymic`, `email`, `phone`) VALUES ('" + teacherSurname.getText() +"', '" + teacherName.getText()+"', '" + teacherPatronymic.getText()+"', '" + teacherMail.getText()+"', '" + teacherPhone.getText() + "');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(insertData);
            prepare.executeUpdate();
            addTeacherShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTime(){
        String insertData = "INSERT INTO `time` (`number`,`start`, `end`) VALUES ('" + timeNum.getText() + "', '" +timeStart.getText() + "', '" + timeEnd.getText() + "');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(insertData);
            prepare.executeUpdate();
            addTimeShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacher(){
        String updatetData = "UPDATE `college_schedule`.`teacher` SET `surname` = '" + teacherSurname.getText() +"', `name` = '" + teacherName.getText() +"', `patronymic` = '" + teacherPatronymic.getText() +"', `email` = '" + teacherMail.getText() +"', `phone` = '" + teacherPhone.getText() +"' WHERE (`id` =" + teacherId.getText() + ");";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updatetData);
            prepare.executeUpdate();
            addTeacherShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClassroom(){
        String updateData = "UPDATE `college_schedule`.`classroom` SET `number` = '" + classroomNum.getText() +"' WHERE (`id` =" + classroomId.getText() + ");";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addClassroomShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(){
        String updateData = "UPDATE `college_schedule`.`course` SET `number` = '" + courseTitle.getText() +"' WHERE (`id` =" + courseId.getText() + ");";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addCourseShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGroup(){
        String updateData = "UPDATE `college_schedule`.`group` SET `title` = '" + groupTitle.getText() +"' WHERE (`id` =" + groupId.getText() + ");";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addGroupShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLesson(){
        String updateData = "UPDATE `college_schedule`.`lesson` SET `title` = '" + lessonTitle.getText() +"' WHERE (`id` =" + lessonId.getText() + ");";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addLessonShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTime(){
        String updateData = "UPDATE `college_schedule`.`time` SET `number` = '" +timeNum.getText()+"',`start` = '" + timeStart.getText() +"', `end` = '" + timeEnd.getText() +"' WHERE (`id` =" + timeId.getText() + ");";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addTimeShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTime(){
        String updateData = "DELETE FROM `college_schedule`.`time` WHERE (`id` = '"+ timeId.getText()+"');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addTimeShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher(){
        String updateData = "DELETE FROM `college_schedule`.`teacher` WHERE (`id` = '"+ teacherId.getText()+"');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addTeacherShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClassroom(){
        String updateData = "DELETE FROM `college_schedule`.`classroom` WHERE (`id` = '"+ classroomId.getText()+"');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addClassroomShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(){
        String updateData = "DELETE FROM `college_schedule`.`course` WHERE (`id` = '"+ courseId.getText()+"');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addCourseShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGroup(){
        String updateData = "DELETE FROM `college_schedule`.`group` WHERE (`id` = '"+ groupId.getText()+"');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addGroupShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLesson(){
        String updateData = "DELETE FROM `college_schedule`.`lesson` WHERE (`id` = '"+ lessonId.getText()+"');";

        con = Database.connectDB();
        try {
            prepare = con.prepareStatement(updateData);
            prepare.executeUpdate();
            addLessonShowList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void switchForm(ActionEvent event){
        if (event.getSource() == schedule){
            schedulePage.setVisible(true);
            classroomPage.setVisible(false);
            coursePage.setVisible(false);
            groupPage.setVisible(false);
            lessonPage.setVisible(false);
            timePage.setVisible(false);
            teacherPage.setVisible(false);

            schedule.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            classroom.setStyle("-fx-background-color: transparent;");
            course.setStyle("-fx-background-color: transparent;");
            group.setStyle("-fx-background-color: transparent;");
            time.setStyle("-fx-background-color: transparent;");
            teacher.setStyle("-fx-background-color: transparent;");
            lessons.setStyle("-fx-background-color: transparent;");

            setComboCourse();
            setComboGroup();
            setComboLesson();
            setComboClassrom();
            setComboTime();
            setComboTeacher();
        } else if (event.getSource() == classroom){
            classroomPage.setVisible(true);
            schedulePage.setVisible(false);
            coursePage.setVisible(false);
            groupPage.setVisible(false);
            lessonPage.setVisible(false);
            timePage.setVisible(false);
            teacherPage.setVisible(false);

            classroom.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            schedule.setStyle("-fx-background-color: transparent;");
            course.setStyle("-fx-background-color: transparent;");
            group.setStyle("-fx-background-color: transparent;");
            time.setStyle("-fx-background-color: transparent;");
            teacher.setStyle("-fx-background-color: transparent;");
            lessons.setStyle("-fx-background-color: transparent;");

            addClassroomShowList();
        }else if (event.getSource() == course){
            classroomPage.setVisible(false);
            schedulePage.setVisible(false);
            coursePage.setVisible(true);
            groupPage.setVisible(false);
            lessonPage.setVisible(false);
            timePage.setVisible(false);
            teacherPage.setVisible(false);

            course.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            schedule.setStyle("-fx-background-color: transparent;");
            classroom.setStyle("-fx-background-color: transparent;");
            group.setStyle("-fx-background-color: transparent;");
            time.setStyle("-fx-background-color: transparent;");
            teacher.setStyle("-fx-background-color: transparent;");
            lessons.setStyle("-fx-background-color: transparent;");

            addCourseShowList();
        }else if (event.getSource() == group){
            classroomPage.setVisible(false);
            schedulePage.setVisible(false);
            coursePage.setVisible(false);
            groupPage.setVisible(true);
            lessonPage.setVisible(false);
            timePage.setVisible(false);
            teacherPage.setVisible(false);

            group.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            schedule.setStyle("-fx-background-color: transparent;");
            classroom.setStyle("-fx-background-color: transparent;");
            course.setStyle("-fx-background-color: transparent;");
            time.setStyle("-fx-background-color: transparent;");
            teacher.setStyle("-fx-background-color: transparent;");
            lessons.setStyle("-fx-background-color: transparent;");

            addGroupShowList();
        }else if (event.getSource() == lessons){
            classroomPage.setVisible(false);
            schedulePage.setVisible(false);
            coursePage.setVisible(false);
            groupPage.setVisible(false);
            lessonPage.setVisible(true);
            timePage.setVisible(false);
            teacherPage.setVisible(false);

            lessons.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            schedule.setStyle("-fx-background-color: transparent;");
            classroom.setStyle("-fx-background-color: transparent;");
            course.setStyle("-fx-background-color: transparent;");
            time.setStyle("-fx-background-color: transparent;");
            teacher.setStyle("-fx-background-color: transparent;");
            group.setStyle("-fx-background-color: transparent;");

            addLessonShowList();


        }else if (event.getSource() == time){
            classroomPage.setVisible(false);
            schedulePage.setVisible(false);
            coursePage.setVisible(false);
            groupPage.setVisible(false);
            lessonPage.setVisible(false);
            timePage.setVisible(true);
            teacherPage.setVisible(false);

            time.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            schedule.setStyle("-fx-background-color: transparent;");
            classroom.setStyle("-fx-background-color: transparent;");
            course.setStyle("-fx-background-color: transparent;");
            lessons.setStyle("-fx-background-color: transparent;");
            teacher.setStyle("-fx-background-color: transparent;");
            group.setStyle("-fx-background-color: transparent;");

            addTimeShowList();
        }else if (event.getSource() == teacher){
            classroomPage.setVisible(false);
            schedulePage.setVisible(false);
            coursePage.setVisible(false);
            groupPage.setVisible(false);
            lessonPage.setVisible(false);
            timePage.setVisible(false);
            teacherPage.setVisible(true);

            teacher.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            schedule.setStyle("-fx-background-color: transparent;");
            classroom.setStyle("-fx-background-color: transparent;");
            course.setStyle("-fx-background-color: transparent;");
            lessons.setStyle("-fx-background-color: transparent;");
            time.setStyle("-fx-background-color: transparent;");
            group.setStyle("-fx-background-color: transparent;");

            addTeacherShowList();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle res){

        addTeacherShowList();
        addClassroomShowList();
        addCourseShowList();
        addGroupShowList();
        addLessonShowList();
        addTimeShowList();
        setComboCourse();
        setComboGroup();
        setComboLesson();
        setComboClassrom();
        setComboTime();
        setComboTeacher();
    }

}
