package note.repository;

import note.model.Elev;
import note.model.Medie;
import note.model.Nota;
import note.utils.Constants;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.NaN;
import static org.junit.Assert.*;

public class ClasaRepositoryMockTest {
    private ClasaRepositoryMock clasa;
    @Before
    public void setUp() throws Exception {
        clasa = new ClasaRepositoryMock();
    }

    @Test
    public void calculeazaMedii_1() {
        List<Elev> elevi = new ArrayList<>();
        List<Nota> note = new ArrayList<>();
        List<Medie> medii;
        clasa.creazaClasa(elevi, note);
        try {
            medii = clasa.calculeazaMedii();
            assert true;
        }
        catch (Exception ex)
        {
            assertEquals(ex.getMessage(), Constants.emptyRepository);
        }
    }

    @Test
    public void calculeazaMedii_2() {
        List<Elev> elevi = new ArrayList<>();
        List<Nota> note = new ArrayList<>();
        List<Medie> medii;
        List<Medie> expected_medii = new ArrayList<>();
        Elev elev1 = new Elev(1,"elev1");
        Medie m1 = new Medie(); m1.setElev(elev1); m1.setMedie(NaN);

        expected_medii.add(m1);
        elevi.add(elev1);
        clasa.creazaClasa(elevi, note);
        try {
            medii = clasa.calculeazaMedii();
            assert check_medii(medii, expected_medii);
        }
        catch (Exception ex)
        {
            assert false;
        }
    }

    @Test
    public void calculeazaMedii_3() {
        List<Elev> elevi = new ArrayList<>();
        List<Nota> note = new ArrayList<>();
        List<Medie> medii;
        List<Medie> expected_medii = new ArrayList<>();
        Elev elev1 = new Elev(1,"elev1");
        Nota n1 = new Nota(1,"vvsss", 10);
        Medie m1 = new Medie(); m1.setElev(elev1); m1.setMedie(10);
        expected_medii.add(m1);
        elevi.add(elev1);
        note.add(n1);
        clasa.creazaClasa(elevi, note);
        try {
            medii = clasa.calculeazaMedii();
            System.out.println(medii);
            assert check_medii(medii, expected_medii);
        }
        catch (Exception ex)
        {
            assert false;
        }
    }

    @Test
    public void calculeazaMedii_4() {
        List<Elev> elevi = new ArrayList<>();
        List<Nota> note = new ArrayList<>();
        List<Medie> medii;
        List<Medie> expected_medii = new ArrayList<>();
        Elev elev1 = new Elev(1,"elev1");
        Nota n1 = new Nota(1,"vvsss", 10);
        Nota n2 = new Nota(1,"vvsss", 8);
        Medie m1 = new Medie(); m1.setElev(elev1); m1.setMedie(9);
        expected_medii.add(m1);
        elevi.add(elev1);
        note.add(n1);
        note.add(n2);
        clasa.creazaClasa(elevi, note);
        try {
            medii = clasa.calculeazaMedii();
            System.out.println(medii);
            assert check_medii(medii, expected_medii);
        }
        catch (Exception ex)
        {
            assert false;
        }
    }

    @Test
    public void calculeazaMedii_5() {
        List<Elev> elevi = new ArrayList<>();
        List<Nota> note = new ArrayList<>();
        List<Medie> medii;
        List<Medie> expected_medii = new ArrayList<>();
        Elev elev1 = new Elev(1,"elev1");
        Nota n1 = new Nota(1,"vvsss", 10);
        Nota n2 = new Nota(1,"vvsss", 8);
        Medie m1 = new Medie(); m1.setElev(elev1); m1.setMedie(9);
        expected_medii.add(m1);
        elevi.add(elev1);
        note.add(n1);
        note.add(n2);

        Elev elev2 = new Elev(2,"elev2");
        Nota n21 = new Nota(2,"vvsss", 5);
        Nota n22 = new Nota(2,"vvsss", 7);
        Medie m2 = new Medie(); m2.setElev(elev2); m2.setMedie(6);
        expected_medii.add(m2);
        elevi.add(elev2);
        note.add(n21);
        note.add(n22);

        clasa.creazaClasa(elevi, note);
        try {
            medii = clasa.calculeazaMedii();
            System.out.println(medii);
            assert true;
        }
        catch (Exception ex)
        {
            assert false;
        }
    }
    private boolean check_medii(List<Medie> medii, List<Medie> expected_medii) {
        Medie m1, m2;
        for (int i = 0; i < medii.size(); i++)
        {
            m1 = medii.get(i);
            m2 = expected_medii.get(i);
            System.out.println(m1.getElev().getNrmatricol());
            System.out.println(m2.getElev().getNrmatricol());
            System.out.println(m1.getMedie());
            System.out.println(m2.getMedie());

            if (m1.getElev().getNrmatricol() != m2.getElev().getNrmatricol())
                return false;
            if (Double.isNaN(m1.getMedie()) && Double.isNaN(m2.getMedie()))
                continue;
            if (m1.getMedie() != m2.getMedie())
                return false;
        }
        return true;
    }

}