package org.eda1.examenSegundoParcialGrupoA.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class NetworkExamenSegundoParcialTestJUnit4 {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNetworkNewProblem() {
		
		Network<Vertice> net = Network.createNetwork();
		
		TreeMap<Double, String> resultado = net.obtenerResultado();
		
		String cadenaSalida = resultado.toString();
		assertEquals(cadenaSalida, "{380.0=Pueblo01, 412.0=Pueblo02, 432.0=Pueblo03, 448.0=Pueblo04}");
		
		Map.Entry<Double, String> entry = resultado.firstEntry();
		assertEquals(entry.getValue(), "Pueblo01");
		assertTrue(entry.getKey() == 380.0);

	}
	
}
