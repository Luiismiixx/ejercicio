package es.etg.dax.model.database;

import java.util.List;

import es.etg.dax.model.Alumno;

public interface AlumnosDAO {

    /**
     * Devuelve el número de clientes insertados en la base de datos
     * @param Alumno
     * @return número de clientes insertados
     */

    public int insert(Alumno a) throws Exception;

    public List<Alumno> listAll() throws Exception;
} 
