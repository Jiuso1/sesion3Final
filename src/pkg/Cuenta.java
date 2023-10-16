package pkg;

import java.util.List;

public class Cuenta {
	
	private String numero;
	private String titular;
	private double saldo;
    private List <Movimiento> mMovimientos;
	
	public Cuenta(String numero, String titular, double saldo) {
		super();//Llamamos al constructor de la clase padre, Eclipse lo pone al crear el ctror automáticamente.
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void ingresar(double i) {
		this.setSaldo(this.getSaldo() + i);
	}
	
	public void retirar(double i) {//Consideramos que la cuenta tiene crédito infinito.
		this.setSaldo(this.getSaldo() - i);
	}
	
}
