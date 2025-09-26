module es.etg.dax {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.etg.dax to javafx.fxml;
    opens es.etg.dax.view to javafx.fxml;
    exports es.etg.dax.controller;
    exports es.etg.dax.view;
}
