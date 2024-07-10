module org.example.appdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens org.example.appdesktop to javafx.fxml;
    opens org.example.appdesktop.model.Entities to org.hibernate.orm.core;
    opens org.example.appdesktop.model.Classes to org.hibernate.orm.core; // Added this line
    opens org.example.appdesktop.controller to javafx.fxml;
    opens org.example.appdesktop.model.Daos to org.hibernate.orm.core; // Added this line

    exports org.example.appdesktop;
    exports org.example.appdesktop.controller;
}
