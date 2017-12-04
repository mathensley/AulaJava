package am.utils;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import am.bd.Banco;
import am.main.Atividades;
import am.main.Cadastro;
import am.main.Despesas;

//Classe utilizada para fazer/facilitar operacoes
public class Utils {
	
	//Conectar banco
	public static String driver = "org.postgresql.Driver";
	public static String db_url = "jdbc:postgresql://localhost/banco";
	//Id
	public static String user = "postgres";
	public static String password = "123";
	//Tables insert
	public static String cadastro = "insert into cadastro values (?,?,?,?,?,?,?) ";
	public static String despesas = "insert into despesas values (?,?,?,?,?,?) ";
	public static String atividades = "insert into atividades values (?,?,?,?,?) ";	
	//Tables select
	public static String cadastroS = "select * from cadastro;";
	public static String despesaS = "select * from despesas;";
	
	//Cores
	public static Color laranjaClaro = new Color(255, 102, 43);
	public static Color laranjaEscuro = new Color(224, 123, 0);
	public static Color cinzaClaro = new Color(112, 112, 112);
	public static Color branco = new Color(255, 255, 255);
	public static Color preto = new Color(0, 0, 0);
	
	//Fonts
	public static Font f1 = new Font("Segoe UI Semibold", Font.BOLD, 18);
	public static Font f2 = new Font("Segoe UI Semibold", Font.BOLD, 26);
	
	//List
	//public static List<?> lista;
	
	//Verifica se a string eh nula, vazia ou se tem espacos
	public static boolean isVazia(String s){
		return (s == null || s.equals("") || s.trim().equals(""));
	}
	//Sobrecarga para um array de chars
	public static boolean isVazia(char[] c){
		String s = String.valueOf(c);
		
		return (s == null || s.equals("") || s.trim().equals(""));
	}
	
	
	//Validar senha
	public static boolean isSenha(char[] c){
		String s = String.valueOf(c);
		int cont = 0;
		
		if(s.length() >= 6){
			for(char i : c){
				if(Character.isDigit(i)){
					cont++;
					break;
				}
			}
			for(char i : c){
				if(Character.isAlphabetic(i)){
					cont++;
					break;
				}
			}
			if(cont == 2)
				return true;
			return false;
		}
		return false;
	}
	//Sobrecarga para confirmar senha
	public static boolean isSenha(char[] c1, char[] c2){
		String a = String.valueOf(c1), b = String.valueOf(c2);
		if(isSenha(c1)){
			return (a.equals(b));
		}
		return false;
	}
	
	
	//Validar cpf
	public static boolean isCPF(String CPF) {
			//considera-se erro CPF's formados por uma sequencia de numeros iguais
		    if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
		        CPF.equals("22222222222") || CPF.equals("33333333333") ||
		        CPF.equals("44444444444") || CPF.equals("55555555555") ||
		        CPF.equals("66666666666") || CPF.equals("77777777777") ||
		        CPF.equals("88888888888") || CPF.equals("99999999999") ||
		       (CPF.length() != 11))
		       return(false);

		    char dig10, dig11;
		    int sm, i, r, num, peso;

		    try {
		      // Calculo do 1o. Digito Verificador
		      sm = 0;
		      peso = 10;
		      for (i=0; i<9; i++) {              
		        // converte o i-esimo caractere do CPF em um numero:
		        // por exemplo, transforma o caractere '0' no inteiro 0         
		    	// (48 eh a posicao de '0' na tabela ASCII)         
		        num = (int)(CPF.charAt(i) - 48); 
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }

		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig10 = '0';
		      else dig10 = (char)(r + 48); //converte no respectivo caractere numerico

		      //Calculo do 2o. Digito Verificador
		      sm = 0;
		      peso = 11;
		      for(i=0; i<10; i++) {
		        num = (int)(CPF.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }

		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig11 = '0';
		      else dig11 = (char)(r + 48);

		      //Verifica se os digitos calculados conferem com os digitos informados.
		      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
		         return(true);
		      else return(false);
		    } catch (InputMismatchException erro) {
		        return(false);
		    }
	}
	
	
	//Validar email
	public static boolean isEmail(Connection c, String email){
		char[] e = email.toCharArray();
		int cont = 0;
		
		c = Banco.conectarBanco();
		
		try {
			c.setAutoCommit(false);
			
			for(char i : e){
				if(i == '@'){
					cont++;
					break;
				}
			}
			for(char i : e){
				if(i == '.'){
					cont++;
					break;
				}
			}
			if(cont == 2){
				Statement stmt = null;
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("select email from cadastro;");
				while(rs.next()){
					String em = rs.getString("email");
					if(em.equals(email)){
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
			c.close();
			return true;
		} catch (SQLException ev){
			ev.printStackTrace();
		}
		
		return false;
	}
	
	
	//Retorna um array com todos os cadastros de condôminos
	public static List<Cadastro> mostrarCondominos(Connection c){
		List<Cadastro> lista = new ArrayList<Cadastro>();
		Cadastro ca;
		c = Banco.conectarBanco();
		
		try {
			c.setAutoCommit(false);
			Statement stmt = null;
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from cadastro where tipo = 'Condômino' order by nome;");
			
			while(rs.next()){
				ca = new Cadastro();
				String n = rs.getString("nome");
				ca.setNome(n);
				String e = rs.getString("email");
				ca.setEmail(e);
				String cpf = rs.getString("cpf");
				ca.setCpf(cpf);
				String s = rs.getString("senha");
				ca.setSenha(s);
				String f = rs.getString("fone");
				ca.setFone(f);
				String ap = rs.getString("apto");
				ca.setApto(ap);
				String t = rs.getString("tipo");
				ca.setTipo(t);
				lista.add(ca);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException ev) {
			ev.printStackTrace();
		}
		
		return lista;
	}
	
	//
	public static List<Cadastro> mostrarSindicos(Connection c){
		List<Cadastro> lista = new ArrayList<Cadastro>();
		Cadastro ca;
		c = Banco.conectarBanco();
		
		try {
			c.setAutoCommit(false);
			Statement stmt = null;
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from cadastro where tipo = 'Síndico' order by nome;");
			
			while(rs.next()){
				ca = new Cadastro();
				String n = rs.getString("nome");
				ca.setNome(n);
				String e = rs.getString("email");
				ca.setEmail(e);
				String cpf = rs.getString("cpf");
				ca.setCpf(cpf);
				String s = rs.getString("senha");
				ca.setSenha(s);
				String f = rs.getString("fone");
				ca.setFone(f);
				String ap = rs.getString("apto");
				ca.setApto(ap);
				String t = rs.getString("tipo");
				ca.setTipo(t);
				lista.add(ca);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException ev) {
			ev.printStackTrace();
		}
		
		return lista;
	}
	
	//Retorna um array com todos as despesas cadastradas por sindico
	public static List<Despesas> mostrarDespesas(Connection c, String cp){
		List<Despesas> lista = new ArrayList<Despesas>();
		Despesas de;
		c = Banco.conectarBanco();
		
		try {
			c.setAutoCommit(false);
			Statement stmt = null;
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select *"
					+ " from despesas where cpf = '" + cp + "';");
			
			while(rs.next()){
				de = new Despesas();
				String nome = rs.getString("nome");
				de.setNome(nome);
				String freq = rs.getString("frequencia");
				de.setFrequencia(freq);
				String valor = rs.getString("valor");
				de.setValor(valor);
				int id = rs.getInt("id");
				de.setId(id);
				String venc = rs.getString("vencimento");
				de.setVencimento(venc);
				String cpf = rs.getString("cpf");
				de.setCpf(cpf);
				lista.add(de);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException ev) {
			ev.printStackTrace();
		}
		
		return lista;
	}
	
	//Retorna um array com todos as atividades cadastradas por sindico
	public static List<Atividades> mostrarAtividades(Connection c, String cp){
		List<Atividades> lista = new ArrayList<Atividades>();
		Atividades at;
		c = Banco.conectarBanco();
		
		try {
			c.setAutoCommit(false);
			Statement stmt = null;
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select *"
					+ " from atividades where cpf = '" + cp + "';");
			
			while(rs.next()){
				at = new Atividades();
				String nome = rs.getString("nome");
				at.setNome(nome);
				String data = rs.getString("data");
				at.setData(data);
				String status = rs.getString("status");
				at.setStatus(status);
				int id = rs.getInt("id");
				at.setId(id);
				String cpf = rs.getString("cpf");
				at.setCpf(cpf);
				lista.add(at);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException ev) {
			ev.printStackTrace();
		}
		
		return lista;
	}
	
}
