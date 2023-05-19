module com.example.javafxlistview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxlistview to javafx.fxml;
    exports com.example.javafxlistview;
}