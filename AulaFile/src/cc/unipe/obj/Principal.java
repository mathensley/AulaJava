package cc.unipe.obj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Computador p = new Computador();

		p.pc.add(new Computador("Lenovo", "lg13213"));
		p.pc.add(new Computador("Apale", "mac osdosds"));
		p.pc.add(new Computador("Samsongs", "samsjda"));
		p.pc.add(new Computador("Hell", "666"));
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("computadores.txt"));
		
		out.writeObject(p);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("computadores.txt"));
		
		Computador c = (Computador) in.readObject();
		
		for(Computador i : c.pc){
			System.out.println(i);
		}
		
		in.close();
	}

}
