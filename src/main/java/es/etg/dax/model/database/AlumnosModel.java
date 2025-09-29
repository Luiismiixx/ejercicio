package es.etg.dax.model.database;

import java.util.List;

import es.etg.dax.model.Alumno;

public class AlumnosModel {
    
    private AlumnosDAO alumnoDAO;

    public AlumnosModel(AlumnosDAO alumnoDAO){
        this.alumnoDAO = alumnoDAO;
    } 

    public List<Alumno> listarAlumnos() throws Exception{
        return alumnoDAO.listAll();
    }

    public boolean crearAlumno(String nombre, String apellidos, int edad) throws Exception{
        Alumno a = new Alumno(nombre, apellidos, edad);
        int numAlumno = alumnoDAO.insert(a);
        
        if (numAlumno == 1) {
            return true;
        }
        else {
            return false;

        }
    }

}
