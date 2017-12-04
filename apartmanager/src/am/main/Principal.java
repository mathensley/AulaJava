package am.main;

import java.sql.Connection;
import java.sql.SQLException;

import am.bd.Banco;
import am.telas.FrameApp;
import am.telas.FrameCAtividade;
import am.telas.FrameCDespesa;
import am.telas.FrameCadastro;
import am.telas.FrameDeletar;
import am.telas.FrameEdit;
import am.telas.FrameLogin;

public class Principal {

	public static void main(String[] args) {
		Connection c = null;
		c = Banco.conectarBanco();
		try {
			Banco.isTable(c, "cadastro");
			c = Banco.conectarBanco();
			Banco.isTable(c, "despesas");
			c = Banco.conectarBanco();
			Banco.isTable(c, "atividades");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		new FrameLogin();
		//new FrameCadastro();
		//new FrameApp();
		//new FrameCDespesa();
		//new FrameDeletar();
		//new FrameCAtividade();
		//new FrameEdit();
	}

}
