package am.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import am.main.Atividades;
import am.main.Cadastro;
import am.main.Despesas;
import am.utils.Utils;

public class Banco {
	
	//Função que cria e retorna a conexão com o banco
	public static Connection conectarBanco(){
		Connection c = null;
		
		try {
	         Class.forName(Utils.driver);
	         c = DriverManager.getConnection(Utils.db_url, Utils.user, Utils.password);
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Banco aberto com sucesso!");
	      return c; 
	}
	
	//Validar se tabela existe no banco, se não cria ela
	public static boolean isTable(Connection c, String table) throws SQLException{
		boolean tExists = false;
		
		try (ResultSet rs = c.getMetaData().getTables(null, null, table, null)) {
	        while (rs.next()) { 
	            String tName = rs.getString("TABLE_NAME");
	            if (tName != null && tName.equals(table)) {
	                tExists = true;
	                System.out.println("Table existe!");
	                c.close();
	                break;
	            }
	        }
	    }
		
		if(tExists == false){
			if(table.equals("cadastro")){
				Statement stmt = c.createStatement();
				String sql = "CREATE TABLE " + table + "(nome varchar(100) not null,"
						+ "email varchar(100) not null,"
						+ "cpf varchar(11) primary key,"
						+ "fone varchar(20) not null,"
						+ "senha varchar(50) not null,"
						+ "apto varchar(10) not null,"
						+ "tipo varchar(50) not null)";
				stmt.executeUpdate(sql);
				stmt.close();
				tExists = true;
				System.out.println("Table criada com sucesso!");
				c.close();
			}
			if(table.equals("despesas")){
				Statement stmt = c.createStatement();
				String sql = "CREATE TABLE " + table + " (nome varchar(100) not null,"
						+ "frequencia varchar(50) not null,"
						+ "valor varchar(50) not null,"
						+ "id int primary key,"
						+ "vencimento varchar(50) not null,"
						+ "cpf varchar(11) not null,"
						+ "foreign key(cpf) references cadastro(cpf))";
				stmt.executeUpdate(sql);
				stmt.close();
				tExists = true;
				System.out.println("Table criada com sucesso!");
				c.close();
			}
			if(table.equals("atividades")){
				Statement stmt = c.createStatement();
				String sql = "CREATE TABLE " + table + " (nome varchar(100) not null,"
						+ "data varchar(50) not null,"
						+ "status varchar(50) not null,"
						+ "id int primary key,"
						+ "cpf varchar(11) not null,"
						+ "foreign key(cpf) references cadastro(cpf))";
				stmt.executeUpdate(sql);
				stmt.close();
				tExists = true;
				System.out.println("Table criada com sucesso!");
				c.close();
			}
		}
		
	    return tExists;
	}
	
	//Inserção dos dados no banco
	public static void inserir(Connection c, Object obj, String table) throws SQLException{
		c = conectarBanco();
		c.setAutoCommit(false);
		PreparedStatement stmt = null;
		
		if(table.equals("cadastro") && obj instanceof Cadastro){
			Cadastro i = (Cadastro) obj;
			stmt = c.prepareStatement(Utils.cadastro);
			stmt.setString(1, i.getNome());
			stmt.setString(2, i.getEmail());
			stmt.setString(3, i.getCpf());
			stmt.setString(4, i.getFone());
			stmt.setString(5, i.getSenha());
			stmt.setString(6, i.getApto());
			stmt.setString(7, i.getTipo());
			stmt.executeUpdate();
		    c.commit();
		        
		    stmt.close();
		    c.close();
		    System.out.println("Dados salvos no banco com sucesso!");
		}
		
		else if(table.equals("despesas") && obj instanceof Despesas){
			Despesas i = (Despesas) obj;
			
			stmt = c.prepareStatement(Utils.despesas);
			stmt.setString(1, i.getNome());
			stmt.setString(2, i.getFrequencia());
			stmt.setString(3, i.getValor());
			stmt.setInt(4, i.getId());
			stmt.setString(5, i.getVencimento());
			stmt.setString(6, i.getCpf());
			stmt.executeUpdate();
	        c.commit();
	        c.close();
	        System.out.println("Dados salvos no banco com sucesso!");
		}
		
		else if(table.equals("atividades") && obj instanceof Atividades){
			Atividades i = (Atividades) obj;
			
			stmt = c.prepareStatement(Utils.atividades);
			stmt.setString(1, i.getNome());
			stmt.setString(2, i.getData());
			stmt.setString(3, i.getStatus());
			stmt.setInt(4, i.getId());
			stmt.setString(5, i.getCpf());
			stmt.executeUpdate();
	        c.commit();
	        c.close();
	        System.out.println("Dados salvos no banco com sucesso!");
		}
	}
	
	//Select para validar login
	public static boolean selectLogin(Connection c, String nome, String senha, String tipo) throws SQLException{
		c = conectarBanco();
		c.setAutoCommit(false);
		Statement stmt = null;
		
		stmt = c.createStatement();
		
		ResultSet rs = stmt.executeQuery("select nome, senha, tipo from cadastro;");
		
		while(rs.next()){
			String n = rs.getString("nome");
			String s = rs.getString("senha");
			String t = rs.getString("tipo");
			if(n.equals(nome) && s.equals(senha) && t.equals(tipo)){
				rs.close();
				stmt.close();
				c.close();
				return true;
			}
		}
		rs.close();
		stmt.close();
		c.close();
		return false;
	}
	
	//Select que retorna o cpf do sindico
	public static String selectSindico(Connection c, String nome){
		c = conectarBanco();
		String cpf = null;
		
		try {
			c.setAutoCommit(false);
			Statement stmt = null;
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select cpf from cadastro where nome = '" + nome + "'");
			
			while(rs.next()){
				cpf = rs.getString("cpf");
			}
			rs.close();
			stmt.close();
			c.close();
			return cpf;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cpf;
	}
	
	//Select que retorna o cpf de acordo com o id passado
	public static String selectCpf(Connection c, String table, int id){
		c = conectarBanco();
		String cpf = null;
		
		try {
			c.setAutoCommit(false);
			Statement stmt = null;
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select cpf from " + table + " where id = " + id);
			
			while(rs.next()){
				cpf = rs.getString("cpf");
			}
			rs.close();
			stmt.close();
			c.close();
			return cpf;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cpf;
	}
	
	//Validar se existe algum sindico cadastrado
	public static boolean isSindico(Connection c){
		c = conectarBanco();
		
		try {
			c.setAutoCommit(false);
			Statement stmt = null;
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select tipo from cadastro");
			
			while(rs.next()){
				String tipo = rs.getString("tipo");
				if(tipo.equals("Síndico")){
					rs.close();
					stmt.close();
					c.close();
					return true;
				}
			}
			rs.close();
			stmt.close();
			c.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Validar se o id existe
	public static boolean isId(Connection c, int id, String table){
		c = conectarBanco();
		
		try {
			c.setAutoCommit(false);
			Statement stmt = null;
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select id from " + table);
			
			while(rs.next()){
				int i = rs.getInt("id");
				if(i == id){
					rs.close();
					stmt.close();
					c.close();
					return true;
				}
			}
			rs.close();
			stmt.close();
			c.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Validar se o cpf existe
	public static boolean isCpf(Connection c, String cp, String table){
		c = conectarBanco();
		
		try {
			c.setAutoCommit(false);
			Statement stmt = null;
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select cpf from " + table);
			
			while(rs.next()){
				String i = rs.getString("cpf");
				if(i.equals(cp)){
					rs.close();
					stmt.close();
					c.close();
					return true;
				}
			}
			rs.close();
			stmt.close();
			c.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Update para a tabela de atividades
	public static void update(Connection c, int id, String status) throws SQLException{
		c = conectarBanco();
		
		c.setAutoCommit(false);
		PreparedStatement stmt = null;
		
		stmt = c.prepareStatement("update atividades set status = ? where id = ?");
		stmt.setString(1, status);
		stmt.setInt(2, id);
		stmt.executeUpdate();
			
		c.commit();
			
		System.out.println("Dado atualizado com sucesso!");
		
		stmt.close();
		c.close();
	}
	
	//Delete
	public static void delete(Connection c, String table, String nome1, String nome2) throws SQLException{
		c = conectarBanco();
		c.setAutoCommit(false);
		PreparedStatement stmt = null;
		
		stmt = c.prepareStatement("delete from " + table + " where " + nome1 + " = ?");
		stmt.setString(1, nome2);
		stmt.executeUpdate();
		
		c.commit();
		System.out.println("Dado deletado com sucesso!");
		
		stmt.close();
        c.close();
	}
	
	//Sobrecarga de delete para inteiro
	public static void delete(Connection c, String table, String nome1, int nome2) throws SQLException{
		c = conectarBanco();
		c.setAutoCommit(false);
		PreparedStatement stmt = null;
		
		stmt = c.prepareStatement("delete from " + table + " where " + nome1 + " = ?");
		stmt.setInt(1, nome2);
		stmt.executeUpdate();
		
		c.commit();
		System.out.println("Dado deletado com sucesso!");
		
		stmt.close();
        c.close();
	}
	
	//Função de select feita para testes
	public static void select(Connection c, String table) throws SQLException{
		c = conectarBanco();
		c.setAutoCommit(false);
		Statement stmt = null;
		
		stmt = c.createStatement();
		
		if(table.equals("cadastro")){
			ResultSet rs = stmt.executeQuery(Utils.cadastroS);
			while(rs.next()){
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String fone = rs.getString("fone");
				String tipo = rs.getString("tipo");
				System.out.println("Nome: " + nome);
				System.out.println("Email: " + email);
				System.out.println("CPF: " + cpf);
				System.out.println("Fone: " + fone);
				System.out.println("Tipo: " + tipo);
				System.out.println("");
			}
			rs.close();
			stmt.close();
			c.close();
		}
		else if(table.equals("despesas")){
			ResultSet rs = stmt.executeQuery(Utils.despesaS);
			while(rs.next()){
				String nome = rs.getString("nome");
				String freq = rs.getString("frequencia");
				String valor = rs.getString("valor");
				int id = rs.getInt("id");
				String venc = rs.getString("vencimento");
				String cpf = rs.getString("cpf");
				System.out.println("Nome: " + nome);
				System.out.println("Frequência: " + freq);
				System.out.println("Valor: " + valor);
				System.out.println("ID: " + id);
				System.out.println("Vencimento: " + venc);
				System.out.println("CPF: " + cpf);
				System.out.println("");
			}
		}
	}
	
	
}
