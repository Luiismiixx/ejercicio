package es.etg.dax.model.database;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import es.etg.dax.model.Alumno;



@ExtendWith(MockitoExtension.class)
public class AlumnosModelTest {

    @InjectMocks
    AlumnosModel alumnosModel;

    @Mock
    AlumnosDAO alumnosDAO;

    @Test
    public void crearAlumno() throws Exception {
        
        Mockito.when(alumnosDAO.insert(any())).thenReturn(1);

        boolean resultado = alumnosModel.crearAlumno("Luismi", "Lopez", 18);

        assertTrue(resultado);
    }    

    @Test
    public void listarAlumno() throws Exception{
        
        Mockito.when(alumnosDAO.listAll()).thenReturn(List.of());

        List<Alumno> list = alumnosModel.listarAlumnos();

        assertNotNull(list);
        assertTrue(list.isEmpty());
    }
    
}
