module edu.ggc.itec.itec3150exam2starter {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ggc.itec.exam2 to javafx.fxml;
    exports edu.ggc.itec.exam2;
}