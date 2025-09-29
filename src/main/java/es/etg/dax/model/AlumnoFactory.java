package es.etg.dax.model;

import es.etg.dax.model.mock.AlumnoMock;

public class AlumnoFactory {
    
    private static AlumnoInterface alumnoInterface;

    private static void inicializar(){
            alumnoInterface = new AlumnoMock();
    }

    public static AlumnoInterface obtener(){
        if (alumnoInterface == null){
            inicializar();
        }
        return alumnoInterface;
    }
}
