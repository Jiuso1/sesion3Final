package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;
import pkg.Movimiento;
import pkg.Movimiento.Signo;

class CuentaTest {

	private Cuenta cuentaPrueba;
	private static Movimiento[] movimiento;//Array de movimientos.
	private static Cuenta cuenta12345;
	private static Cuenta cuenta67890;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		movimiento[0] = new Movimiento(200d, Signo.D, "Retirada");//d de Double.
		movimiento[1] = new Movimiento(350d, Signo.D, "Retirada");//d de Double.
		movimiento[2] = new Movimiento(100d, Signo.H, "Ingreso");//d de Double.
		movimiento[3] = new Movimiento(200d, Signo.D, "Retirada");//d de Double.
		movimiento[4] = new Movimiento(150d, Signo.D, "Retirada");//d de Double.
		movimiento[5] = new Movimiento(200d, Signo.D, "Retirada");//d de Double.
		movimiento[6] = new Movimiento(50d, Signo.H, "Ingreso");//d de Double.
		movimiento[7] = new Movimiento(100d, Signo.D, "Retirada");//d de Double.
		
		cuenta12345 = new Cuenta("12345", "Agapito Peñaflores", 50);
		cuenta67890 = new Cuenta("67890", "Reina Isabel II", 0);
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
