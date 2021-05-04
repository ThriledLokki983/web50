module com.company.ui {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.company.db;

    exports com.company.ui to javafx.graphics, javafx.fxml;
    opens com.company.ui to javafx.fxml;

}