module com.example.zberovocia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zberovocia to javafx.fxml;
    exports com.example.zberovocia;
}