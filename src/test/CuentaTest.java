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
		movimiento = new Movimiento[8];
		
		movimiento[0] = new Movimiento(200d, Signo.D, "Retirada");//d de Double.12345
		movimiento[1] = new Movimiento(350d, Signo.D, "Retirada");//d de Double.
		movimiento[2] = new Movimiento(100d, Signo.H, "Ingreso");//d de Double.12345
		movimiento[3] = new Movimiento(200d, Signo.D, "Retirada");//d de Double.
		movimiento[4] = new Movimiento(150d, Signo.D, "Retirada");//d de Double.
		movimiento[5] = new Movimiento(200d, Signo.D, "Retirada");//d de Double.12345
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
		//Ponemos los saldos de inicio:
		cuenta12345.setSaldo(50);
		cuenta67890.setSaldo(0);
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
	
	@Test
	void test0014() {
		double saldoCuenta = cuenta12345.getSaldo();
		System.out.println("Saldo inicial de " + saldoCuenta +"€ en la cuenta "+cuenta12345.getNumero());
		
		cuenta12345.doMovimiento(movimiento[0]);
		cuenta12345.doMovimiento(movimiento[2]);
		cuenta12345.doMovimiento(movimiento[5]);
		
		saldoCuenta = cuenta12345.getSaldo();
		System.out.println("Saldo final de " + saldoCuenta +"€ en la cuenta "+cuenta12345.getNumero());
		assertEquals(-250d, saldoCuenta);//Voy a hacer solo una comprobación assertEquals.
		
		saldoCuenta = cuenta67890.getSaldo();
		System.out.println("Saldo inicial de " + saldoCuenta +"€ en la cuenta "+cuenta67890.getNumero());
		
		cuenta67890.doMovimiento(movimiento[1]);
		cuenta67890.doMovimiento(movimiento[3]);
		cuenta67890.doMovimiento(movimiento[4]);
		cuenta67890.doMovimiento(movimiento[6]);
		cuenta67890.doMovimiento(movimiento[7]);
		
		saldoCuenta = cuenta67890.getSaldo();
		System.out.println("Saldo final de " + saldoCuenta +"€ en la cuenta "+cuenta67890.getNumero());
	}

}
