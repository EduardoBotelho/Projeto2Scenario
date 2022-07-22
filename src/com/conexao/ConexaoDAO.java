package com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {
	
	public Connection conectaBD() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/projetoScenario?user=root&password=210722";
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "ConexaoDAO" + e.getMessage());
			// TODO: handle exception
		}
		
		return conn;
		
	}
	

}
