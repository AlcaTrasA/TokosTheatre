module com.example.tokostheatre {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.sql;


    opens com.example.tokostheatre to javafx.fxml;
    exports com.example.tokostheatre;
    exports com.example.tokostheatre.admin;
    opens com.example.tokostheatre.admin to javafx.fxml;
    exports com.example.tokostheatre.user;
    opens com.example.tokostheatre.user to javafx.fxml;
}