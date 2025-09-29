package es.etg.dax.controller;

import java.io.IOException;
import java.util.List;

import es.etg.dax.Main;
import es.etg.dax.model.Alumno;
import es.etg.dax.model.AlumnoFactory;
import es.etg.dax.model.AlumnoInterface;
import es.etg.dax.view.FichaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AlumnoController extends Application{
    
    private final static String VIEW_MAIN = "view/fichaView.fxml";
    private static Scene scene;

    private static AlumnoInterface model;

    @Override
    public void start(Stage stage) throws IOException {

        //Inicializo el modelo
        model = AlumnoFactory.obtener();

        //Cargo la vista
        stage.setScene(cargarVista(VIEW_MAIN));
        stage.show();
    }

    private Scene cargarVista(String ficheroView) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ficheroView));
        Parent root = (Parent)fxmlLoader.load();  

        //Obtengo el controlador de la vista para pasarle una referencia al controlador - MVC:
        FichaViewController viewController = fxmlLoader.<FichaViewController>getController();
        viewController.setAlumnoController(this);
        Scene scene = new Scene(root); 
        
        return scene;
    }




    public Alumno crearAlumno(String nombre, String apellidos, int edad){

        Alumno al = new Alumno(nombre, apellidos, edad);
        model.crearAlumno(al);

        return al;
    }


    public List<Alumno> listarAlumnos(){
        return model.listarAlumno();
    }
    
}
