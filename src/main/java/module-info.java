module ru.moonshine.college_schedeler {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires javafx.base;


    opens ru.moonshine.college_schedeler to javafx.fxml;
    exports ru.moonshine.college_schedeler;


}