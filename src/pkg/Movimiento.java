package pkg;

public class Movimiento {
	public enum Signo {D, H};//Importante ponerlo public.

	//Atributos privados:
	private Double importe;
	private String detalle;
	private Signo signo;

	//Constructor:
	public Movimiento(Double importe,Signo signo,String detalle) {
		this.importe = importe;
		this.signo = signo;
		this.detalle = detalle;
	}

	//Getters y setters:
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Signo getSigno() {
		return signo;
	}

	public void setSigno(Signo signo) {
		this.signo = signo;
	}	
}
