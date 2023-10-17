package pkg;

import java.util.ArrayList;
import java.util.List;

import pkg.Movimiento.Signo;

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
		this.mMovimientos = new ArrayList<Movimiento>();//Reservamos memoria para el array de movimientos.
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public List<Movimiento> getmMovimientos() {
		return this.mMovimientos;
	}
	
	public void setmMovimientos(List<Movimiento> mMovimientos) {
		this.mMovimientos = mMovimientos;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void ingresar(double i) {
		Movimiento movimiento = new Movimiento(i, Signo.H, "Ingreso");
		mMovimientos.add(movimiento);//Añado el movimiento.
		this.saldo += i;//Incremento el saldo.
		System.out.println("Ingreso de "+i+"€");
	}
	
	public void retirar(double i) {
		//Debemos tener en cuenta el límite de descubierto de 500€.
		if (saldo - i >= -500) {
			Movimiento movimiento = new Movimiento(i, Signo.D, "Retirada");
			mMovimientos.add(movimiento);
			saldo -= i;
			System.out.println("Retirada de "+i+"€");
		} else {
			System.out.println("Fondos insuficientes (saldo "+this.saldo+"€) en la cuenta "+this.numero+" para el reintegro de "+i+"€ (x)");
		}
	}
	
	public void doMovimiento(Movimiento movimiento) {//Realiza el movimiento pasado por parámetro, en función del símbolo de este.
		if(movimiento.getSigno() == Signo.D) {
			//Retirada
			retirar(movimiento.getImporte());
		}else if(movimiento.getSigno() == Signo.H){
			//Ingreso
			ingresar(movimiento.getImporte());
		}
	}
	
}
