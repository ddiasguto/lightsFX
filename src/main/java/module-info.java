module com.example.lightsfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.lightsfx to javafx.fxml;
    exports com.example.lightsfx;
}