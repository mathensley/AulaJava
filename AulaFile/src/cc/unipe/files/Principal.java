package cc.unipe.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		File fonte = new File("C:\\ambiente\\texto.txt");
		File dir = new File("C:\\ambiente", "arquivo");
		
		if(!dir.exists())
			dir.mkdir();
		
		File destino = new File(dir, "texto.txt");
		
		if(fonte.exists() && !destino.exists()){
			FileInputStream in = new FileInputStream(fonte);
			FileOutputStream out = new FileOutputStream(destino);
			byte[] buffer = new byte[49192];
			int length = in.read(buffer);
			while(length != -1){
				out.write(buffer, 0, length);
				length = in.read(buffer);
			}
			in.close();
			out.flush();
			out.close();
		}
		
	}

}
