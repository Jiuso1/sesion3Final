package pkg;

public class Calculadora {

	public static Integer suma(int i, int j) {
		return i+j;
	}

	public static Integer resta(int i, int j) {
		return i-j;
	}

	public static Integer multiplica(int i, int j) {
		return i*j;
	}
	
	//Si dividimos un número por 0, se produce indeterminación.
	//Hemos decidido retornar -1 si esta situación sucede.
	public static Integer divide(int i, int j) {
		if(j != 0) {//Si no dividimos por 0:
			return i/j;
		}else {//Si dividimos por 0:
			return -1;
		}
	}
	
}
