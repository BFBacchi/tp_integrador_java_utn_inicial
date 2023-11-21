package validadorCorrelativasTest;

import org.example.validadorCorrelativas.Alumno;
import org.example.validadorCorrelativas.Inscripcion;
import org.example.validadorCorrelativas.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class InscripcionTest {

    @Test
    public void juanSePuedeAnotarAProgramacionI(){
        Alumno juan = new Alumno("juan", "60041096");
        Materia programacionI = new Materia("ProgramacionI");
        Inscripcion inscripcionDeJuanAProgramacionI = new Inscripcion(juan, programacionI);

        Assertions.assertTrue(inscripcionDeJuanAProgramacionI.aprobada());

    }
    @Test
    public void juanNoSePuedeAnotarAPrograII(){
        Alumno juan = new Alumno("juan", "60041096");
        Materia programacionI = new Materia("Programacion I");
        Materia programacionII = new Materia("Programacion II");

        programacionII.agregarCorrelativa(programacionI);
        Inscripcion inscripcionDeJuanAPrograII = new Inscripcion(juan, programacionII);

        Assertions.assertFalse(inscripcionDeJuanAPrograII.aprobada());
    }
    @Test
    public void juanPuedeAnotarAPrograII(){
        Alumno juan = new Alumno("juan", "60041096");
        Materia programacionI = new Materia("Programacion I");
        Materia programacionII = new Materia("Programacion II");

        programacionII.agregarCorrelativa(programacionI);
        juan.agregarMateriaAprobada(programacionI);
        Inscripcion inscripcionDeJuanAPrograII = new Inscripcion(juan, programacionII);

        Assertions.assertTrue(inscripcionDeJuanAPrograII.aprobada());
    }

}
