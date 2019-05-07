package note.controller;

import static org.junit.Assert.*;

import note.main.ClasaException;
import note.model.Nota;
import note.utils.Constants;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NoteControllerTest {
    private NoteController ctrl;

    @Before
    public void init(){
        ctrl = new NoteController();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void test1() throws ClasaException {
        ctrl.addNota(new Nota(100, "Limba Romana", 10));
        assertEquals(ctrl.getNote().size(), 1);
    }

    @Test
    public void test2() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidMateria);
        ctrl.addNota(new Nota(100, "LR", 10));
    }

    @Test
    public void test3() throws ClasaException {
        ctrl.addNota(new Nota(100, "Limba Romana", 9));
        assertEquals(ctrl.getNote().size(), 1);
    }

    @Test
    public void test4() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidNota);
        ctrl.addNota(new Nota(100, "Limba Romana", 11));
    }

    @Test
    public void test5() throws ClasaException {
        ctrl.addNota(new Nota(100, "Limba Engleza", 9));
        assertEquals(ctrl.getNote().size(), 1);
    }

    @Test
    public void test6() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidMateria);
        ctrl.addNota(new Nota(100, "Limba si Literatura Romana", 8));
    }

    @Test
    public void test7() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidNota);
        ctrl.addNota(new Nota(100, "Limba Franceza", 0));
    }

    @Test
    public void test8() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidNota);
        ctrl.addNota(new Nota(100, "Limba Finlandeza", -1));
    }

    @Test
    public void test9() throws ClasaException {
        exception.expect(ClasaException.class);
        exception.expectMessage(Constants.invalidNota);
        ctrl.addNota(new Nota(100, "Limba Romana", 15));
    }
}