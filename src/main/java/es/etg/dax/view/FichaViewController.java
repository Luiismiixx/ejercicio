package es.etg.dax.view;

import java.util.List;

import es.etg.dax.controller.AlumnoController;
import es.etg.dax.model.Alumno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FichaViewController {
    @FXML
    private Button btnCrear;

    @FXML 
    private Button btnListar;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEdad;


    protected AlumnoController alumnoController;

    public void setAlumnoController(AlumnoController controller){
        this.alumnoController = controller;
    }

    @FXML
    void crear(ActionEvent event) {
        final String MSG_TITLE =  "Error en el formulario";
        final String MSG_CONTENT = "Todos los campos son obligatorios";

        if(camposRellenos()){
            alumnoController.crearAlumno(txtNombre.getText(), txtApellidos.getText(), Integer.parseInt(txtEdad.getText()));
        }else{
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle(MSG_TITLE);
            alerta.setContentText(MSG_CONTENT);
            alerta.show();
        }
    }

    private boolean camposRellenos(){
        return campoRelleno(this.txtApellidos) && campoRelleno(this.txtNombre);
    }

    private boolean campoRelleno(TextField campo){
        boolean relleno = false;
        if(campo!=null && !"".equals(campo.getText().trim())){
            relleno = true;
        }
        return relleno;
    }

    @FXML
void listar(ActionEvent event) {
    
    List<Alumno> alumnos = alumnoController.listarAlumnos();

    
    StringBuilder sb = new StringBuilder();
    for (Alumno al : alumnos) {
        sb.append(al.getNombre())
          .append(" ")
          .append(al.getApellidos())
          .append(" ")
          .append(al.getEdad())
          .append("\n");
    }

    TextArea textArea = new TextArea(sb.toString());
    textArea.setEditable(false);
    textArea.setWrapText(true);
    textArea.setMaxWidth(Double.MAX_VALUE);
    textArea.setMaxHeight(Double.MAX_VALUE);

    Alert alerta = new Alert(AlertType.INFORMATION);
    alerta.setTitle("Listado de alumnos");
    alerta.setHeaderText("Alumnos matriculados");
    alerta.getDialogPane().setContent(textArea);
    alerta.showAndWait();
}
}
