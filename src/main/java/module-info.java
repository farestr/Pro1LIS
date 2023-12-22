module com.example.dp1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dp1 to javafx.fxml;
    exports com.example.dp1;
}