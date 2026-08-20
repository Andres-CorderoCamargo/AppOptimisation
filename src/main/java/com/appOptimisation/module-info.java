module com.appOptimisation {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.oshi;

    opens com.appOptimisation to javafx.fxml;
    exports com.appOptimisation;
}