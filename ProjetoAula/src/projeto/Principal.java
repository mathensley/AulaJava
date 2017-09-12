package projeto;

public class Principal {

	public static void main(String[] args) {
		Pessoa a = new Pessoa("Matheus", 19, "01010");
		Object b = new Pessoa("Arthur", 19, "011110");
		Object c = new Pessoa("Yuri", 20, "3213211");

		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
	}

}
