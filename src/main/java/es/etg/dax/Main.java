package es.etg.dax;
import es.etg.dax.controller.AlumnoController;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {

        AlumnoController controller = new AlumnoController();

        Application.launch(AlumnoController.class, args);
    }
    
}