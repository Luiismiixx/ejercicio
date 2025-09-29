package es.etg.dax.model.mock;

import java.util.ArrayList;
import java.util.List;

import es.etg.dax.model.Alumno;
import es.etg.dax.model.AlumnoInterface;

public class AlumnoMock implements AlumnoInterface{
    
    private List<Alumno> lista = new ArrayList<>();

    @Override
    public void crearAlumno(Alumno a){
        lista.add(a);
    }

    @Override
    public List<Alumno> listarAlumno(){
        return lista;

    }
}
