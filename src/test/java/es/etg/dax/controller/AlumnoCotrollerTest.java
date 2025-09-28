package es.etg.dax.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import es.etg.dax.model.Alumno;
import es.etg.dax.model.database.AlumnosDAO;



@ExtendWith(MockitoExtension.class)
public class AlumnoCotrollerTest {

    @InjectMocks
    AlumnoController alumnoController;

    @Mock
    AlumnosDAO alumnosDAO;

    @Test
    public void crearAlumno() throws Exception {
        
        Mockito.when(alumnosDAO.insert(any())).thenReturn(1);

        boolean resultado = alumnoController.crearAlumno("Luismi", "Lopez", 18);

        assertTrue(resultado);
    }    

    @Test
    public void listarAlumno() throws Exception{
        
        Mockito.when(alumnosDAO.listAll()).thenReturn(List.of());

        List<Alumno> list = alumnoController.listarAlumnos();

        assertNotNull(list);
        assertTrue(list.isEmpty());
    }

}
