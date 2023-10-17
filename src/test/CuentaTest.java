package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;

class CuentaTest {

	private Cuenta cuentaPrueba;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cuentaPrueba = new Cuenta("00000","Titular de prueba",0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIngresar() {
		cuentaPrueba.ingresar(100);
		assertEquals(100, cuentaPrueba.getSaldo());
	}
	
	@Test
	void testRetirar() {
		cuentaPrueba.ingresar(100);
		cuentaPrueba.retirar(50);
		assertEquals(50, cuentaPrueba.getSaldo());//Deberían quedar aquí 50 euros.
	}

}
