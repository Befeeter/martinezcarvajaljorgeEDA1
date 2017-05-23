package org.eda1.examenSegundoParcialGrupoA.ejercicio01;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class ThesaurusExamenSegundoParcialTestJUnit4 {

	String directorioEntrada;
	
	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada 
				+ File.separator + "src"
				+ File.separator + "org" 
				+ File.separator + "eda1"
				+ File.separator + "examenSegundoParcialGrupoA" 
				+ File.separator + "ejercicio01"
				+ File.separator;
	}

	@Test
	public void testThesaurusNewAdd()  {
		
		ThesaurusTester thesaurus = new ThesaurusTester();
		
		String thesaurusFile = "Thesaurus.txt";
		thesaurusFile = directorioEntrada + thesaurusFile;
		
		thesaurus.constructThesaurus(thesaurusFile);

		assertTrue(thesaurus.size() == 91);
		
    	assertTrue(thesaurus.isSynonymousOf("limpio", "aseado"));

    	assertFalse(thesaurus.isSynonymous("aseados"));

    	assertTrue(thesaurus.hasSynonymous("verdadero"));
    	
    	assertTrue(thesaurus.size("activo") == 16);
    	
    	assertEquals(thesaurus.size("activo"), thesaurus.size("diligente"));
    	
    	TreeSet<String> ts1 = thesaurus.getSynonymous("diligente"); 
    	TreeSet<String> ts2 = new TreeSet<String>();
    	ts2.add("acelerado");
    	ts2.add("activo");
    	ts2.add("afanoso");
    	ts2.add("esforzado");
    	ts2.add("hacendoso");
    	ts2.add("laborioso");
    	ts2.add("ligero");
    	ts2.add("presto");
    	ts2.add("presuroso");
    	ts2.add("pronto");
    	ts2.add("raudo");
    	ts2.add("rápido");
    	ts2.add("tenaz");
    	ts2.add("trabajador");
    	ts2.add("veloz");
    	ts2.add("ágil");
    	assertEquals(ts1, ts2);

    	assertTrue(thesaurus.size("presto") == 10);
    	
    	assertTrue(thesaurus.size("caradura") == 8);
    	
    	thesaurus.add("acabado logrado terminado conseguido rematado completado");
		    	
    	assertTrue(thesaurus.size() == 97);
    	
    	assertFalse(thesaurus.isSynonymousOf("rematado", "consegido"));
    	
    	assertTrue(thesaurus.size("terminado") == 5);
    	
    	assertTrue(thesaurus.subThesaurus("a", "c").size() == 22);

    	assertTrue(thesaurus.subThesaurus("p", "t").size() == 18);
    	
		String cadenaSalida = thesaurus.subThesaurus("m", "n").toString();
		String cadenaEsperada = "{majo=[atractivo, bello, bonito, guapo, hermoso, lindo, pimpollo, precioso]}";
		assertEquals(cadenaSalida, cadenaEsperada);

		assertTrue(thesaurus.size("trabajador") == 7);
    	assertTrue(thesaurus.hasSynonymous("diligente"));

		thesaurus.remove("diligente");
		
		assertTrue(thesaurus.size() == 96);
		assertTrue(thesaurus.size("trabajador") == 6);
    	assertFalse(thesaurus.hasSynonymous("diligente"));
		
		ts1 = thesaurus.getSynonymous("activo");
    	ts2.clear();
    	ts2.add("acelerado");
    	ts2.add("afanoso");
    	ts2.add("esforzado");
    	ts2.add("hacendoso");
    	ts2.add("laborioso");
    	ts2.add("ligero");
    	ts2.add("presto");
    	ts2.add("presuroso");
    	ts2.add("pronto");
    	ts2.add("raudo");
    	ts2.add("rápido");
    	ts2.add("tenaz");
    	ts2.add("trabajador");
    	ts2.add("veloz");
    	ts2.add("ágil");
    	assertEquals(ts1, ts2);
		
	}

}
