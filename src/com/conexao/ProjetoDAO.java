package com.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.ProjetoDTO;

public class ProjetoDAO {

	Connection conn;
	PreparedStatement pstm;
	
	public void cadastrarProjeto(ProjetoDTO objProjetoDTO) {
		
		String sql = "insert into Projeto(nome) values(?) ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objProjetoDTO.getNome());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null,"ProjetoDAO" + erro);
			// TODO: handle exception
		}
		
	}
}
