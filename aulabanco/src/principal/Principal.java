package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/banco", "postgres", "unipe");
			con.setAutoCommit(false);
			
			stmt = con.prepareStatement("Insert into cachorro values(?,?,?,?) ");
			stmt.setInt(1, 421);
			stmt.setString(2, "Hamsuke");
			stmt.setInt(3, 8);
			stmt.setString(4, "Matheus");
			stmt.executeUpdate();
			
		
			con.setAutoCommit(false);
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
			stmt.close();
		}
		
		
	}

}
