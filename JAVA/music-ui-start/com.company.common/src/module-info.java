module com.company.common {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    exports com.company.common;
    opens com.company.common to javafx.base;
}